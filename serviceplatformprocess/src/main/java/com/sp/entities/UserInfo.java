package com.sp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_detail", catalog="Practice", schema="dbo")
public class UserInfo
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long user;
  
  public Long getUser()
  {
    return user;
  }

  public void setUser(Long user)
  {
    this.user = user;
  }

  @Column(name = "email")
  private String email;

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }
}
