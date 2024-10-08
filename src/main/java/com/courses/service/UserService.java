package com.courses.service;

import com.courses.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    void saveNewUser(User model);

    User authenticateUser(String email, String password);

    void updateUserData(User model);

    void setUserProfilePicture(MultipartFile picture, String userId);

    void addUserNewCourse(String userId, String courseId);

    User getUserById(String id);

    void courseToCart(String userId, String courseId);
}
