package springrestjdbc;

public class SentenciasSQL {
	
//	1.Obtener los datos completos de los empleados
//
//	Select * from empleados
//
//	2.Obtener los datos completos de los departamentos
//
//	select * from departamentos
//
//	3.Obtener los datos de los empleados con cargo 'Secretaria'
//
//	select * from empleados e where cargoE = 'Secretaria'
//
//	4.Obtener el nombre y el salario de los empleados
//
//	select e.nomEmp,e.salEmp from empleados e 
//
//	5.Obtener los datos de los empleados vendedores ordenados por nombre (ORDENACION)
//
//	select * from empleados e where e.cargoE = 'Vendedor' order by e.nomEmp 
//
//	6.Listar el nombre de los departamentos
//
//	select d.nombreDpto FROM departamentos d
//
//	7.Listar el nombre de los departamentos, ordenados por nombre
//
//	select d.nombreDpto from departamentos d order by d.nombreDpto
//
//	8.Listar el nombre de los departamentos, ordenados por ciudad
//
//	select d.nombreDpto , d.ciudad from departamentos d order by d.ciudad
//
//	9.Listar el nombre de los departamentos, ordenados por ciudad en orden inverso
//
//	select d.nombreDptod , d.ciudad from departamentos d order by d.ciudad desc
//
//	10.Obtener el nombre y cargo de todos los empleados, ordenados por salario
//
//	select e.nomEmp,e.cargoE, e.salEmp from empleados e order by e.salEmp
//
//	11.Obtener el nombre y cargo de los empleados , ordenados por cargo y salario
//
//	select e.nomEmp,e.cargoE, e.salEmp from empleados e order by e.salEmp  and e.cargoE desc
//
//	12.Obtener el nombre y cargo de todos los empleados, en orden inverso por cargo
//
//	select e.nomEmp,e.cargoE, e.salEmp from empleados e order by e.cargoE desc
//
//	13.Listar los salarios y comisiones de los empleados del departamento 2000
//
//	SELECT e.nomEmp,e.salEmp, e.comisionE,d.nombreDpto,d.codDepto FROM empleados e 
//	JOIN departamentos d
//	ON e.Departamento_codDepto = d.codDepto
//	where d.codDepto = 2000
//
//	14. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comision
//
//	select e.nomEmp,e.salEmp,e.comisionE,d.codDepto from empleados e 
//	JOIN departamentos d
//	ON e.Departamento_codDepto = d.codDepto
//	WHERE e.Departamento_codDepto = 2000 
//	ORDER BY e.comisionE
//
//
//	15. Listar todas las comsiones
//
//	select e.comisionE from empleados e
//
//	16.Listas las comisiones que sean diferentes ordenadas por valor
//
//	select distinct e.comisionE as 'Comisones'from empleados e
//
//	17.Listar los diferentes salarios
//	select distinct e.salEmp as 'Salarios Distintos'from empleados e
//
//	18.Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una
//	bonificación de $500.000, en orden alfabético del empleado
//
//	select sum(e.salEmp) + 500.000 as 'Total Salario + Bonificacion',e.nomEmp as 'Nombre', 
//	e.Departamento_codDepto as 'Departamento' from empleados e 
//	where e.Departamento_codDepto = 3000
//	group by e.nomEmp
//
//	19.Obtener la lista de los empleados que ganan una comision superior a su sueldo
//
//	select * from empleados e where e.comisionE > e.salEmp
//
//	20.Listar los empleados cuya comsion es menor o igual que el 30 % de su sueldo
//
//	select e.nomEmp,e.cargoE,e.salEmp,e.comisionE,e.salEmp*0.3 as '30 por cierto salario'  from empleados e where e.comisionE >= e.salEmp*0.3
//
//	21.Elabora un listado donde para cada fila, figure "Nombre" y "Cargo" antes del valor respectivo para cada empleado
//
//	select e.nomEmp as 'Nombre',e.cargoE as 'Cargo', e.* from empleados e
//
//	22.Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad es
//	superior al '19.709.802'
//
//	select e.nomEmp,e.idEmpleado,e.salEmp , e.comisionE  from empleados e where e.idEmpleado > '19709802'
//
//
//	23. Listar los empleados cuyo salario es menor o igual que el 40% de su comision
//
//	select *from empleados e where e.salEmp <= e.comisionE *0.4
//
//	24. Divida los empleados, generando un grupo cuyo nombre inicie por la letra J y termine en la letra Z.
//	Liste estos empleados y su cargo por orden alfabético.
//
//	select * from empleados e where e.nomEmp like 'j%'  and e.nomEmp like '%a' order by e.nomEmp,e.salEmp
//
//	25Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del
//	empleado y nombre, de aquellos empleados que tienen comisión superior a $1.000.000, ordenar el
//	informe por el número del documento de identidad
//
//	select e.idEmpleado,e.nomEmp,e.salEmp,e.comisionE, sum(e.salEmp + e.comisionE) as 'Salario Total' from empleados e where e.comisionE > 1000000 group by e.idEmpleado
//
//	26.Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión
//
//	select e.idEmpleado,e.nomEmp,e.salEmp,e.comisionE, sum(e.salEmp + e.comisionE) as 'Salario Total' from empleados e where e.comisionE = 0 group by e.idEmpleado
//
//	27.Hallar el nombre de los empleados que tienen un salario superior a $1.000.000, y tienen como jefe al
//	empleado con documento de identidad '31.840.269
//
//	select * from empleados e 
//	JOIN departamentos d 
//	ON e.Departamento_codDepto = d.codDepto
//	where e.salEmp > '1000000'
//	and e.jefeID = '31.840.269'
//
//	28.Hallar el conjunto complementario del resultado del ejercicio anterior
//
//	select * from empleados e 
//	JOIN departamentos d 
//	ON e.Departamento_codDepto = d.codDepto
//	where e.salEmp < '1000000'
//	and NOT e.jefeID = '31.840.269'
//
//	29.Hallar a los empleados cuyo nombre no contiene la cadena 'MA'
//	select * from empleados e where e.nomEmp NOT LIKE '%MA'
//
//	30.Obtener los nombres de los departamentos que no sean “Ventas” ni “Investigación” NI
//	‘MANTENIMIENTO’, ordenados por ciudad.
//
//	select d.nombreDpto,d.ciudad from departamentos d where d.nombreDpto not in ('Ventas', 'Investigacion' , 'Mantenimiento') order by d.ciudad
//
//	31. Obtener el nombre y el departamento de los empleados con cargo 'Secretaria' o 'Vendedor', que
//	no trabajan en el departamento de “PRODUCCION”, cuyo salario es superior a $1.000.000,
//	ordenados por fecha de incorporación.
//
//	select * from empleados e
//	JOIN departamentos d
//	ON e.Departamento_codDepto = d.codDepto
//	where e.cargoE like 'Secretaria' or 'Vendedor' 
//	and d.nombreDpto NOT LIKE ('PRODUCCIÓN') and
//	e.salEmp > 1000000 order by e.fecIncorporacion
//
//	32.Obtener información de los empleados cuyo nombre tiene exactamente 11 caracteres
//	select * from empleados e where e.nomEmp like '___________'
//
//	33.Obtener información de los empleados cuyo nombre tiene al menos 11 caracteres
//
//	HAY QUE PREGUNTAR
//
//	34.Listar los datos de los empleados cuyo nombre inicia por la letra 'M', su salario es mayor a $800.000
//	o reciben comisión y trabajan para el departamento de 'VENTAS'
//
//	select e.nomEmp,e.salEmp,e.comisionE,d.nombreDpto from empleados e  
//	INNER JOIN departamentos d ON e.Departamento_codDepto=d.codDepto 
//	 where e.nomEmp = 'M%' and e.salEmp > 800000 || e.comisionE > 0 and d.nombreDpto IN ('VENTAS')
//
//	35. Obtener los nombres, salarios y comisiones de los empleados que reciben un salario situado entre la
//	mitad de la comisión la propia comisión
//
//	select e.nomEmp,e.salEmp,e.comisionE from empleados e where e.salEmp >= e.comisionE/2 and e.salEmp <= e.comisionE
//
//	36. Suponga que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los empleados, su
//	salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no comisión
//
//	select e.nomEmp as 'Nombre Empleado',e.salEmp as 'Salario Actual',e.salEmp * 0.93 , e.comisionE as 'Reajuste salarial del 7 %' from empleados e 
//
//	37.Obtener la información disponible del empleado cuyo número de documento de identidad sea:
//	'31.178.144', '16.759.060', '1.751.219', '768.782', '737.689', '19.709.802', '31.174.099', '1.130.782'
//
//	38.Entregar un listado de todos los empleados ordenado por su departamento, y alfabético dentro del
//	departamento.
//
//	select * from empleados e
//	JOIN departamentos d
//	ON e.Departamento_codDepto = d.codDepto
//	order by d.codDepto and d.nombreDpto
//
//	39.Entrega el salario mas alto de la empresa
//	select e.nomEmp,e.salEmp from empleados e where e.salEmp IN (select max(e.salEmp) from empleados e);
//
//	40.Entregar el total a pagar por comisiones, y el número de empleados que las reciben.
//	select sum(e.comisionE) as 'Total Comisiones', count(e.idEmpleado) as 'Total Empleados' from empleados e where e.comisionE > 0
//
//	41.Entregar el nombre del último empleado de la lista por orden alfabético (ULTIMO EMPLEADO)
//	select max(e.nomEmp) from empleados e 
//
//	42.Hallar el salario más alto, el más bajo y la diferencia entre ellos.
//	select max(e.salEmp) as 'Salario Mas Alto' , min(e.salEmp) as 'Salario mas bajo', max(e.salEmp) - min(e.salEmp)
//	 as 'Diferencia salario mas alto y mas bajo'   from empleados e 
//
//	43.Conocido el resultado anterior, entregar el nombre de los empleados que reciben el salario más alto
//	y más bajo. Cuanto suman estos salarios?
//
//	PREGUNTAR
//
//	select max(e.salEmp) as 'Salario Mas Alto' , min(e.salEmp) as 'Salario mas bajo', max(e.salEmp) - min(e.salEmp)
//	 as 'Diferencia salario mas alto y mas bajo' from empleados e ,(SELECT e.nomEmp as 'Nombre maximo salario' from empleados e group by e.salEmp )
//	 as subquery1 where subquery1. = e.Departamento_codDepto

//	
//	/*CONSULTAS SQL Raul Lopez Hernando*/
//
//	/*1. Listado de todos los proveedores ordenados alfabéticamente.*/
//
//
//	SELECT * FROM proveedores p  order by p.nombre
//
//	/*2. Listado de todos productos organizados por categorías.*/
//
//	SELECT p.*,c.descripcion FROM productos p 
//	JOIN categorias c
//	ON p.Id_categoria = c.id_categoria
//	order by p.Id_categoria
//
//
//	/*3. Las ventas del último mes, mostrando: cliente, producto, categoría y cantidad*/
//
//	SELECT c.nombre as Nombre_Cliente,p.descripcion as Producto, cat.descripcion as Categoria,v.cantidad as Numero_Ventas ,f.fecha from ventas v
//	JOIN facturas f
//	ON v.id_factura = f.id_factura
//	JOIN clientes c
//	ON f.id_cliente = c.id_cliente
//	JOIN productos p
//	ON v.id_producto = p.id_producto
//	JOIN categorias cat
//	ON p.Id_categoria = cat.id_categoria
//	where month(f.fecha) = 01
//
//
//	/*4. Listado de los 5 productos más vendidos*/
//
//	select p.*,v.cantidad from productos p
//	JOIN ventas v
//	ON p.id_producto = v.id_producto
//	order by v.cantidad DESC
//	LIMIT 5
//
//	/*5. Listado de los 5 clientes que más dinero han gastado*/
//
//	select c.* , SUM(v.cantidad * p.precio) as resultado from clientes c
//	JOIN facturas f
//	ON c.id_cliente = f.id_cliente
//	JOIN ventas v
//	ON f.id_factura = v.id_factura
//	JOIN productos p
//	ON v.id_producto = p.id_producto
//	GROUP BY c.id_cliente
//	order by resultado desc
//	LIMIT 5


}
