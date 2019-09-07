SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hoteldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hoteldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hoteldb` DEFAULT CHARACTER SET utf8 ;
USE `hoteldb` ;

-- -----------------------------------------------------
-- Table `hoteldb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `is_admin` TINYINT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `idusuario_UNIQUE` (`iduser` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hoteldb`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`reservation` (
  `idreservation` INT NOT NULL AUTO_INCREMENT,
  `datein` DATETIME NOT NULL,
  `dateout` DATETIME NOT NULL,
  `guests` INT NOT NULL,
  `iduser` INT NOT NULL,
  PRIMARY KEY (`idreservation`, `iduser`),
  INDEX `fk_reservation_user1_idx` (`iduser` ASC),
  CONSTRAINT `fk_reservation_user1`
    FOREIGN KEY (`iduser`)
    REFERENCES `hoteldb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hoteldb`.`message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`message` (
  `idmessage` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `content` VARCHAR(400) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `iduser` INT NULL,
  PRIMARY KEY (`idmessage`),
  INDEX `fk_message_user_idx` (`iduser` ASC),
  UNIQUE INDEX `idmessage_UNIQUE` (`idmessage` ASC),
  CONSTRAINT `fk_message_user`
    FOREIGN KEY (`iduser`)
    REFERENCES `hoteldb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
