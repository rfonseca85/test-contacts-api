package io.challenge.jahia.contacts;

import io.challenge.jahia.contacts.model.Contact;
import io.challenge.jahia.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//Adding Lombok

@Component
public class JahiaContactsApiDataLoad {

    @Autowired
    ContactService contactService;

    @Bean
    CommandLineRunner loadingInitialData() {

        List<Contact> contactList = List.of(
                Contact.builder().fullName("Dennis Ritchie").email("c@planguage.com").mobile("12333123312").description("just C").build(),
                Contact.builder().fullName("Mark Zuckerberg").email("zuzuck@facebook.com").mobile("932932932").description("No Privacy").build(),
                Contact.builder().fullName("Rafael Fonseca").email("rfonseca85@yahoo.ca").mobile("6479632054").description("Tech Lead").build(),
                Contact.builder().fullName("Linus Torvalds").email("linux-my-life@yahoo.ca").mobile("3219632054").description("Better than windows").build(),
                Contact.builder().fullName("Larry Page").email("larryForFun@google.com").mobile("123123").description("Google it").build()
        );

        return args -> contactList.forEach(contact -> contactService.createContact(contact));
    }
}
