package io.challenge.jahia.contacts.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.challenge.jahia.contacts.model.Contact;
import io.challenge.jahia.contacts.service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ContactControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ContactService contactService;

  private final String endpoint = "/contact";

  private ObjectMapper objectMapper;

  @BeforeEach
  public void setup() {
    objectMapper = new ObjectMapper();
  }


  @Test
  public void testCreatingNewContact() throws Exception {
    Contact contactToCheck = new Contact("Rafael Fonseca", "rfonseca85@yahoo.ca", "6479632054", "Tech Lead");
    when(contactService.createContact(contactToCheck)).thenReturn(contactToCheck);
    mockMvc.perform(post(endpoint).content(objectMapper.writeValueAsBytes(contactToCheck))
            .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
  }

  @Test
  public void testGetAllContacts() throws Exception {
    when(contactService.getContacts()).thenReturn(
            Arrays.asList(new Contact("Dennis Ritchie", "c@planguage.com", "12333123312", "just C"),
                    new Contact("Martin Fowler", "mfowler@gmail.com", "3219632054", "Books and more books"),
                    new Contact("Mark Zuckerberg", "zuzuck@facebook.com", "932932932", "No Privacy"),
                    new Contact("Rafael Fonseca", "rfonseca85@yahoo.ca", "6479632054", "Tech Lead"),
                    new Contact("Linus Torvalds", "linux-my-life@yahoo.ca", "3219632054", "Better than windows"),
                    new Contact("Larry Page", "larryForFun@google.com", "123123", "Google it")));
    mockMvc.perform(get(endpoint)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(6)));
  }

  @Test
  public void testNoContactsReturned() throws Exception {
    when(contactService.getContacts()).thenReturn(new ArrayList<>());
    mockMvc.perform(get(endpoint)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(0)));
  }

  @Test
  public void testOneContactFound() throws Exception {
    Contact contactToCheck = new Contact("Rafael Fonseca", "rfonseca85@yahoo.ca", "6479632054", "Tech Lead");

    when(contactService.getContact(contactToCheck.getId())).thenReturn(contactToCheck);
    mockMvc.perform(get(endpoint + "/{id}", contactToCheck.getId())).andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(contactToCheck.getId()))
            .andExpect(jsonPath("$.fullName").value(contactToCheck.getFullName()))
            .andExpect(jsonPath("$.mobile").value(contactToCheck.getMobile()));
  }

  @Test
  public void testDeleteExistingContact() throws Exception {
    Contact contactToCheck = new Contact("Rafael Fonseca", "rfonseca85@yahoo.ca", "6479632054", "Tech Lead");

    when(contactService.deleteContact(contactToCheck.getId())).thenReturn(contactToCheck);
    mockMvc.perform(delete(endpoint + "/{id}", contactToCheck.getId())).andExpect(status().isOk());
  }


}
