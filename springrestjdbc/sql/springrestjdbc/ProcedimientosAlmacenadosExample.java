package springrestjdbc;

public class ProcedimientosAlmacenadosExample {

//	1. Vamos a "Stored Procedures"
//	2. Y dentro de este le damos un nombre
//	   y creamos una sentencia dentro de este     	 para que la ejecute por ejemplo
//	   select * from empleados;
//	   Le damos un nombre . Por ejemplo    	      	"empleados"
//	3. Nos vamos a la consola y ponemos para    	ejecutar call  		nombreBaseDatos.nombreProcedimiento()
//
//	La gracia de esto es que funcionan como metodos con lo cual le podemos pasar tres
//	tipos de argumentos
//
//	IN - Desde fuera del procedimiento pasamos un 
//	dato para que el procedimiento trabaje con el
//	. Mas habitual
//
//	OUT -Me pasan una variable para que yo la rellene desde dentro y se la vuelva a pasar a
//	el que me ha llamado con la programacion que
//	haya hecho en el procedimiento
//
//	INOUT-Hace las dos funciones anteriores . Recibo un dato a traves de esa variable y a traves de esa variable devuelvo un dato
//
//	Para hacer "Return" de estos paramentros no
//	ponemos "return" si no que especificamos parametros "out"
	
	
	/*PROCEDIMIENTO ALMACENADO Raul Lopez Hernando */


	/*Crear procedimiento almacenado para que busque facturas entre dos fechas
	concretas.*/

//
//	CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_facturas`(IN primera_fecha Date, IN segunda_fecha Date)
//	BEGIN
//
//	select c.nombre, p.descripcion,f.*  from facturas f
//	JOIN clientes c
//	ON f.id_cliente = c.id_cliente
//	JOIN ventas v
//	ON v.id_factura = f.id_factura
//	JOIN productos p
//	ON v.id_producto = p.id_producto
//	where f.fecha BETWEEN primera_fecha AND segunda_fecha;
//
//	END
//	ON cat.id_categoria = p.Id_categoria
//	GROUP BY cat.descripcion
}
