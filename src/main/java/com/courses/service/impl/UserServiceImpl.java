package com.courses.service.impl;

import com.courses.model.User;
import com.courses.repository.user.UserDto;
import com.courses.repository.user.UserMapper;
import com.courses.repository.user.UserRepository;
import com.courses.service.CloudinaryService;
import com.courses.service.UserService;
import com.courses.service.exception.FileTypeNotAllowedException;
import com.courses.service.exception.NoUserWithGivenEmailException;
import com.courses.service.exception.TooBigFileException;
import com.courses.service.exception.UserDoesNotExistException;
import com.courses.service.exception.WrongPasswordException;
import com.courses.shared.exceptions.ExceptionCode;
import com.courses.shared.utils.Constants;
import com.courses.shared.utils.StringFixProcesses;
import java.time.LocalDateTime;
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

  private static final long MAX_SIZE = 5 * 1024 * 1024;

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
    User currentUser = userExistsValidation(user.getId());

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

    userRepository.save(UserMapper.INSTANCE.toDto(currentUser));
  }

  @Override
  public void setUserProfilePicture(MultipartFile picture, String userId) {
    User user = userExistsValidation(userId);

    if (picture == null || picture.isEmpty()) {
      if (user.getProfilePictureUrl() != null) {
        user.setUpdatedDate(LocalDateTime.now());
      }

      user.setProfilePictureUrl(null);
    } else {
      if (!Constants.FILE_TYPE_FOR_PICS_ALLOWED.matcher(
          Objects.requireNonNull(picture.getOriginalFilename())).matches()) {
        throw new FileTypeNotAllowedException(messageSource.getMessage(
            ExceptionCode.FILE_TYPE_NOT_ALLOWED.getType(), null, LocaleContextHolder.getLocale()
        ));
      }

      if (picture.getSize() > MAX_SIZE) {
        throw new TooBigFileException(
            this.messageSource.getMessage(ExceptionCode.FILE_EXCEEDS_ALLOWED_SIZE.getType(),
                new Object[]{MAX_SIZE / 1024}, LocaleContextHolder.getLocale()));
      }

      String pictureUrl = cloudinaryService.uploadFile(picture, "profile-pics");
      user.setProfilePictureUrl(pictureUrl);
      user.setUpdatedDate(LocalDateTime.now());
    }

    userRepository.save(UserMapper.INSTANCE.toDto(user));
  }

  private User userExistsValidation(String id) {
    Optional<UserDto> userDto = userRepository.findById(id);
    if (userDto.isPresent()) {
      return UserMapper.INSTANCE.toEntity(userDto.get());
    } else {
      throw new UserDoesNotExistException(
          messageSource.getMessage(ExceptionCode.USER_NOT_FOUND.getType(), null,
              LocaleContextHolder.getLocale())
      );
    }
  }
}
