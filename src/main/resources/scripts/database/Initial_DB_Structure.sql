CREATE TABLE IF NOT EXISTS 
`SanitasTest`.`person` (
  `id` VARCHAR(36) NOT NULL,
  `name` VARCHAR(20) NULL,
  `middle_name` VARCHAR(20) NULL,
  `last_name` VARCHAR(45) NULL,
  `preferred_name` VARCHAR(20) NULL,
  `physiological_gender_fk` TINYINT NOT NULL,
  `preferred_gender_fk` TINYINT NULL,
  `government_id` VARCHAR(60) NULL,
  `date_of_birth` DATETIME NULL,
  `date_of_decease` DATETIME NULL,
  `created_date` DATETIME NOT NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NULL,
  `last_updated_by` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (physiological_gender_fk)
    REFERENCES gender(id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (preferred_gender_fk)
    REFERENCES gender(id)
    ON UPDATE CASCADE ON DELETE RESTRICT);
  
CREATE TABLE IF NOT EXISTS 
`SanitasTest`.`country` (
  `id` INT NOT NULL,
  `phone_code` INT NOT NULL,
  `name` VARCHAR(60) NULL,
  `official_name` VARCHAR(60) NULL,
  `iso_alpha_2` VARCHAR(2) NOT NULL,
  `iso_alpha_3` VARCHAR(3) NULL,
  `created_date` DATETIME NOT NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NULL,
  `last_updated_by` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS 
`SanitasTest`.`country_specific_address_fields` (
  `id` INT NOT NULL,
  `fields` JSON NULL,
  `created_date` DATETIME NOT NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NULL,
  `last_updated_by` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS
`SanitasTest`.`geo_address` (
  `id` INT NOT NULL,
  `address_line_1` VARCHAR(45) NOT NULL,
  `address_line_2` VARCHAR(45) NULL,
  `locality` VARCHAR(45) NULL,
  `region` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `person_id_fk` VARCHAR(36) NOT NULL,
  `country_id_fk` INT NOT NULL,
  `country_specific_address_fields_id` INT NULL,
  `created_date` DATETIME NOT NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NULL,
  `last_updated_by` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (person_id_fk)
    REFERENCES person(id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (country_id_fk)
    REFERENCES country(id)
    ON UPDATE CASCADE ON DELETE RESTRICT);
  
CREATE TABLE IF NOT EXISTS
`SanitasTest`.`phone_number` (
  `id` INT NOT NULL,
  `country_code` INT NOT NULL,
  `area_code` INT NULL,
  `dial_number` VARCHAR(45) NOT NULL,
  `options` VARCHAR(45) NULL,
  `person_id_fk` VARCHAR(36) NOT NULL,
  `created_date` DATETIME NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NULL,
  `last_updated_by` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (person_id_fk)
    REFERENCES person(id)
    ON UPDATE CASCADE ON DELETE RESTRICT);

CREATE TABLE IF NOT EXISTS
`SanitasTest`.`person_relationships` (
  `id` INT NOT NULL,
  `person1_id_fk` VARCHAR(36) NOT NULL,
  `person2_id_fk` VARCHAR(36) NOT NULL,
  `relationship_type_fk` SMALLINT NULL,
  `address_fk` INT NULL,
  `start_date` DATETIME NULL,
  `end_date` DATETIME NULL,
  `created_date` DATETIME NOT NULL,
  `created_by` VARCHAR(45) NOT NULL,
  `last_updated_date` DATETIME NULL,
  `last_updated_by` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (person1_id_fk)
    REFERENCES person(id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (person2_id_fk)
    REFERENCES person(id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (relationship_type_fk)
    REFERENCES relationship_type(id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (address_fk)
    REFERENCES geo_address(id)
    ON UPDATE CASCADE ON DELETE RESTRICT);

CREATE TABLE IF NOT EXISTS
`SanitasTest`.`audit_trail` (
  `id` BIGINT NOT NULL,
  `entity_id` VARCHAR(36) NOT NULL,
  `old_value` JSON NULL,
  `operation_id_fk` SMALLINT NULL,
  `updated_date` DATETIME NULL,
  `updated_by` VARCHAR(45) NOT NULL,
  `transaction_id` VARCHAR(36) NOT NULL,
  `table_id_fk` SMALLINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (table_id_fk)
    REFERENCES table_name(id)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  FOREIGN KEY (operation_id_fk)
    REFERENCES table_operation(id)
    ON UPDATE CASCADE ON DELETE RESTRICT);

CREATE TABLE IF NOT EXISTS
`SanitasTest`.`table_name` (
  `id` SMALLINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS
`SanitasTest`.`table_operation` (
  `id` SMALLINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE IF NOT EXISTS
`SanitasTest`.`relationship_type` (
  `id` SMALLINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `biological` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS
`SanitasTest`.`gender` (
  `id` SMALLINT NOT NULL,
  `name` VARCHAR(64) NOT NULL,
  `biological` BOOLEAN NOT NULL,
  PRIMARY KEY (`id`));
