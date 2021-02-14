package io.challenge.jahia.contacts;

import io.challenge.jahia.contacts.model.Contact;
import io.challenge.jahia.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JahiaContactsApiDataLoad {

  @Autowired
  ContactService contactService;

  @Bean
  CommandLineRunner loadingInitialData() {

    List<Contact> contactList = new ArrayList<>();
    contactList.add(new Contact("Dennis Ritchie", "c@planguage.com", "12333123312", "just C"));
    contactList.add(new Contact("Martin Fowler", "mfowler@gmail.com", "3219632054", "Books and more books"));
    contactList.add(new Contact("Mark Zuckerberg", "zuzuck@facebook.com", "932932932", "No Privacy"));
    contactList.add(new Contact("Rafael Fonseca", "rfonseca85@yahoo.ca", "6479632054", "Tech Lead"));
    contactList.add(new Contact("Linus Torvalds", "linux-my-life@yahoo.ca", "3219632054", "Better than windows"));
    contactList.add(new Contact("Larry Page", "larryForFun@google.com", "123123", "Google it"));

    return args -> contactList.forEach(contact -> contactService.createContact(contact));
  }
}
