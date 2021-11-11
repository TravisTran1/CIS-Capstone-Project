/*
Connection: 234a_MissingSemiColons

File: table-data-insert.sql

Author(s): Tessa Henson
*/

USE [234a_MissingSemiColons];


INSERT INTO MS_Users (UserID, Subscriber, Admin, Username, Password, Email, FullName, DateLogin)
VALUES (1, 1, 0, 'coolDude2020', 'kewlio30!$4a', 'random.email@gmail.com', 'Keanu Leaves', GETDATE());

INSERT INTO MS_Users (UserID, Subscriber, Admin, Username, Password, Email, FullName, DateLogin)
VALUES (2, 1, 0, 'xXsomePersonXx', 'l1fe0fP1', 'some.person@gmail.com', 'Iida Tenya', GETDATE());

INSERT INTO MS_Users (UserID, Subscriber, Admin, Username, Password, Email, FullName, DateLogin)
VALUES (3, 1, 0, 'that1CODKid', 'badM1cSet', 'xbox.player@gmail.com', 'Jhon Veer', GETDATE());

INSERT INTO MS_Users (UserID, Subscriber, Admin, Username, Password, Email, FullName, DateLogin)
VALUES (4, 0, 0, 'TheGround0', 'n1troXpl0sion', 'king.explosion@gmail.com', 'Katsuki Bakugou', GETDATE());

INSERT INTO MS_Users (UserID, Subscriber, Admin, Username, Password, Email, FullName, DateLogin)
VALUES (5, 0, 0, 'urFriendlyNeighbor', 'just4P3rs0n', 'friendly.p3rson@gmail.com', 'Kate Corsair', GETDATE());

INSERT INTO MS_Users (UserID, Subscriber, Admin, Username, Password, Email, FullName, DateLogin)
VALUES (6, 0, 0, 'k1tt3nHugs2020', 'katz4cut3!!!', 'kitt3n.l0ver@gmail.com', 'Gabriel Alene', GETDATE());

INSERT INTO MS_Users (UserID, Subscriber, Admin, Username, Password, Email, FullName, DateLogin)
VALUES (7, 0, 1, 'sl4y3r', 'kimetsuN0Ya1b4', 'tanjir0@gmail.com', 'Kamado Tanjiro', GETDATE());

INSERT INTO MS_Users (UserID, Subscriber, Admin, Username, Password, Email, FullName, DateLogin)
VALUES (8, 0, 1, 'GoatSinD0ll', 'nan4tsuN#Ta1zai', 'gowther.doll@gmail.com', 'Doll Gowther', GETDATE());

INSERT INTO MS_Users (UserID, Subscriber, Admin, Username, Password, Email, FullName, DateLogin)
VALUES (9, 0, 1, 'isThatAJoJoReference', 'Jotar0J#$t4r', 'Jojo.Reference@gmail.com', 'Jotaro Joestar', GETDATE());


/*
INSERTs for MS_Template
*/
INSERT INTO MS_Template (TemplateID, TempName, TempSubject, CampusName, TempText)
VALUES (1, 'Winter', 'Pantry Winter', 'Rock Creek', 'This is a big text boi');

INSERT INTO MS_Template (TemplateID, TempName, TempSubject, CampusName, TempText)
VALUES (2, 'Spring', 'Pantry Spring', 'Sylvania', '-slaps text box- This bad boi can fit SO much text');

INSERT INTO MS_Template (TemplateID, TempName, TempSubject, CampusName, TempText)
VALUES (3, 'Summer', 'Pantry Summer', 'Southeast', 'Haha, text box be big, text go brrrrrrrrrrrrrrrrrrrrrrrrrr-rawrXD-rrrrrrrr');

INSERT INTO MS_Template (TemplateID, TempName, TempSubject, CampusName, TempText)
VALUES (4, 'Fall', 'Pantry Fall', 'Cascada', 'The FitnessGram™ Pacer Test is a multistage aerobic capacity test that progressively gets more difficult as it continues. The 20 meter pacer test will begin in 30 seconds. Line up at the start. The running speed starts slowly, but gets faster each minute after you hear this signal. [beep] A single lap should be completed each time you hear this sound. [ding] Remember to run in a straight line, and run as long as possible. The second time you fail to complete a lap before the sound, your test is over. The test will begin on the word start. On your mark, get ready, start.');

/*
INSERTs for MS_Notification
*/
INSERT INTO MS_Notification (NotifID, TemplateID, UserID, DateCreated, SentTo)
VALUES (1, 4, 7, '2020-10-21', 35);

INSERT INTO MS_Notification (NotifID, TemplateID, UserID, DateCreated, SentTo)
VALUES (2, 3, 8, '2020-10-20', 20);

INSERT INTO MS_Notification (NotifID, TemplateID, UserID, DateCreated, SentTo)
VALUES (3, 2, 9, '2020-10-19', 9);

INSERT INTO MS_Notification (NotifID, TemplateID, UserID, DateCreated, SentTo)
VALUES (4, 1, 9, '2020-10-18', 4);












