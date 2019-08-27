package com.nparo.codefellowship.controllers;

import com.nparo.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @Autowired
  ApplicationUserRepository applicationUserRepository;
  
  @GetMapping("/")
  public String getIndex(Model m) {
    return "index";
  }
  
  @GetMapping("/loginpage")
  public String getLogin() {
    return "loginpage";
  }
  
  @GetMapping("/signup")
  public String getSignUp() {
    return "signup";
  }
}
