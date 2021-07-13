DELETE FROM SPEAKER;
INSERT INTO SPEAKER (ID, NAME, POSITION, CREATED_AT)
            VALUES(1, 'John Doe', 'MID', TO_DATE('10.11.2018.', 'DD.MM.YYYY.'));
INSERT INTO SPEAKER (ID, NAME, POSITION, CREATED_AT)
            VALUES(2, 'Jane Doe', 'SENIOR', TO_DATE('10.11.2018.', 'DD.MM.YYYY.'));


DELETE FROM LECTURE;
INSERT INTO LECTURE (ID, TITLE, CONTENTS, LECTURE_TYPE, PUBLISH, CREATED_AT)
            VALUES(1, 'Something', 'Something something', 'PRESENTATION', 1, TO_DATE('10.11.2018.', 'DD.MM.YYYY.'));
INSERT INTO LECTURE (ID, TITLE, CONTENTS, LECTURE_TYPE, PUBLISH, CREATED_AT)
            VALUES(2, 'Another thing', 'Another and another', 'PRESENTATION', 1, TO_DATE('27.11.2018.', 'DD.MM.YYYY.'));
INSERT INTO LECTURE (ID, TITLE, CONTENTS, LECTURE_TYPE, PUBLISH, CREATED_AT)
VALUES(3, 'Blockchain Development', 'Learn how to develop a blockchain', 'WORKSHOP', 1, TO_DATE('27.11.2018.', 'DD.MM.YYYY.'));


DELETE FROM LECTURE_SPEAKER;
INSERT INTO LECTURE_SPEAKER (SPEAKER, LECTURE)
            VALUES(1,1);
INSERT INTO LECTURE_SPEAKER (SPEAKER, LECTURE)
            VALUES(2,2);
INSERT INTO LECTURE_SPEAKER (SPEAKER, LECTURE)
VALUES(2,3);

DELETE FROM USERS;
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
				VALUES ('admin', '$2a$10$ZJfRL79LpKhCWQYT3.07GOL/qjKN5SmRPa5ydI56cYCy/6QMgVLIy', 1);
INSERT INTO USERS (USERNAME, PASSWORD, ENABLED)
				VALUES ('user', '$2a$10$c6iY8l6MJJvd/.kJ2FKHB.Jn6Ag/iwqzMyNri.ckXPm7uCbX9UHZu', 1);

DELETE FROM AUTHORITIES;				
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
				values ('admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
				values ('admin', 'ROLE_USER');
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY)
				values ('user', 'ROLE_USER');