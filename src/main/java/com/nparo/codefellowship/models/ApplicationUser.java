package com.nparo.codefellowship.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.sql.Date;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  
  String username;
  String password;
  String firstName;
  String lastName;
  Date dateOfBirth;
  String bio;
  
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "applicationUser")
  List<Post> posts;
  
  public ApplicationUser() {}
  
  public ApplicationUser(String username, String password, String firstName, String lastName, Date dateOfBirth,
                         String bio) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.bio = bio;
  }
  
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }
  
  @Override
  public String getPassword () {
    return this.password;
  }
  
  @Override
  public String getUsername () {
    return this.username;
  }
  
  public Long getId () {
    return this.id;
  }
  
  public String getFirstName () {
    return this.firstName;
  }
  
  public String getLastName () {
    return this.lastName;
  }
  
  public Date getDateOfBirth () {
    return this.dateOfBirth;
  }
  
  public String getBio () {
    return this.bio;
  }
  
  public List<Post> getPosts() {
    return this.posts;
  }
  
  @Override
  public boolean isAccountNonExpired () {
    return true;
  }
  
  @Override
  public boolean isAccountNonLocked () {
    return true;
  }
  
  @Override
  public boolean isCredentialsNonExpired () {
    return true;
  }
  
  @Override
  public boolean isEnabled () {
    return true;
  }
  
}
