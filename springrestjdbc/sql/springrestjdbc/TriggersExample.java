package springrestjdbc;

public class TriggersExample {
	
//	Son procedimientos almacenados asociados a un evento de modificacion
//
//	Para realizar un trigger nos vamos a el nombre de la tabla le damos a la "llave inglesa" y en la parte de abajo tenemos la pestaña "triggers"
//
//	Los triggers se dan antes o despues de las operaciones de modificacion
//
//	- BEFORE INSERT
//	- AFTER INSERT 
//	- BEFORE UPDATE
//	- AFTER UPDATE
//	- BEFORE DELETE
//	- AFTER DELETE

	/*TRIGGER Raul Lopez Hernando*/

	/*Crear disparador para controlar que no se pueda insertar un precio negativo en la
	tabla de productos*/
//
//	CREATE DEFINER = CURRENT_USER TRIGGER `supermercado`.`productos_BEFORE_INSERT` BEFORE INSERT ON `productos` FOR EACH ROW
//	BEGIN
//
//	if NEW.precio < 0 THEN 
//	SIGNAL SQLSTATE '45000'
//	SET MESSAGE_TEXT = 'No se puede insertar un precio negativo';
//	END IF;
//
//	END
		
}
