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
-- Table `person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `person` ;

CREATE TABLE IF NOT EXISTS `person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(25) NULL DEFAULT 'Ground Zero',
  `gps_location` VARCHAR(100) NULL,
  `initial_eval_time` VARCHAR(45) NULL,
  `gender` VARCHAR(12) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `vitals`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `vitals` ;

CREATE TABLE IF NOT EXISTS `vitals` (
  `id` INT NOT NULL AUTO_INCREMENT,
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
  `id` INT NOT NULL AUTO_INCREMENT,
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `body_part` VARCHAR(45) NULL,
  `injury` VARCHAR(45) NULL,
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

-- -----------------------------------------------------
-- Data for table `person`
-- -----------------------------------------------------
START TRANSACTION;
USE `ttptriage`;
INSERT INTO `person` (`id`, `location`, `gps_location`, `initial_eval_time`, `gender`) VALUES (1, 'Denver', NULL, NULL, 'f');

COMMIT;


-- -----------------------------------------------------
-- Data for table `vitals`
-- -----------------------------------------------------
START TRANSACTION;
USE `ttptriage`;
INSERT INTO `vitals` (`id`, `diastolic_bp`, `systolic_bp`, `pulse`, `resp_rate`, `pulse_ox`, `severity`, `person_id`) VALUES (1, 110, 60, 60, 30, 98, 'GREEN', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `personal_info`
-- -----------------------------------------------------
START TRANSACTION;
USE `ttptriage`;
INSERT INTO `personal_info` (`id`, `first_name`, `last_name`, `middle_name`, `dob`, `person_id`) VALUES (DEFAULT, 'Jane', 'Doe', NULL, '1980-12-12', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `symptoms`
-- -----------------------------------------------------
START TRANSACTION;
USE `ttptriage`;
INSERT INTO `symptoms` (`id`, `body_part`, `injury`, `person_id`) VALUES (1, 'leg', 'laceration', 1);

COMMIT;

