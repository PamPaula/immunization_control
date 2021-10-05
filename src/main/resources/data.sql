-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.26 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.3.0.6337
-- --------------------------------------------------------

SET FOREIGN_KEY_CHECKS=0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando dados para a tabela immunization_control.batch: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `batch` DISABLE KEYS */;
INSERT INTO `batch` (`id`, `delivery_date`, `expiration_date`, `identification`, `qty_received`, `qty_remaining`, `vaccine_id`) VALUES
	(1, '2021-08-20 00:00:00.000000', '2021-09-03 00:00:00.000000', 111222, 900, 799, 1),
	(2, '2021-08-20 00:00:00.000000', '2021-09-03 00:00:00.000000', 222333, 800, 699, 2),
	(3, '2021-08-20 00:00:00.000000', '2021-09-02 00:00:00.000000', 333444, 700, 599, 3);
/*!40000 ALTER TABLE `batch` ENABLE KEYS */;

-- Copiando dados para a tabela immunization_control.immunization: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `immunization` DISABLE KEYS */;
INSERT INTO `immunization` (`id`, `date`, `dosage`, `batch_id`, `location_id`, `person_id`) VALUES
	(1, '2021-08-20 00:00:00.000000', 1, 1, 1, 1),
	(2, '2021-08-20 00:00:00.000000', 1, 2, 2, 2),
	(3, '2021-08-20 00:00:00.000000', 0, 3, 1, 3);
/*!40000 ALTER TABLE `immunization` ENABLE KEYS */;

-- Copiando dados para a tabela immunization_control.location: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`id`, `additional`, `address_line`, `city`, `number`, `state`, `zip_code`, `name`) VALUES
	(1, '', 'Rua das Aguas', 'São Roque', '22', 'São Paulo', '18130000', 'Recanto da cascata'),
	(2, '', 'Praça da Preguiça', 'São Roque', '11', 'São Paulo', '18130000', 'Vigilancia');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;

-- Copiando dados para a tabela immunization_control.person: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`, `additional`, `address_line`, `city`, `number`, `state`, `zip_code`, `birth_date`, `cpf`, `name`) VALUES
	(1, 'Casa 6', 'Travessa Euclides Luccio', 'São Roque', '560', 'São Paulo', '18130000', '1991-01-06 00:00:00.000000', '11122233344', 'Pamela de Paula Santos'),
	(2, '', 'Rua Feliz', 'São Roque', '777', 'São Paulo', '18130000', '1991-12-09 00:00:00.000000', '22233344455', 'Lucas Silvestre'),
	(3, '', 'Rua Emo', 'Mairinque', '666', 'São Paulo', '18120000', '2007-12-27 00:00:00.000000', '33344455566', 'Olivia Rodrigues');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

-- Copiando dados para a tabela immunization_control.vaccine: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `vaccine` DISABLE KEYS */;
INSERT INTO `vaccine` (`id`, `dosage`, `lab`, `name`, `time`) VALUES
	(1, 2, 'Butantan', 'Coronavac', 28),
	(2, 2, 'Oxford', 'Astrazeneca', 90),
	(3, 0, 'Johnson & Johnson', 'Jansenn', 0);
/*!40000 ALTER TABLE `vaccine` ENABLE KEYS */;

/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

SET FOREIGN_KEY_CHECKS=1;