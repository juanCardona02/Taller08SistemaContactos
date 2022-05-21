package com.sofka.contact.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cont_id")
    private Long id;

    @Column(name = "cont_name_person")
    private String namePerson;

    @Column(name = "cont_phone")
    private String phone;

    @Column(name = "cont_email")
    private String email;

    @Column(name = "cont_datebirth")
    private Date dateBirth;

    @Column(name = "cont_is_deleted")
    private int isDeleted;
}

