package io.challenge.jahia.contacts.controller;

import io.challenge.jahia.contacts.model.Contact;
import io.challenge.jahia.contacts.repository.ContactRepository;
import io.challenge.jahia.contacts.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/contact")
public class ContactController {

  @Autowired
  ContactService contactService;

  @Operation(summary = "GET LIST OF CONTACTS")
  @GetMapping
  public ResponseEntity<List<Contact>> getAllContacts() {
    return new ResponseEntity<>(contactService.getContacts(), HttpStatus.OK);
  }

  @Operation(summary = "GET CONTACT BY ID")
  @GetMapping("/{id}")
  public ResponseEntity<Contact> getContactById(@PathVariable("id") long id) throws Exception {
    return new ResponseEntity<>(contactService.getContact(id), HttpStatus.OK);
  }

  @Operation(summary = "UPDATE CONTACT")
  @PutMapping("/{id}")
  public ResponseEntity<Contact> updateContact(@PathVariable("id") long id, @RequestBody Contact contact)
          throws Exception {
    return new ResponseEntity<>(contactService.updateContact(id, contact), HttpStatus.OK);
  }

  @Operation(summary = "CREATE NEW CONTACT")
  @PostMapping
  public ResponseEntity<Contact> saveContact(@NotNull @RequestBody Contact contact) {
    return new ResponseEntity<>(contactService.createContact(contact), HttpStatus.OK);
  }

  @Operation(summary = "DELETE CONTACT BY ID")
  @DeleteMapping("/{id}")
  public ResponseEntity<Boolean> deleteContactById(@PathVariable("id") long id) {
    contactService.deleteContact(id);
    return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
  }

}
