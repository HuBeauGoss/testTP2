SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema test_java
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `user01_test_java` DEFAULT CHARACTER SET utf8 ;
USE `user01_test_java` ;

-- -----------------------------------------------------
-- Table `test_java`.`prof`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `prof` (
  `idprof` INT NOT NULL AUTO_INCREMENT,
  `nomprof` VARCHAR(100) NOT NULL,
  `prenomprof` VARCHAR(100) NOT NULL,
  `datenaiss` VARCHAR(25) NULL,
  `lieunaiss` VARCHAR(100) NULL,
  PRIMARY KEY (`idprof`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `test_java`.`cours`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cours` (
  `idcours` INT NOT NULL AUTO_INCREMENT,
  `intitule` VARCHAR(200) NOT NULL,
  `duree` VARCHAR(10) NOT NULL,
  `idprof` INT NULL,
  PRIMARY KEY (`idcours`),
  INDEX `fk_cours_prof_idx` (`idprof` ASC),
  CONSTRAINT `fk_cours_prof`
    FOREIGN KEY (`idprof`)
    REFERENCES `prof` (`idprof`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
