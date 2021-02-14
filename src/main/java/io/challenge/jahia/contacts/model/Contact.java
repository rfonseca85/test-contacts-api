package io.challenge.jahia.contacts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String fullName;
  private String email;
  private String mobile;
  private String description;

  public Contact() {
    super();
  }

  public Contact(String fullName, String email, String mobile, String description) {
    super();
    this.fullName = fullName;
    this.email = email;
    this.mobile = mobile;
    this.description = description;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Contact{" + "id=" + id + ", fullName='" + fullName + '\'' + ", email='" + email + '\'' + ", mobile='" +
            mobile + '\'' + ", description='" + description + '\'' + '}';
  }
}

