/*
Connection: 234a_MissingSemiColons

File: drop-tables.sql

Author(s): Tessa Henson

Modifications:

10/10/2020
	Removed MS_Subscriber table and merged with MS_Admin,
	now named MS_Users

	MS_FoodItems is not included for now



*/
USE [234a_MissingSemiColons]

DROP TABLE MS_Notification;
-- This will not be needed until Sprint 2
--DROP TABLE MS_FoodItem;
DROP TABLE MS_Template;
DROP TABLE MS_Users;








