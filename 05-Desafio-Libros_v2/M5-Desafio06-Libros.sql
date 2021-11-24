CREATE TABLE libros (
idLibro INT PRIMARY KEY AUTO_INCREMENT,
titulo VARCHAR(200),
anio INT,
autor VARCHAR(200),
imprenta VARCHAR(200),
disponible INT

);


INSERT INTO libros VALUES(NULL, "Papelucho", 1990, "Marcela Paz", "El Globo", 1); 
INSERT INTO libros VALUES(NULL, "El Extranjero", 1942, "Albert Camus", "La Imprenta", 0);
INSERT INTO libros VALUES(NULL, "La llave de Sarah", 2007, "Tatiana De Rosnay", "Punto de Lectura", 1); 
INSERT INTO libros VALUES(NULL, "El Librero de Kabul", 2002, "Asne Seiersta", "Cappelen Damm", 1);  

/*PROBANDO QUERY UPDATE DEL CODIGO JAVA*/
UPDATE libros SET TITULO="Titulo", ANIO=2020, AUTOR="Autor", IMPRENTA="Imprenta", DISPONIBLE=0 WHERE idLibro=6;


SELECT * FROM libros;