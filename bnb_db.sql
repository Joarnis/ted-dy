-- MySQL Script generated by MySQL Workbench
-- Σαβ 22 Ιούλ 2017 11:52:26 μμ EEST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bnb_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bnb_db` ;

-- -----------------------------------------------------
-- Schema bnb_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bnb_db` DEFAULT CHARACTER SET utf8 ;
USE `bnb_db` ;

-- -----------------------------------------------------
-- Table `bnb_db`.`listings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bnb_db`.`listings` ;

CREATE TABLE IF NOT EXISTS `bnb_db`.`listings` (
  `id` INT NOT NULL,
  `listing_url` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `summary` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bnb_db`.`calendar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bnb_db`.`calendar` ;

CREATE TABLE IF NOT EXISTS `bnb_db`.`calendar` (
  `listing_id` INT NOT NULL,
  `date` DATE NOT NULL,
  `available` TINYINT NOT NULL,
  `price` VARCHAR(45) NULL,
  PRIMARY KEY (`listing_id`),
  CONSTRAINT `fk_calendar_listings1`
    FOREIGN KEY (`listing_id`)
    REFERENCES `bnb_db`.`listings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bnb_db`.`reviews`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bnb_db`.`reviews` ;

CREATE TABLE IF NOT EXISTS `bnb_db`.`reviews` (
  `listings_id` INT NOT NULL,
  `id` INT NOT NULL,
  `date` DATE NOT NULL,
  `reviewer_id` INT NOT NULL,
  `reviewer_name` VARCHAR(45) NOT NULL,
  `summary` VARCHAR(45) NULL,
  PRIMARY KEY (`listings_id`, `id`),
  INDEX `fk_reviews_listings_idx` (`listings_id` ASC),
  CONSTRAINT `fk_reviews_listings`
    FOREIGN KEY (`listings_id`)
    REFERENCES `bnb_db`.`listings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
