DROP TABLE IF EXISTS Profesores;

CREATE TABLE Profesores (
  id_profesor INT AUTO_INCREMENT PRIMARY KEY,
  nombres VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  telefono VARCHAR(10) NULL DEFAULT '1111111111',
  especialidad VARCHAR(250) NOT NULL,
  fecha_nacimiento DATE NULL DEFAULT '1999-01-01'
);

INSERT INTO Profesores (nombres,email,telefono,especialidad,fecha_nacimiento)
VALUES ('Emperatriz Zapata','empe@example.com','3005478732','Ing. Sistemas','1934-01-01');

INSERT INTO Profesores (nombres,email,telefono,especialidad,fecha_nacimiento)
VALUES ('Julian Pizarro','jullianP@example.com','3304538732','Ing. Software','1984-05-12');

INSERT INTO Profesores (nombres,email,telefono,especialidad,fecha_nacimiento)
VALUES ('Jesus Tinoco de la Valle','jesusTinV@example.com','3345678732','Matematico','1954-03-23');

INSERT INTO Profesores (nombres,email,telefono,especialidad,fecha_nacimiento)
VALUES ('Maria Del Pilar','MairaDP@example.com','3350547764','Lic. Lenguas','1964-07-10');