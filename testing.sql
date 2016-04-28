-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema testing
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema testing
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `testing` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `testing` ;

-- -----------------------------------------------------
-- Table `testing`.`track`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testing`.`track` ;

CREATE TABLE IF NOT EXISTS `testing`.`track` (
  `trackID` INT NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `album` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`trackID`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testing`.`user` ;

CREATE TABLE IF NOT EXISTS `testing`.`user` (
  `userID` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `userName` VARCHAR(45) NOT NULL COMMENT '',
  `userPassword` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`userID`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`library`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testing`.`library` ;

CREATE TABLE IF NOT EXISTS `testing`.`library` (
  `libraryPID` VARCHAR(45) NOT NULL COMMENT '',
  `userID` INT NOT NULL COMMENT '',
  PRIMARY KEY (`libraryPID`)  COMMENT '',
  INDEX `userID_idx` (`userID` ASC)  COMMENT '',
  CONSTRAINT `userID`
    FOREIGN KEY (`userID`)
    REFERENCES `testing`.`user` (`userID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testing`.`playlist` ;

CREATE TABLE IF NOT EXISTS `testing`.`playlist` (
  `playlistID` INT NOT NULL COMMENT '',
  `playlistName` VARCHAR(45) NOT NULL COMMENT '',
  `libraryPID` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`playlistID`)  COMMENT '',
  INDEX `libraryID_idx` (`libraryPID` ASC)  COMMENT '',
  CONSTRAINT `libraryPID`
    FOREIGN KEY (`libraryPID`)
    REFERENCES `testing`.`library` (`libraryPID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `testing`.`playlistTrack`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `testing`.`playlistTrack` ;

CREATE TABLE IF NOT EXISTS `testing`.`playlistTrack` (
  `playlistTrackID` VARCHAR(45) NOT NULL COMMENT '',
  `trackID` INT NOT NULL COMMENT '',
  `playlistID` INT NOT NULL COMMENT '',
  `track` INT NOT NULL COMMENT '',
  `playlist` INT NOT NULL COMMENT '',
  PRIMARY KEY (`playlistTrackID`)  COMMENT '',
  CONSTRAINT `track`
    FOREIGN KEY (`track`)
    REFERENCES `testing`.`track` (`trackID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `playlist`
    FOREIGN KEY (`playlist`)
    REFERENCES `testing`.`playlist` (`playlistID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
