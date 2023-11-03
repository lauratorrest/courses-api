package com.courses.api.application.usercourse;

import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.courses.api.application.usercourse.purchase.PaymentService;
import com.courses.api.domain.entity.ClientToken;
import com.courses.api.domain.entity.Purchase;
import com.courses.api.domain.entity.User;
import com.courses.api.domain.entity.UserCourse;
import com.courses.api.domain.service.usercourse.UserCourseSaveService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserCourseSaveApplication {
  private final UserCourseSaveService userCourseSaveService;
  private final PaymentService paymentService;

  public void saveUserCourse(UserCourse userCourse, User user){
    userCourse.setPurchaseDate(LocalDateTime.now());
    userCourse.setUser(user);
    userCourseSaveService.saveUserCourse(userCourse);
  }

  public ClientToken getToken(){
    return paymentService.getToken();
  }

  public Result<Transaction> checkout(Purchase purchase){
    return paymentService.checkout(purchase);
  }
}
