create database base1;
USE BASE1;

CREATE TABLE estudiantes(
id MEDIUMINT NOT NULL AUTO_INCREMENT,
nombre char(30) NOT NULL,
Celular CHAR(30), PRIMARY KEY (id) );

insert INTO estudiantes(id,nombre,Celular) VALUES 
(12, "Elvis", "0960445758" ),
(13, "Elvis", "0960445758" ), 
(14, "Elvis", "0960445758" ),
(15, "Elvis", "0960445758" ),
(16, "Elvis", "0960445758" ); 


select* FROM estudiantes;

         
