package com.nparo.codefellowship.controllers;

import com.nparo.codefellowship.models.ApplicationUser;
import com.nparo.codefellowship.models.ApplicationUserRepository;
import com.nparo.codefellowship.models.Post;
import com.nparo.codefellowship.models.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Controller
public class PostController {
  @Autowired
  PostRepository postRepository;
  
  @Autowired
  ApplicationUserRepository applicationUserRepository;
  
  @GetMapping("/post")
  public String getPost(Principal p, Model m) {
    ApplicationUser applicationUser = applicationUserRepository.findByUsername(p.getName());
    m.addAttribute("applicationUser", applicationUser);
    return "post";
  }
  
  @PostMapping("/post")
  public RedirectView createPost(String body, Principal p) {
    ApplicationUser applicationUser = applicationUserRepository.findByUsername(p.getName());
    Post post = new Post(body, new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Timestamp.valueOf(LocalDateTime.now())),
     applicationUser);
    postRepository.save(post);
    return new RedirectView("/post");
  }
}
