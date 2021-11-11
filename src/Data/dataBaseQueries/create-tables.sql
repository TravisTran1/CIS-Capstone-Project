/*
Connection: 234a_MissingSemiColons

File: create-tables.sql

Author(s): Tessa Henson

Modifications:
	10/10/2020
		Removed MS_Subscriber table and merged with MS_Admin,
		now named MS_Users

		MS_FoodItems will not be included until later

	10/13/2020
		Replaced MS_Users.Role with two BIT fields, Subscriber and Admin

		MS_Users.Email now can hold 50 characters instead of 20

		MS_Users.Password data field changed from NVARCHAR(30) to INT
	10/20/2020
		Added a foreign key MS_Notification_fk_2 (UserID) from MS_Users into MS_Notification
		MS_Template.TempText is now data type TEXT()

	10/21/2020
		Added column name SentTo for MS_Notification with field type INT and DEFAULT 0
*/
USE [234a_MissingSemiColons];

DROP TABLE MS_Notification;
-- This isn't needed until Sprint 2
--DROP TABLE MS_FoodItem;
DROP TABLE MS_Template;
DROP TABLE MS_Users;


/*
CREATE TABLE MS_Admin (
	AdminID SMALLINT NOT NULL,
	Username NVARCHAR NOT NULL,
	Password NVARCHAR NOT NULL,
	Email NVARCHAR NOT NULL,
	FullName NVARCHAR NOT NULL,
	DateLogin DATE,
	CONSTRAINT MS_Admin_pk PRIMARY KEY (AdminID)
)
;

*/


CREATE TABLE MS_Users (
	UserID INT NOT NULL,
	Subscriber BIT DEFAULT 1 NOT NULL,
	Admin BIT DEFAULT 0 NOT NULL,
	Username NVARCHAR(100) NOT NULL,
	Password INT NOT NULL,
	Email NVARCHAR(50) NOT NULL,
	FullName NVARCHAR(25) NOT NULL,
	DateLogin DATE,
	CONSTRAINT MS_Users_pk PRIMARY KEY (UserID)
)
;

CREATE TABLE MS_Template (
	TemplateID SMALLINT NOT NULL,
	TempName NVARCHAR(30) DEFAULT 'Template-name' NOT NULL,
	TempSubject NVARCHAR(100) DEFAULT 'Subject-name' NOT NULL,
	CampusName NVARCHAR(25) DEFAULT 'Sylvania' NOT NULL,
	TempText TEXT NOT NULL,
	CONSTRAINT MS_Template_pk PRIMARY KEY (TemplateID)
)
;
/* This will not be needed until Sprint 2
CREATE TABLE MS_FoodItem (
	ItemID INT NOT NULL,
	ItemName NVARCHAR NOT NULL,
	Description NVARCHAR NOT NULL,
	QtyAvailable INT DEFAULT 0 NOT NULL,
	CampusLocation NVARCHAR NOT NULL,
	--Not sure if it should be datetime or date, depends on how timeframes are going to work
	PickupTime DATETIME NOT NULL,
	CONSTRAINT MS_FoodItem_pk PRIMARY KEY (ItemID)
)
;
*/

CREATE TABLE MS_Notification (
	NotifID INT NOT NULL,
	TemplateID SMALLINT NOT NULL,
	UserID INT NOT NULL,
	DateCreated DATE NOT NULL,
	SentTo INT DEFAULT 0 NOT NULL
	CONSTRAINT MS_Notification_pk PRIMARY KEY (NotifID),
	CONSTRAINT MS_Notification_fk_1 FOREIGN KEY (TemplateID) REFERENCES MS_Template,
	CONSTRAINT MS_Notification_fk_2 FOREIGN KEY (UserID) REFERENCES MS_Users
);

COMMIT;
