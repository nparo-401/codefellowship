package com.nparo.codefellowship.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
  public Post findByApplicationUser(String applicationUser);
}
