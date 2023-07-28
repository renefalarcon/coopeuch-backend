# Prueba Coopeuch
* Esta aplicación esta desarrollada baja el Ide Intellij y conexión a la base de datos Oracle 12c mediante docker
* Es un servicio rest que posee las siguientes funciones:
* Listar
* Crear o Modificar(En caso de que exista modifica sino crea)
* Eliminar tarea

## Correr la aplicacion localmente

## Paso 1
* Se debe abrir el archivo application.properties
* Modificar la ip, puerto, y SID de conexión
* Modificar el usuario y clave de la base de datos

## Paso 2
*  Ejecutar el botón play para que la aplicación corra 
*  Ir la siguiente dirección : http://localhost:8080/swagger-ui.html#/

## Notas
* Esta aplicación al ejecutarse se crea la tabla Tareas con los siguientes campos:
* Identificador(Integer)
* Descripcion(String)
* FechaCreacion(Date)
* Vigente(Boolean)
