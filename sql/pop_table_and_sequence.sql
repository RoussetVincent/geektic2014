DELETE FROM geek;
DELETE FROM log;

INSERT INTO geek VALUES (2,'Joseph','MASCULIN','CSHARP','205e460b479e2e5b48aec07710c08d50',1);
INSERT INTO geek VALUES (3,'Nani','FEMININ','JAVA','',1);
INSERT INTO geek VALUES (4,'Robert','MASCULIN','PHP','205e460b479e2e5b48aec07710c08d50',1);
INSERT INTO geek VALUES (5,'Julien','MASCULIN','JAVA','',1);
INSERT INTO geek VALUES (6,'Maire','FEMININ','PHP','205e460b479e2e5b48aec07710c08d50',1);

INSERT INTO log VALUES (1,2,CURRENT_DATE,'127.0.0.1');
INSERT INTO log VALUES (2,5,CURRENT_DATE,'192.168.0.1');
