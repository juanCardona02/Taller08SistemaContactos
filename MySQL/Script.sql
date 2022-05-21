-----------------------------------------
-----CREATE DATABASE
-----------------------------------------

CREATE DATABASE contact_form

-----------------------------------------
-----TABLE CONTACT
-----------------------------------------

CREATE TABLE contact (
  cont_id int unsigned NOT NULL AUTO_INCREMENT,
  cont_name_person varchar(25) NOT NULL,
  cont_phone varchar(12) NOT NULL,
  cont_email varchar(45) NOT NULL,
  cont_datebirth date NOT NULL,
  cont_is_deleted tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (cont_id)
) ENGINE=InnoDB;
