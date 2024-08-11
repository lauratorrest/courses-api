package com.courses.service.impl;

import com.courses.model.User;
import com.courses.repository.user.UserDto;
import com.courses.repository.user.UserMapper;
import com.courses.repository.user.UserRepository;
import com.courses.service.UserService;
import com.courses.service.exception.NoUserWithGivenEmailException;
import com.courses.service.exception.WrongPasswordException;
import com.courses.shared.exceptions.ExceptionCode;
import com.courses.shared.utils.StringFixProcesses;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final StringFixProcesses stringFixProcesses;
  private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
  private final MessageSource messageSource;

  @Override
  public void saveNewUser(User user) {
    user.setName(stringFixProcesses.removeSpaces(user.getName()));
    user.setProfession(stringFixProcesses.removeSpaces(user.getProfession()));
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    UserDto userDto = UserMapper.INSTANCE.toDto(user);
    userDto.onCreate();
    userRepository.save(userDto);
  }

  @Override
  public User authenticateUser(String email, String password) {
    Optional<UserDto> userDto = userRepository.findByEmail(email);

    if(userDto.isPresent()){
      if(passwordEncoder.matches(password, userDto.get().getPassword())){
        return UserMapper.INSTANCE.toEntity(userDto.get());
      }else{
        throw new WrongPasswordException(
            messageSource.getMessage(ExceptionCode.WRONG_PASSWORD.getType(), null,
                LocaleContextHolder.getLocale())
        );
      }

    }else {
      throw new NoUserWithGivenEmailException(
          messageSource.getMessage(ExceptionCode.USER_WITH_EMAIL_NOT_FOUND.getType(), new Object[] {email}, LocaleContextHolder.getLocale())
      );
    }
  }
}
