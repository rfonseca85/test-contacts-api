package io.challenge.jahia.contacts.repository;

import io.challenge.jahia.contacts.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
  List<Contact> findByFullName(String fullName);

  Contact findById(long id);
}
