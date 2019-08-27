package com.nparo.codefellowship.controllers;

import com.nparo.codefellowship.models.ApplicationUser;
import com.nparo.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.sql.Date;

@Controller
public class ApplicationUserController {
  @Autowired
  PasswordEncoder encoder;
  
  @Autowired
  ApplicationUserRepository applicationUserRepository;
  
  @PostMapping("/users")
  public RedirectView createUser(String username, String password, String firstName, String lastName,
                                 String dateOfBirth, String bio) {
    ApplicationUser newUser = new ApplicationUser(username, encoder.encode(password), firstName, lastName,
     Date.valueOf(dateOfBirth), bio);
    applicationUserRepository.save(newUser);
    Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
    SecurityContextHolder.getContext().setAuthentication(authentication);
    return new RedirectView("/");
  }
  
  @GetMapping("login")
  public String getLoginPage() {
    return "login";
  }
}
