package io.challenge.jahia.contacts.service;

import io.challenge.jahia.contacts.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    public List<Contact> getContacts();

    public Contact getContact(long id);

    public List<Contact> findContactByFullName(String fullName);

    public Contact createContact(Contact contact);

    public Contact updateContact(long id, Contact contact);

    public Contact deleteContact(long id);

}
