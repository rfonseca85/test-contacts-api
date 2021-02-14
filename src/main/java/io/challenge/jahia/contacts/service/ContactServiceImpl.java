package io.challenge.jahia.contacts.service;

import io.challenge.jahia.contacts.model.Contact;
import io.challenge.jahia.contacts.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

  @Autowired
  ContactRepository contactRepository;

  @Override
  public Contact getContact(long id) {
    return contactRepository.findById(id);
  }

  @Override
  public List<Contact> getContacts() {
    return contactRepository.findAll();
  }

  @Override
  public Contact createContact(Contact contact) {
    return contactRepository.save(contact);
  }

  @Override
  public Contact updateContact(long id, Contact contact) {
    Contact contactToUpdate = contactRepository.findById(id);
    contactToUpdate.setFullName(contact.getFullName());
    contactToUpdate.setEmail(contact.getEmail());
    contactToUpdate.setMobile(contact.getMobile());
    contactToUpdate.setDescription(contact.getDescription());
    return contactRepository.save(contactToUpdate);
  }

  @Override
  public Contact deleteContact(long id) {
    final Contact contact = contactRepository.findById(id);
    contactRepository.delete(contact);
    return contact;
  }

  @Override
  public List<Contact> findContactByFullName(String fullName) {
    return contactRepository.findByFullName(fullName);
  }

}
