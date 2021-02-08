package springrestjdbc;

public class ViewExamples {

//	1. Cogemos el codigo que utilizemos como plantilla. Imaginemos por ejemplo que utilizamos esta consulta como base
//
//	SELECT e.idEmpleado, e.nomEmp,e.salEmp,e.comisionE,e.cargoE,d.nombreDpto 
//	from empleados e
//	JOIN departamentos d ON e.Departamento_codDepto = d.codDepto
//
//	2. EN el mismo Workbench vamos a la parte de Views boton derecho. Pegamos el codigo anterior y creamos la vista
//
//	3. Seleccionamos la vista "datos_departamentos_empleados" y le aplicamos
//	las condiciones
//
//	SELECT * FROM datos_departamentos_empleados
//	where salEmp > 500000
	
//	/*VISTA Raul Lopez Hernando*/
//
//	/*Crear una vista que para mostrar datos estadísticos de productos por categoría, por
//	ejemplo: numero productos por categoría, precio máximo, precio mínimo, media de
//	precios y sumatorio.*/
//
//
//	SELECT cat.descripcion, count(p.id_producto) as 
//	Numero_Productos,MAX(p.precio) as Precio_Maximo, 
//	MIN(p.precio) as Precio_Minimo, 
//	AVG(p.precio) as Media_Productos,
//	SUM(p.precio) as Suma_Precios FROM categorias cat
//	JOIN productos p 

}
