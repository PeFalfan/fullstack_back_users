
 GRANT ALL PRIVILEGES ON * . * TO 'root'@'localhost';

-- CREATE USER 'myuser'@'%' IDENTIFIED BY 'password';

 GRANT ALL PRIVILEGES ON *.* TO 'myuser'@'%' WITH GRANT OPTION;


-- Crear tabla usuarios
CREATE TABLE usuarios(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre     VARCHAR(80) NOT NULL,
    correo     VARCHAR(80) NOT NULL,
    contrasena VARCHAR(16) NOT NULL
);


-- inserta datos en la tabla usuarios
INSERT INTO usuarios (nombre, correo, contrasena)
VALUES
    ("Malenia Blade of Miquella", "malenia@gmail.com", "123456"),
    ("Starscourge Radahn", "radahn@gmail.com", "123456");
