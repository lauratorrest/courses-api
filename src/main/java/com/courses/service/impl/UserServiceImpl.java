package com.courses.service.impl;

import com.courses.model.User;
import com.courses.repository.user.UserDto;
import com.courses.repository.user.UserMapper;
import com.courses.repository.user.UserRepository;
import com.courses.service.CloudinaryService;
import com.courses.service.UserService;
import com.courses.service.exception.authentication.NoUserWithGivenEmailException;
import com.courses.service.exception.user.UserDoesNotExistException;
import com.courses.service.exception.authentication.WrongPasswordException;
import com.courses.shared.exceptions.ExceptionCode;
import com.courses.shared.utils.Constants;
import com.courses.shared.utils.StringFixProcesses;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StringFixProcesses stringFixProcesses;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    private final MessageSource messageSource;
    private final CloudinaryService cloudinaryService;

    @Override
    public void saveNewUser(User user) {
        user.setName(stringFixProcesses.removeSpaces(user.getName()));
        user.setProfession(stringFixProcesses.removeSpaces(user.getProfession()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedDate(LocalDateTime.now());
        UserDto userDto = UserMapper.INSTANCE.toDto(user);
        userRepository.save(userDto);
    }

    @Override
    public User authenticateUser(String email, String password) {
        Optional<UserDto> userDto = userRepository.findByEmail(email);

        if (userDto.isEmpty()) {
            throw new NoUserWithGivenEmailException(
                    messageSource.getMessage(ExceptionCode.USER_WITH_EMAIL_NOT_FOUND.getType(),
                            new Object[]{email}, LocaleContextHolder.getLocale())
            );
        } else {
            if (passwordEncoder.matches(password, userDto.get().getPassword())) {
                return UserMapper.INSTANCE.toEntity(userDto.get());
            } else {
                throw new WrongPasswordException(
                        messageSource.getMessage(ExceptionCode.WRONG_PASSWORD.getType(), null,
                                LocaleContextHolder.getLocale())
                );
            }
        }
    }

    @Override
    public void updateUserData(User user) {
        UserDto currentUser = userExistsValidation(user.getId());

        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setWebPageUrl(user.getWebPageUrl());
        currentUser.setLinkedInUrl(user.getLinkedInUrl());
        currentUser.setYoutubeChannelUrl(user.getYoutubeChannelUrl());
        currentUser.setFacebookUrl(user.getFacebookUrl());
        currentUser.setInstagramUrl(user.getInstagramUrl());
        currentUser.setProfilePictureUrl(user.getProfilePictureUrl());
        currentUser.setProfession(user.getProfession());
        currentUser.setAboutMe(user.getAboutMe());
        currentUser.setUpdatedDate(LocalDateTime.now());

        userRepository.save(currentUser);
    }

    @Override
    public void setUserProfilePicture(MultipartFile picture, String userId) {
        UserDto user = userExistsValidation(userId);

        if (picture == null || picture.isEmpty()) {
            if (user.getProfilePictureUrl() != null) {
                user.setUpdatedDate(LocalDateTime.now());
            }

            user.setProfilePictureUrl(null);
        } else {
            String pictureUrl = cloudinaryService.uploadFile(picture, Constants.PROFILE_PIC_FOLDER_NAME,
                    Constants.FILE_TYPE_FOR_PICS_ALLOWED, Constants.PICS_MAX_SIZE);
            user.setProfilePictureUrl(pictureUrl);
            user.setUpdatedDate(LocalDateTime.now());
        }

        userRepository.save(user);
    }

    @Override
    public void addUserNewCourse(String userId, String courseId) {
        UserDto user = userExistsValidation(userId);

        if (user.getMadeCoursesIds() == null) {
            user.setMadeCoursesIds(new ArrayList<>());
        }

        user.getMadeCoursesIds().add(courseId);
        userRepository.save(user);
    }

    @Override
    public User getUserById(String id) {
        return UserMapper.INSTANCE.toEntity(userExistsValidation(id));
    }

    @Override
    public void courseToCart(String userId, String courseId) {
        UserDto user = userExistsValidation(userId);

        if (Objects.isNull(user.getCartCoursesIds())) {
            user.setCartCoursesIds(new ArrayList<>());
        }

        if (user.getCartCoursesIds().stream().anyMatch(id -> Objects.equals(courseId, id))) {
            user.getCartCoursesIds().remove(courseId);
        } else {
            user.getCartCoursesIds().add(courseId);
        }

        userRepository.save(user);
    }

    private UserDto userExistsValidation(String id) {
        Optional<UserDto> userDto = userRepository.findById(id);
        if (userDto.isPresent()) {
            return userDto.get();
        } else {
            throw new UserDoesNotExistException(
                    messageSource.getMessage(ExceptionCode.USER_NOT_FOUND.getType(), null,
                            LocaleContextHolder.getLocale())
            );
        }
    }
}
