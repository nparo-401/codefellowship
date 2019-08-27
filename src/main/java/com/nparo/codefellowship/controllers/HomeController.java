package com.nparo.codefellowship.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {
  @GetMapping("/")
  public String getIndex(Principal p, Model m) {
    m.addAttribute("user", p);
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
