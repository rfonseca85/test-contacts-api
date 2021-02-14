package io.challenge.jahia.contacts.config;

import io.challenge.jahia.contacts.model.Contact;
import io.challenge.jahia.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoad {

    @Autowired
    ContactService contactService;

    @Bean
    CommandLineRunner loadingInitialData() {

        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Rafael Fonseca","rfonseca85@yahoo.ca","6479632054", "Tech Lead"));
        contactList.add(new Contact("Bill Gates","superbill-gates@microsoft.com","932932932", "Microsoft Founder"));
        contactList.add(new Contact("Linus Torvalds","linux-my-life@yahoo.ca","3219632054", "Linux Foundation"));

        return args -> contactList.forEach(contact -> contactService.createContact(contact));
    }
}
