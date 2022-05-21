package com.sofka.contact.service;

import com.sofka.contact.domain.Contact;

import java.util.List;
import java.util.Optional;


public interface IContactFormService {

    List<Contact> list();

    Contact save(Contact contact);

    Contact update(Long id, Contact contact);

    void delete(Contact contact);

    Optional<Contact> findContact(Contact contact);

}