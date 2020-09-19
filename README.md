# Backend
El proyecto fue implementado en Spring Boot.
La base de datos usada es MySql version 14.14 Distrib 5.7.31, for Linux (x86_64),
con nombre db_springboot_backend
usuario: backenduser
contrasena: Passw0rd

La version del servidor wildfly es 20.0.1 Final y fue usado como servidor instalado que corre desde que se enciende la maquina (no es standalone).
Para deployar el proyecto solo ejecutar mvn clean install y el proyecto se va deployar en localhost puerto 9990, el servidor tiene el mismo usuario y contrasena
que la base de datos: backenduser y contrasena Passw0rd.

