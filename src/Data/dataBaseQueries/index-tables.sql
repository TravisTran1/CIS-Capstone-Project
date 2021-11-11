/*
Connection: 234a_MissingSemiColons

File: index-tables.sql

Author(s): Tessa Henson

Modifications:
*/

USE [234a_MissingSemiColons]

CREATE INDEX IDX_USERS ON MS_Users (UserID);
CREATE INDEX IDX_TEMPLATE ON MS_Template (TemplateID);
CREATE INDEX IDX_NOTIFICATION ON MS_Notification (NotifID);