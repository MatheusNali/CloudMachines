--
-- Current Database: `cloud_db`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cloud_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cloud_db`;

-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: cloud_db
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agent_args_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_args_tb` (
  `id_agent_args` int(11) NOT NULL,
  `id_agent` int(11) NOT NULL,
  `agent_arg` varchar(256) NOT NULL,
  PRIMARY KEY (`id_agent_args`),
  CONSTRAINT `agent_args_agent_fk` FOREIGN KEY (`id_agent`) REFERENCES `agent_tb` (`id_agent`) ON DELETE NO ACTION ON UPDATE CASCADE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `agent_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_tb` (
  `id_agent` int(11) NOT NULL,
  `id_agent_type` int(11) NOT NULL,
  `agent_name` varchar(256) NOT NULL,
  `agent_class` varchar(256) NOT NULL,
  PRIMARY KEY (`id_agent`),
  CONSTRAINT `agent_agent_type_fk` FOREIGN KEY (`id_agent_type`) REFERENCES `agent_type_tb` (`id_agent_type`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `agent_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agent_type_tb` (
  `id_agent_type` int(11) NOT NULL,
  `desc` varchar(200) NOT NULL,
  PRIMARY KEY (`id_agent_type`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `algorithm_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `algorithm_tb` (
  `id_algorithm` int(11) NOT NULL,
  `algorithm_class` varchar(255) NOT NULL,
  `algorithm_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_algorithm`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `api_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `api_tb` (
  `id_api` int(11) NOT NULL,
  `api_name` varchar(120) NOT NULL,
  `api_address` varchar(255) NOT NULL,
  `api_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_api`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `billing_history_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing_history_tb` (
  `id_billing_history` int(11) NOT NULL,
  `id_billing` int(11) NOT NULL,
  `id_vm` int(11) NOT NULL,
  `billing_date` datetime NOT NULL,
  `billing_dialy_hours_usage` int(11) DEFAULT NULL,
  `billing_dialy_cost` decimal(11,0) DEFAULT NULL,
  PRIMARY KEY (`id_billing_history`),
  CONSTRAINT `billing_history_billing_fk` FOREIGN KEY (`id_billing`) REFERENCES `billing_tb` (`id_billing`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `billing_history_vm_fk` FOREIGN KEY (`id_vm`) REFERENCES `vm_tb` (`id_vm`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `billing_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing_tb` (
  `id_billing` int(11) NOT NULL,
  `id_provider` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  PRIMARY KEY (`id_billing`),
  CONSTRAINT `billing_provider_fk` FOREIGN KEY (`id_provider`) REFERENCES `provider_tb` (`id_provider`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `billing_client_fk` FOREIGN KEY (`id_client`) REFERENCES `client_tb` (`id_client`) ON DELETE NO ACTION ON UPDATE CASCADE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cli_tool_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cli_tool_tb` (
  `id_cli_tool` int(11) NOT NULL,
  `cli_tool_name` varchar(120) NOT NULL,
  `cli_tool_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_cli_tool`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `client_management_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_management_tb` (
  `id_client` int(11) NOT NULL,
  `id_management` int(11) NOT NULL,
  PRIMARY KEY (`id_client`,`id_management`),
  CONSTRAINT `client_management_client_fk` FOREIGN KEY (`id_client`) REFERENCES `client_tb` (`id_client`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `client_management_management_fk` FOREIGN KEY (`id_management`) REFERENCES `management_tb` (`id_management`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `client_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_tb` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `id_provider` int(11) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(40) NOT NULL,
  `description` varchar(120) NOT NULL,
  `name` varchar(120) NOT NULL,
  PRIMARY KEY (`id_client`),
  CONSTRAINT `client_provider_fk` FOREIGN KEY (`id_provider`) REFERENCES `provider_tb` (`id_provider`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `compute_arch_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compute_arch_tb` (
  `id_compute_arch` int(11) NOT NULL,
  `compute_arch_feature` varchar(120) NOT NULL,
  `compute_arch_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_compute_arch`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `compute_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compute_tb` (
  `id_compute` int(11) NOT NULL,
  `id_compute_type` int(11) NOT NULL,
  `id_compute_arch` int(11) NOT NULL,
  `compute_freq` decimal(6,0) NOT NULL,
  `compute_number_of_cores` int(11) NOT NULL DEFAULT '1',
  `compute_hyperthreading` bit(1) NOT NULL,
  `compute_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_compute`),
  CONSTRAINT `compute_compute_type_fk` FOREIGN KEY (`id_compute_type`) REFERENCES `compute_type_tb` (`id_compute_type`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `compute_compute_arch_fk` FOREIGN KEY (`id_compute_arch`) REFERENCES `compute_arch_tb` (`id_compute_arch`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `compute_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compute_type_tb` (
  `id_compute_type` int(11) NOT NULL,
  `compute_type_feature` varchar(120) NOT NULL,
  `compute_type_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_compute_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dashboard_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dashboard_tb` (
  `id_dashboard` int(11) NOT NULL,
  `dashboard_address` varchar(255) NOT NULL,
  `dashboard_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_dashboard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `defined_cost_policy_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defined_cost_policy_tb` (
  `id_defined_cost_policy` int(11) NOT NULL,
  `id_policy` int(11) NOT NULL,
  `id_defined_cost_policy_type` int(11) NOT NULL,
  `initial_value` decimal(11,0) NOT NULL,
  `actual_value` decimal(11,0) NOT NULL,
  `fixed_diary_value` decimal(11,0) DEFAULT NULL,
  PRIMARY KEY (`id_defined_cost_policy`),
  CONSTRAINT `defined_cost_policy_policy_fk` FOREIGN KEY (`id_policy`) REFERENCES `policy_tb` (`id_policy`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `defined_cost_policy_defined_cost_policy_type_fk` FOREIGN KEY (`id_defined_cost_policy_type`) REFERENCES `defined_cost_policy_type_tb` (`id_defined_cost_policy_type`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `defined_cost_policy_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defined_cost_policy_type_tb` (
  `id_defined_cost_policy_type` int(11) NOT NULL,
  `desc` varchar(256) NOT NULL,
  PRIMARY KEY (`id_defined_cost_policy_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `encryption_type`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encryption_type` (
  `id_encryption_type` int(11) NOT NULL,
  `encryption_feature` varchar(120) NOT NULL,
  `encryption_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_encryption_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hypervisor_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hypervisor_tb` (
  `id_hypervisor` int(11) NOT NULL,
  `id_hypervisor_type` int(11) NOT NULL,
  `hypervisor_name` varchar(120) NOT NULL,
  `hypervisor_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_hypervisor`),
  CONSTRAINT `hypervisor_hypervisor_type_fk` FOREIGN KEY (`id_hypervisor_type`) REFERENCES `hypervisor_type_tb` (`id_hypervisor_type`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hypervisor_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hypervisor_type_tb` (
  `id_hypervisor_type` int(11) NOT NULL,
  `hypervisor_type_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_hypervisor_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `image_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image_type_tb` (
  `id_image_type` int(11) NOT NULL,
  `image_feature` varchar(120) NOT NULL,
  `image_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_image_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `log_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log_tb` (
  `id_log` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_provider` int(11) NOT NULL,
  `id_step` int(11) NOT NULL,
  `id_step_type` int(11) NOT NULL,
  `date_time` datetime NOT NULL,
  PRIMARY KEY (`id_log`),
  CONSTRAINT `log_client_fk` FOREIGN KEY (`id_client`) REFERENCES `client_tb` (`id_client`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `log_provider_fk` FOREIGN KEY (`id_provider`) REFERENCES `provider_tb` (`id_provider`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `log_step_fk` FOREIGN KEY (`id_step`) REFERENCES `step_tb` (`id_step`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `log_step_type_fk` FOREIGN KEY (`id_step_type`) REFERENCES `step_type_tb` (`id_step_type`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `machine_capacity_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `machine_capacity_tb` (
  `id_machine_capacity` int(11) NOT NULL,
  `machine_capacity_desc` varchar(120) NOT NULL,
  `id_resource` int(11) NOT NULL,
  `id_software` int(11) NOT NULL,
  PRIMARY KEY (`id_machine_capacity`),
  CONSTRAINT `machine_capacity_resource_fk` FOREIGN KEY (`id_resource`) REFERENCES `resource_tb` (`id_resource`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `machine_capacity_software_fk` FOREIGN KEY (`id_software`) REFERENCES `software_tb` (`id_software`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `management_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `management_tb` (
  `id_management` int(11) NOT NULL AUTO_INCREMENT,
  `id_policy` int(11) NOT NULL,
  `id_management_tool` int(11) NOT NULL,
  `description` varchar(120) NOT NULL,
  PRIMARY KEY (`id_management`),
  CONSTRAINT `management_policy_fk` FOREIGN KEY (`id_policy`) REFERENCES `policy_tb` (`id_policy`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `management_management_tools_fk` FOREIGN KEY (`id_management_tool`) REFERENCES `management_tools_tb` (`id_management_tool`) ON DELETE NO ACTION ON UPDATE CASCADE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `management_tools_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `management_tools_tb` (
  `id_management_tool` int(11) NOT NULL,
  `id_hypervisor` int(11) DEFAULT NULL,
  `id_cli_tool` int(11) DEFAULT NULL,
  `id_api` int(11) DEFAULT NULL,
  `id_dashboard` int(11) DEFAULT NULL,
  `id_orchestrator` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_management_tool`),
  CONSTRAINT `management_tool_hypervisor_fk` FOREIGN KEY (`id_hypervisor`) REFERENCES `hypervisor_tb` (`id_hypervisor`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `management_tool_cli_tool_fk` FOREIGN KEY (`id_cli_tool`) REFERENCES `cli_tool_tb` (`id_cli_tool`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `management_tool_api_fk` FOREIGN KEY (`id_api`) REFERENCES `api_tb` (`id_api`) ON DELETE NO ACTION ON UPDATE CASCADE,  
  CONSTRAINT `management_tool_dashboard_fk` FOREIGN KEY (`id_dashboard`) REFERENCES `dashboard_tb` (`id_dashboard`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `management_tool_orchestrator_fk` FOREIGN KEY (`id_orchestrator`) REFERENCES `orchestrator_tb` (`id_orchestrator`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `memory_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memory_tb` (
  `id_memory` int(11) NOT NULL,
  `id_memory_type` int(11) NOT NULL,
  `memory_freq` decimal(6,0) NOT NULL,
  `memory_size` int(11) NOT NULL,
  `memory_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_memory`),
  CONSTRAINT `memory_memory_type_fk` FOREIGN KEY (`id_memory_type`) REFERENCES `memory_type_tb` (`id_memory_type`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `memory_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `memory_type_tb` (
  `id_memory_type` int(11) NOT NULL,
  `memory_type_feature` varchar(120) NOT NULL,
  `memory_type_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_memory_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `network_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_tb` (
  `id_network` int(11) NOT NULL,
  `id_network_type` int(11) NOT NULL,
  `id_protocol` int(11) NOT NULL,
  `network_bandwidth` int(11) NOT NULL,
  `network_security` bit(1) NOT NULL,
  `network_route` varchar(120) NOT NULL,
  `network_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_network`),
  CONSTRAINT `network_network_type_fk` FOREIGN KEY (`id_network_type`) REFERENCES `network_type_tb` (`id_network_type`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `network_protocol_fk` FOREIGN KEY (`id_protocol`) REFERENCES `protocol_tb` (`id_protocol`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `network_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_type_tb` (
  `id_network_type` int(11) NOT NULL,
  `network_type_feature` varchar(120) NOT NULL,
  `network_type_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_network_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ondemand_policy_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ondemand_policy_tb` (
  `id_ondemand_policy` int(11) NOT NULL,
  `id_policy` int(11) NOT NULL,
  `id_ondemand_policy_type` int(11) NOT NULL,
  `initial_value` decimal(11,0) NOT NULL,
  `actual_value` decimal(11,0) NOT NULL,
  PRIMARY KEY (`id_ondemand_policy`),
  CONSTRAINT `ondemand_policy_policy_fk` FOREIGN KEY (`id_policy`) REFERENCES `policy_tb` (`id_policy`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `ondemand_policy_ondemand_policy_type_fk` FOREIGN KEY (`id_ondemand_policy_type`) REFERENCES `ondemand_policy_type_tb` (`id_ondemand_policy_type`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ondemand_policy_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ondemand_policy_type_tb` (
  `id_ondemand_policy_type` int(11) NOT NULL,
  `desc` varchar(256) NOT NULL,
  PRIMARY KEY (`id_ondemand_policy_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orchestrator_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orchestrator_tb` (
  `id_orchestrator` int(11) NOT NULL,
  `orchestrator_address` varchar(255) NOT NULL,
  `orchestrator_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_orchestrator`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `period_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `period_tb` (
  `id_period` int(11) NOT NULL,
  `year` int(4) DEFAULT NULL,
  `month` int(2) DEFAULT NULL,
  `day` int(2) DEFAULT NULL,
  `week_day` int(1) DEFAULT NULL,
  `hour` int(2) DEFAULT NULL,
  PRIMARY KEY (`id_period`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `policy_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy_tb` (
  `id_policy` int(11) NOT NULL AUTO_INCREMENT,
  `id_policy_type` int(11) NOT NULL,
  `id_algorithm` int(11) NOT NULL,
  `description` varchar(120) NOT NULL,
  PRIMARY KEY (`id_policy`),
  CONSTRAINT `policy_policy_type_fk` FOREIGN KEY (`id_policy_type`) REFERENCES `policy_type_tb` (`id_policy_type`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `policy_algorithm_fk` FOREIGN KEY (`id_algorithm`) REFERENCES `algorithm_tb` (`id_algorithm`) ON DELETE NO ACTION ON UPDATE CASCADE  
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `policy_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy_type_tb` (
  `id_policy_type` int(11) NOT NULL,
  `policy_type_desc` varchar(256) NOT NULL,
  PRIMARY KEY (`id_policy_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `power_policy_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `power_policy_tb` (
  `id_power_policy` int(11) NOT NULL,
  `id_policy` int(11) NOT NULL,
  `power_consumption` decimal(11,0) NOT NULL,
  `id_period_start` int(11) NOT NULL,
  `id_period_end` int(11) NOT NULL,
  PRIMARY KEY (`id_power_policy`),
  CONSTRAINT `power_policy_policy_fk` FOREIGN KEY (`id_policy`) REFERENCES `policy_tb` (`id_policy`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `power_policy_start_period_fk` FOREIGN KEY (`id_period_start`) REFERENCES `period_tb` (`id_period`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `power_policy_end_period_fk` FOREIGN KEY (`id_period_end`) REFERENCES `period_tb` (`id_period`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `power_status_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `power_status_tb` (
  `id_power_status` int(11) NOT NULL,
  `power_status_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_power_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `protocol_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `protocol_tb` (
  `id_protocol` int(11) NOT NULL,
  `procotol_acronym` varchar(20) NOT NULL,
  `protocol_feature` varchar(120) NOT NULL,
  `protocol_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_protocol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `provider_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provider_tb` (
  `id_provider` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(40) NOT NULL,
  `description` varchar(120) NOT NULL,
  PRIMARY KEY (`id_provider`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `resource_manufacturer_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource_manufacturer_tb` (
  `id_resource_manufacturer` int(11) NOT NULL,
  `manufacturer_name` varchar(120) NOT NULL,
  `manufacturer_email` varchar(20) NOT NULL,
  `manufacturer_brand_name` varchar(120) NOT NULL,
  PRIMARY KEY (`id_resource_manufacturer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `resource_model_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource_model_tb` (
  `id_resource_model` int(11) NOT NULL,
  `resource_model_desc` varchar(20) NOT NULL,
  PRIMARY KEY (`id_resource_model`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `resource_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource_tb` (
  `id_resource` int(11) NOT NULL,
  `id_resource_model` int(11) NOT NULL,
  `id_resource_manufacturer` int(11) NOT NULL,
  `id_compute` int(11) NOT NULL,
  `id_memory` int(11) NOT NULL,
  `id_network` int(11) NOT NULL,
  `id_storage` int(11) DEFAULT NULL,
  `id_volume` int(11) DEFAULT NULL,
  `resource_price` decimal(11,0) NOT NULL,
  `resource_power_consume` decimal(11,0) NOT NULL,
  PRIMARY KEY (`id_resource`),
  CONSTRAINT `resource_resource_model_fk` FOREIGN KEY (`id_resource_model`) REFERENCES `resource_model_tb` (`id_resource_model`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `resource_resource_manufacturer_fk` FOREIGN KEY (`id_resource_manufacturer`) REFERENCES `resource_manufacturer_tb` (`id_resource_manufacturer`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `resource_compute_fk` FOREIGN KEY (`id_compute`) REFERENCES `compute_tb` (`id_compute`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `resource_memory_fk` FOREIGN KEY (`id_memory`) REFERENCES `memory_tb` (`id_memory`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `resource_network_fk` FOREIGN KEY (`id_network`) REFERENCES `network_tb` (`id_network`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `resource_storage_fk` FOREIGN KEY (`id_storage`) REFERENCES `storage_tb` (`id_storage`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `resource_volume_fk` FOREIGN KEY (`id_volume`) REFERENCES `volume_tb` (`id_volume`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rm_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rm_tb` (
  `id_rm` int(11) NOT NULL AUTO_INCREMENT,
  `id_provider` int(11) NOT NULL,
  `id_power_status` int(11) NOT NULL,
  `id_machine_capacity` int(11) NOT NULL,
  `description` varchar(120) NOT NULL,
  PRIMARY KEY (`id_rm`),
  CONSTRAINT `rm_provider_fk` FOREIGN KEY (`id_provider`) REFERENCES `provider_tb` (`id_provider`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `rm_power_status_fk` FOREIGN KEY (`id_power_status`) REFERENCES `power_status_tb` (`id_power_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `rm_machine_capacity_fk` FOREIGN KEY (`id_machine_capacity`) REFERENCES `machine_capacity_tb` (`id_machine_capacity`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `rm_timestamps_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rm_timestamps_tb` (
  `id_timestamp` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_rm` int(11) NOT NULL,
  `start` datetime NOT NULL,
  `stop` datetime NOT NULL,
  PRIMARY KEY (`id_timestamp`),
  CONSTRAINT `rm_timestamps_rm_fk` FOREIGN KEY (`id_rm`) REFERENCES `rm_tb` (`id_rm`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roi_policy_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roi_policy_tb` (
  `id_roi` int(11) NOT NULL,
  `id_policy` int(11) NOT NULL,
  `initial_value` decimal(11,0) NOT NULL,
  `actual_value` decimal(11,0) DEFAULT NULL,
  `return` decimal(11,0) DEFAULT NULL,
  `rate_applied` decimal(11,0) NOT NULL,
  `amount` decimal(11,0) DEFAULT NULL,
  `id_period_start` int(11) NOT NULL,
  `id_period_end` int(11) NOT NULL,
  PRIMARY KEY (`id_roi`),
  CONSTRAINT `roi_policy_policy_fk` FOREIGN KEY (`id_policy`) REFERENCES `policy_tb` (`id_policy`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `roi_policy_start_period_fk` FOREIGN KEY (`id_period_start`) REFERENCES `period_tb` (`id_period`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `roi_policy_end_period_fk` FOREIGN KEY (`id_period_end`) REFERENCES `period_tb` (`id_period`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `scheduled_days_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scheduled_days_tb` (
  `id_scheduled_days` int(11) NOT NULL,
  `id_defined_cost_policy` int(11) NOT NULL,
  `day_of_month` int(2) NOT NULL,
  PRIMARY KEY (`id_scheduled_days`),
  CONSTRAINT `scheduled_days_defined_cost_policy_fk` FOREIGN KEY (`id_defined_cost_policy`) REFERENCES `defined_cost_policy_tb` (`id_defined_cost_policy`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `software_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `software_tb` (
  `id_software` int(11) NOT NULL,
  `id_software_type` int(11) NOT NULL,
  `software_version` varchar(120) NOT NULL,
  `software_name` varchar(120) NOT NULL,
  `software_manufacturer` varchar(120) DEFAULT NULL,
  `software_manufacturer_email` varchar(120) DEFAULT NULL,
  `software_serial` varchar(120) DEFAULT NULL,
  `software_cost` decimal(11,0) NOT NULL,
  `software_number_of_licenses` int(11) DEFAULT NULL,
  `software_desc` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id_software`),
  CONSTRAINT `software_software_type_fk` FOREIGN KEY (`id_software_type`) REFERENCES `software_type_tb` (`id_software_type`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `software_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `software_type_tb` (
  `id_software_type` int(11) NOT NULL,
  `software_type_desc` int(11) NOT NULL,
  PRIMARY KEY (`id_software_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `step_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `step_tb` (
  `id_step` int(11) NOT NULL,
  `id_timestamp_rm` bigint(20) DEFAULT NULL,
  `id_timestamp_vm` bigint(20) DEFAULT NULL,
  `id_vm` int(11) DEFAULT NULL,
  `id_rm` int(11) DEFAULT NULL,
  `id_policy` int(11) DEFAULT NULL,
  `id_power_status` int(11) DEFAULT NULL,
  `id_vm_status` int(11) DEFAULT NULL,
  `id_management` int(11) DEFAULT NULL,
  `id_billing` int(11) DEFAULT NULL,
  `response_time` double(15,3) NOT NULL,
  `desc` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id_step`),
  CONSTRAINT `step_rm_timestamps_fk` FOREIGN KEY (`id_timestamp_rm`) REFERENCES `rm_timestamps_tb` (`id_timestamp`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `step_vm_timestamps_fk` FOREIGN KEY (`id_timestamp_vm`) REFERENCES `vm_timestamps_tb` (`id_timestamp`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `step_vm_fk` FOREIGN KEY (`id_vm`) REFERENCES `vm_tb` (`id_vm`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `step_rm_fk` FOREIGN KEY (`id_rm`) REFERENCES `rm_tb` (`id_rm`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `step_policy_fk` FOREIGN KEY (`id_policy`) REFERENCES `policy_tb` (`id_policy`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `step_power_status_fk` FOREIGN KEY (`id_power_status`) REFERENCES `power_status_tb` (`id_power_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `step_management_fk` FOREIGN KEY (`id_management`) REFERENCES `management_tb` (`id_management`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `step_billing_fk` FOREIGN KEY (`id_billing`) REFERENCES `billing_tb` (`id_billing`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `step_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `step_type_tb` (
  `id_step_type` int(11) NOT NULL,
  `desc` varchar(256) NOT NULL,
  PRIMARY KEY (`id_step_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `storage_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_tb` (
  `id_storage` int(11) NOT NULL,
  `id_storage_type` int(11) NOT NULL,
  `storage_size` int(11) NOT NULL,
  `storage_max_size` int(11) NOT NULL,
  `storage_min_size` int(11) NOT NULL,
  PRIMARY KEY (`id_storage`),
  CONSTRAINT `storage_storage_type_fk` FOREIGN KEY (`id_storage_type`) REFERENCES `storage_type_tb` (`id_storage_type`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `storage_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_type_tb` (
  `id_storage_type` int(11) NOT NULL,
  `storage_feature` varchar(120) NOT NULL,
  `storage_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_storage_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_tb` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `id_client` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `email` varchar(120) NOT NULL,
  `password` varchar(40) NOT NULL,
  `description` varchar(120) NOT NULL,
  PRIMARY KEY (`id_user`),
  CONSTRAINT `user_client_fk` FOREIGN KEY (`id_client`) REFERENCES `client_tb` (`id_client`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vm_status_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_status_tb` (
  `id_vm_status` int(11) NOT NULL,
  `vm_status_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_vm_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vm_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_tb` (
  `id_vm` int(11) NOT NULL AUTO_INCREMENT,
  `id_rm` int(11) NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_vm_status` int(11) NOT NULL,
  `id_machine_capacity` int(11) NOT NULL,
  `name` varchar(120) NOT NULL,
  `description` varchar(120) NOT NULL,
  PRIMARY KEY (`id_vm`),
  CONSTRAINT `vm_rm_fk` FOREIGN KEY (`id_rm`) REFERENCES `rm_tb` (`id_rm`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `vm_client_fk` FOREIGN KEY (`id_client`) REFERENCES `client_tb` (`id_client`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `vm_vm_status_fk` FOREIGN KEY (`id_vm_status`) REFERENCES `vm_status_tb` (`id_vm_status`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `vm_machine_capacity_fk` FOREIGN KEY (`id_machine_capacity`) REFERENCES `machine_capacity_tb` (`id_machine_capacity`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vm_timestamps_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_timestamps_tb` (
  `id_timestamp` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_vm` int(11) NOT NULL,
  `id_machine_capacity` int(11) NOT NULL,
  `start` datetime NOT NULL,
  `stop` datetime NOT NULL,
  PRIMARY KEY (`id_timestamp`),
  CONSTRAINT `vm_timestamps_vm_fk` FOREIGN KEY (`id_vm`) REFERENCES `vm_tb` (`id_vm`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `vm_timestamps_machine_capacity_fk` FOREIGN KEY (`id_machine_capacity`) REFERENCES `machine_capacity_tb` (`id_machine_capacity`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `volume_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volume_tb` (
  `id_volume` int(11) NOT NULL,
  `id_volume_type` int(11) NOT NULL,
  `id_image_type` int(11) DEFAULT NULL,
  `id_encryption_type` int(11) DEFAULT NULL,
  `volume_size` int(11) NOT NULL,
  `volume_max_size` int(11) NOT NULL,
  `volume_min_size` int(11) NOT NULL,
  `volume_cloneable` bit(1) NOT NULL,
  `volume_name` varchar(120) NOT NULL,
  `volume_pool` varchar(120) DEFAULT NULL,
  `volume_path` varchar(240) NOT NULL,
  `volume_desc` varchar(20) NOT NULL,
  PRIMARY KEY (`id_volume`),
  CONSTRAINT `volume_volume_type_fk` FOREIGN KEY (`id_volume_type`) REFERENCES `volume_type_tb` (`id_volume_type`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `volume_image_type_fk` FOREIGN KEY (`id_image_type`) REFERENCES `image_type_tb` (`id_image_type`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `volume_encryption_type_fk` FOREIGN KEY (`id_encryption_type`) REFERENCES `encryption_tb` (`id_encryption_type`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `volume_type_tb`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volume_type_tb` (
  `id_volume_type` int(11) NOT NULL,
  `volume_feature` varchar(120) NOT NULL,
  `volume_desc` varchar(120) NOT NULL,
  PRIMARY KEY (`id_volume_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 PACK_KEYS=0;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-23 16:37:01
