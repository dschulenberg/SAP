-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SAPdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SAPdb` ;

-- -----------------------------------------------------
-- Schema SAPdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SAPdb` DEFAULT CHARACTER SET utf8 ;
USE `SAPdb` ;

-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `priority`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `priority` ;

CREATE TABLE IF NOT EXISTS `priority` (
  `id` INT NOT NULL,
  `level` VARCHAR(45) NULL,
  `deadline` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `department`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `department` ;

CREATE TABLE IF NOT EXISTS `department` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `abbreviation` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `notification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `notification` ;

CREATE TABLE IF NOT EXISTS `notification` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `department_id` INT NOT NULL,
  `location` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `department_id`),
  INDEX `fk_notification_department1_idx` (`department_id` ASC),
  CONSTRAINT `fk_notification_department1`
    FOREIGN KEY (`department_id`)
    REFERENCES `department` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `work_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `work_order` ;

CREATE TABLE IF NOT EXISTS `work_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `priority_id` INT NOT NULL,
  `notification_id` INT NOT NULL,
  `equipment` VARCHAR(45) NULL,
  PRIMARY KEY (`id`, `priority_id`),
  INDEX `fk_work_order_priority_idx` (`priority_id` ASC),
  INDEX `fk_work_order_notification1_idx` (`notification_id` ASC),
  CONSTRAINT `fk_work_order_priority`
    FOREIGN KEY (`priority_id`)
    REFERENCES `priority` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_work_order_notification1`
    FOREIGN KEY (`notification_id`)
    REFERENCES `notification` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS SAPuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'SAPuser'@'localhost' IDENTIFIED BY 'SAPuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'SAPuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `SAPdb`;
INSERT INTO `user` (`id`, `username`, `password`, `enabled`, `role`) VALUES (1, 'adminemail@gmail.com', 'admin', 1, 'admin');

COMMIT;


-- -----------------------------------------------------
-- Data for table `priority`
-- -----------------------------------------------------
START TRANSACTION;
USE `SAPdb`;
INSERT INTO `priority` (`id`, `level`, `deadline`) VALUES (1, 'Alpha', '1 Week');
INSERT INTO `priority` (`id`, `level`, `deadline`) VALUES (2, 'Bravo', '2 Weeks');
INSERT INTO `priority` (`id`, `level`, `deadline`) VALUES (3, 'Charlie', '4 Weeks');
INSERT INTO `priority` (`id`, `level`, `deadline`) VALUES (4, 'Delta', '6 Weeks');

COMMIT;


-- -----------------------------------------------------
-- Data for table `department`
-- -----------------------------------------------------
START TRANSACTION;
USE `SAPdb`;
INSERT INTO `department` (`id`, `name`, `abbreviation`) VALUES (1, 'Mechanical Maintenance', 'MM02');
INSERT INTO `department` (`id`, `name`, `abbreviation`) VALUES (2, 'Electrical Maintenance', 'MM04');
INSERT INTO `department` (`id`, `name`, `abbreviation`) VALUES (3, 'HVAC', 'MM06');
INSERT INTO `department` (`id`, `name`, `abbreviation`) VALUES (4, 'Chemistry', 'MM03');

COMMIT;


-- -----------------------------------------------------
-- Data for table `notification`
-- -----------------------------------------------------
START TRANSACTION;
USE `SAPdb`;
INSERT INTO `notification` (`id`, `description`, `department_id`, `location`) VALUES (1, 'HVAC seems to be down', 3, 'Bldg 100, rm 201');
INSERT INTO `notification` (`id`, `description`, `department_id`, `location`) VALUES (2, 'Unknown spilled liquid', 4, 'Bldg 300, rm 201');
INSERT INTO `notification` (`id`, `description`, `department_id`, `location`) VALUES (3, 'Loose wiring found after construction', 2, 'Bldg 300, rm 11');
INSERT INTO `notification` (`id`, `description`, `department_id`, `location`) VALUES (4, 'Compresor leaking', 1, 'Bldg 200, rm 101');

COMMIT;


-- -----------------------------------------------------
-- Data for table `work_order`
-- -----------------------------------------------------
START TRANSACTION;
USE `SAPdb`;
INSERT INTO `work_order` (`id`, `description`, `priority_id`, `notification_id`, `equipment`) VALUES (1, 'HVAC seems to be down', 4, 1, '1001-617-1U1');
INSERT INTO `work_order` (`id`, `description`, `priority_id`, `notification_id`, `equipment`) VALUES (2, 'Unknown spilled liquid', 1, 2, '0000-414-1U1');
INSERT INTO `work_order` (`id`, `description`, `priority_id`, `notification_id`, `equipment`) VALUES (3, 'Loose wiring found after construction', 2, 3, '1002-616-1U1');
INSERT INTO `work_order` (`id`, `description`, `priority_id`, `notification_id`, `equipment`) VALUES (4, 'Compresor leaking', 3, 4, '0400-141-2U1');

COMMIT;

