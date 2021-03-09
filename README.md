# Licorería app

## Descripción

Aplicación que representa una tienda de licores online, la cual despliega un listado de productos y permite buscar productos por nombre y categoría. Cada producto muestra información sobre su nombre, imagen y precio. SI el producto no tiene imagen, se muestra una imagen por defecto. Si el producto posee descuento, se muestra el precio original tachado y el precio de oferta.

El proyecto está desplegado en Heroku, en el siguiente [link](http://obscure-beyond-42065.herokuapp.com). 

## Tecnologías usadas

La aplicación está desarrollada usando el lenguaje **Java** y el framework **Spring Boot**, junto con las siguientes dependencias:

- **Thymeleaf**: motor de plantillas HTML
- **JPA e Hibernate**: ORM (Object Relational Mapping, para trabajar con bases de datos)
- **MySQL Connector**: driver conector para bases de datos MySQL
- **Heroku Webapp Runner**: asistente para despliegue de aplicaciones web en Heroku
- **Bootstrap**: framework de CSS para estilos de la página (se excluyen las funcionalidades que usan Javascript)

## Rutas

- **/** : Página de inicio, que despliega el listado completo de productos
- **/search** : Muestra los resultados de la búsqueda por nombre y categoría. Recibe dos parámetros:
    - *"name"*: El nombre a buscar. El buscador no distingue entre mayúsculas y minúsculas, y busca una coincidencia en cualquier posición del nombre del produto.
    - *"category"*: El id de la categoría a buscar. El 0 indica no filtrar por categoría.
