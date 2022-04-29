package io.challenge.jahia.contacts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Esse codigo eh legal
public class Contact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  //Esse full name eh bom.
  private String fullName;
  private String email;
  private String mobile;
  private String description;

}

