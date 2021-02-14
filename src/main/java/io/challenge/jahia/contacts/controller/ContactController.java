package io.challenge.jahia.contacts.controller;

import io.challenge.jahia.contacts.model.Contact;
import io.challenge.jahia.contacts.repository.ContactRepository;
import io.challenge.jahia.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return new ResponseEntity<>(contactService.getContacts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") long id) throws Exception {
        return new ResponseEntity<>(contactService.getContact(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") long id, @RequestBody Contact contact) throws Exception {
        return new ResponseEntity<>(contactService.updateContact(id, contact), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contact> saveContact(@NotNull @RequestBody Contact contact) {
        return new ResponseEntity<>(contactService.createContact(contact), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteContact(@PathVariable("id") long id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
