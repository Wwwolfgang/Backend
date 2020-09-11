/* Popolate tables */
Insert into clientes (nombre,apellido,numero_doc,nacionalidad,telefono,email,create_at) values('Carlitos','Canete','5678678','paraguaya','0987654656','carlios@gmail.com','2020-08-28');
Insert into clientes (nombre,apellido,numero_doc,nacionalidad,telefono,email,create_at) values('Estela','Perez','5676678','paraguaya','0987654653','estelita@gmail.com','2020-08-28');
Insert into clientes (nombre,apellido,numero_doc,nacionalidad,telefono,email,create_at) values('Roxana','Perez','5698678','paraguaya','0987654658','estelita@gmail.com','2020-08-28');
Insert into clientes (nombre,apellido,numero_doc,nacionalidad,telefono,email,create_at) values('Sasha','Perez','5678378','paraguaya','0987654650','estelita@gmail.com','2020-08-28');


Insert into usopuntos (descripcion_puntos,puntos_requeridos) values('Punto numero 1',1000000);
Insert into usopuntos (descripcion_puntos,puntos_requeridos) values('Punto numero 2',500000);
Insert into usopuntos (descripcion_puntos,puntos_requeridos) values('Punto numero 3',1006700);

Insert into asignacionpuntos (limite_inferior,limite_superior,monto_equivalente) values(100000,500000,150000);
Insert into asignacionpuntos (limite_inferior,limite_superior,monto_equivalente) values(800000,100000,30000);
Insert into asignacionpuntos (limite_inferior,limite_superior,monto_equivalente) values(50000,100000,10000);

Insert into vencimientopuntos (fecha_inicio,fecha_fin,dias_duracion) values('2020-08-28','2020-09-28',15);
Insert into vencimientopuntos (fecha_inicio,fecha_fin,dias_duracion) values('2020-09-28','2020-10-28',20);
Insert into vencimientopuntos (fecha_inicio,fecha_fin,dias_duracion) values('2020-10-28','2020-11-28',14);
