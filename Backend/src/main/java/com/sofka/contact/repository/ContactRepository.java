package com.sofka.contact.repository;

import com.sofka.contact.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    @Modifying
    @Query("update Contact con set con.namePerson = :namePerson where con.id = :id")
    public void updateName(
            @Param(value = "id") Long id,
            @Param(value = "namePerson") String namePerson
    );

    @Modifying
    @Query("update Contact con set con.phone = :phone where con.id = :id")
    public void updatePhone(
            @Param(value = "id") Long id,
            @Param(value = "phone") String phone
    );

    @Modifying
    @Query("update Contact con set con.email = :email where con.id = :id")
    public void updateEmail(
            @Param(value = "id") Long id,
            @Param(value = "email") String email
    );

    @Modifying
    @Query("update Contact con set con.dateBirth = :dateBirth where con.id = :id")
    public void updateDateBirth(
            @Param(value = "id") Long id,
            @Param(value = "dateBirth") Date dateBirth
    );

    @Modifying
    @Query("update Contact con set con.isDeleted = :isDeleted where con.id = :id")
    public void updateIsDeleted(
            @Param(value = "id") Long id,
            @Param(value = "isDeleted") int isDeleted
    );

}
