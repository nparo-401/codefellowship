package com.nparo.codefellowship.controllers;

import com.nparo.codefellowship.models.ApplicationUser;
import com.nparo.codefellowship.models.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    return new RedirectView("/myprofile");
  }

  @GetMapping("/myprofile")
  public String getMyProfile(Principal p, Model m) {
    ApplicationUser applicationUser = applicationUserRepository.findByUsername(p.getName());
    m.addAttribute("applicationUser", applicationUser);
    return "myprofile";
  }
  
  @GetMapping("/users")
  public String getAllUsers(Principal p, Model m) {
    ApplicationUser applicationUser = applicationUserRepository.findByUsername(p.getName());
    List<ApplicationUser> allUsers = applicationUserRepository.findAll();
    m.addAttribute("applicationUser", applicationUser);
    m.addAttribute("allUsers", allUsers);
    return "users";
  }
  
  @GetMapping("/users/{id}")
  public String getOneUser(@PathVariable long id, Principal p, Model m) {
    ApplicationUser otherUser = applicationUserRepository.findById(id).get();
    ApplicationUser currentUser = applicationUserRepository.findByUsername(p.getName());
    m.addAttribute("otherUser", otherUser);
    m.addAttribute("currentUser", currentUser);
    return "singleUser";
  }
  
  @PostMapping("/users/follow")
  public RedirectView addFollower(long followedUser, Principal p) {
    ApplicationUser primaryUser = applicationUserRepository.findByUsername(p.getName());
    primaryUser.addFollower(applicationUserRepository.findById(followedUser).get());
    applicationUserRepository.save(primaryUser);
    return new RedirectView("/users");
  }
  
  @PostMapping("/users/unfollow")
  public RedirectView removeFollower(long unfollowedUser, Principal p) {
    ApplicationUser primaryUser = applicationUserRepository.findByUsername(p.getName());
    primaryUser.removeFollower(applicationUserRepository.findById(unfollowedUser).get());
    applicationUserRepository.save(primaryUser);
    return new RedirectView("/users");
  }
}
