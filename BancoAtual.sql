-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `sobrenome` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(15) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(255) NOT NULL,
  `estado` VARCHAR(60) NOT NULL,
  `cidade` VARCHAR(60) NOT NULL,
  `numero` INT NOT NULL,
  `bairro` VARCHAR(60) NOT NULL,
  `complemento` VARCHAR(255) NULL DEFAULT NULL,
  `cep` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`vacinas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`vacinas` (
  `idVacinas` INT NOT NULL AUTO_INCREMENT,
  `nome_posto` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(60) NOT NULL,
  `numero` INT NOT NULL,
  `cep` INT NOT NULL,
  `complemento` VARCHAR(255) NULL DEFAULT NULL,
  `rua` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`idVacinas`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
