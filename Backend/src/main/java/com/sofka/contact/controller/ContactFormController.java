package com.sofka.contact.controller;

import com.sofka.contact.domain.Contact;
import com.sofka.contact.service.ContactFormService;
import com.sofka.contact.utility.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ContactFormController {

    @Autowired
    private ContactFormService contactFormService;

    private Response response = new Response();

    @GetMapping(path = "/contacts")
    public List<Contact> list() {
        return contactFormService.list();
    }

    @GetMapping(path = "/contact/{id}")
    public Optional<Contact> getContact(Contact contact) {
        return contactFormService.findContact(contact);
    }

    @PostMapping(path = "/contact")
    public ResponseEntity<Contact> create(Contact contact) {
        log.info("Contacto a crear: {}", contact);
        contactFormService.save(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    @PutMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> uptade(Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contact);
        contactFormService.update(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PatchMapping(path = "/contact/namePerson/{id}")
    public ResponseEntity<Contact> updateName(Contact contact, @PathVariable("id") Long id) {
        log.info("Usuario a modificar nombre: {}", contact);
        contactFormService.updateName(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);

    }

    @PatchMapping(path = "/contact/phone/{id}")
    public ResponseEntity<Contact> updatePhone(Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a modifcicar: {}", contact);
        contactFormService.updatePhone(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PatchMapping(path = "/contact/email/{id}")
    public ResponseEntity<Contact> updateEmail(Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contact);
        contactFormService.updateEmail(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PatchMapping(path = "/contact/dateBirth/{id}")
    public ResponseEntity<Contact> updateDateBirth(Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a modificar: {}", contact);
        contactFormService.updateDateBirth(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PatchMapping(path = "/contact/isdeleted/{id}")
    public ResponseEntity<Contact> updateIsDeleted(Contact contact, @PathVariable("id") Long id) {
        log.info("Contacto a borrar: {}", contact);
        contactFormService.updateIsDeleted(id, contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @DeleteMapping(path = "/contact/{id}")
    public ResponseEntity<Contact> delete(Contact contact) {
        log.info("Contacto a borrar: {}", contact);
        contactFormService.delete(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }
}

