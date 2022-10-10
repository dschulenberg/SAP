-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SAPdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SAPdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SAPdb` DEFAULT CHARACTER SET utf8 ;
USE `SAPdb` ;

-- -----------------------------------------------------
-- Table `SAPdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SAPdb`.`user` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `username_UNIQUE` ON `SAPdb`.`user` (`username` ASC);

CREATE USER 'SAPuser'@'localhost' IDENTIFIED BY 'SAPuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `SAPdb`.* TO 'SAPuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `SAPdb`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `SAPdb`;
INSERT INTO `SAPdb`.`user` (`id`, `username`, `password`, `enabled`, `role`) VALUES (1, 'adminemail@gmail.com', 'admin', 1, 'admin');

COMMIT;

