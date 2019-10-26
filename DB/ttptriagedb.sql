-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ttptriage
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ttptriage` ;

-- -----------------------------------------------------
-- Schema ttptriage
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ttptriage` DEFAULT CHARACTER SET utf8 ;
USE `ttptriage` ;

-- -----------------------------------------------------
-- Table `catastrophe`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `catastrophe` ;

CREATE TABLE IF NOT EXISTS `catastrophe` (
  `cat_id` INT(11) NOT NULL,
  `cat_name` VARCHAR(45) NULL,
  `cat_location` VARCHAR(45) NULL,
  PRIMARY KEY (`cat_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `person` ;

CREATE TABLE IF NOT EXISTS `person` (
  `id` INT NOT NULL,
  `location` VARCHAR(25) NOT NULL DEFAULT 'Ground Zero',
  `gps_location` VARCHAR(100) NOT NULL,
  `initial_eval_time` VARCHAR(45) NULL,
  `gender` VARCHAR(12) NULL,
  `catastrophe_cat_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_person_catastrophe1_idx` (`catastrophe_cat_id` ASC),
  CONSTRAINT `fk_person_catastrophe1`
    FOREIGN KEY (`catastrophe_cat_id`)
    REFERENCES `catastrophe` (`cat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vitals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vitals` ;

CREATE TABLE IF NOT EXISTS `vitals` (
  `id` INT NOT NULL,
  `diastolic_bp` INT NULL,
  `systolic_bp` INT NULL,
  `pulse` INT NULL,
  `resp_rate` INT NULL,
  `pulse_ox` INT NULL,
  `severity` ENUM('GREEN', 'YELLOW', 'RED', 'GRAY', 'BLACK') NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_vitals_person1_idx` (`person_id` ASC),
  CONSTRAINT `fk_vitals_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `personal_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `personal_info` ;

CREATE TABLE IF NOT EXISTS `personal_info` (
  `id` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `middle_name` VARCHAR(45) NULL,
  `dob` DATE NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_personal_info_person1_idx` (`person_id` ASC),
  CONSTRAINT `fk_personal_info_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `symptoms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `symptoms` ;

CREATE TABLE IF NOT EXISTS `symptoms` (
  `id` INT NOT NULL,
  `body_part` VARCHAR(45) NOT NULL,
  `injury` VARCHAR(45) NOT NULL,
  `person_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_symptoms_person1_idx` (`person_id` ASC),
  CONSTRAINT `fk_symptoms_person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO ttptri@localhost;
 DROP USER ttptri@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'ttptri'@'localhost' IDENTIFIED BY 'trittpdenver';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'ttptri'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
