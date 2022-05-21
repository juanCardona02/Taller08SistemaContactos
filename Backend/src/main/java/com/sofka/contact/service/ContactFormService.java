package com.sofka.contact.service;

import com.sofka.contact.domain.Contact;

import com.sofka.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContactFormService implements IContactFormService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        List<Contact> contacts = null;
        try {
            contacts = (List<Contact>) contactRepository.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return contacts;
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    @Transactional
    public Contact update(Long id, Contact contact) {
        contact.setId(id);
        return contactRepository.save(contact);
    }

    @Transactional
    public void updateName(Long id, Contact contact) {
        contactRepository.updateName(id, contact.getNamePerson());
    }

    @Transactional
    public void updatePhone(Long id, Contact contact) {
        contactRepository.updatePhone(id, contact.getPhone());
    }

    @Transactional
    public void updateEmail(Long id, Contact contact) {
        contactRepository.updateEmail(id, contact.getEmail());
    }
    @Transactional
    public void updateDateBirth(Long id, Contact contact) {
        contactRepository.updateDateBirth(id, contact.getDateBirth());
    }
    @Override
    @Transactional
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findContact(Contact contact) {
        return contactRepository.findById(contact.getId());
    }

    @Transactional
    public void updateIsDeleted(Long id, Contact contact) {
        contactRepository.updateIsDeleted(id, contact.getIsDeleted());
    }
}
