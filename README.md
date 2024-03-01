# API Tienda

Este proyecto es una aplicación de ejemplo que representa una tienda en línea. A continuación, se proporciona una descripción general de la estructura del proyecto.

## Estructura del Proyecto

### 1. `com.example.apiTienda.config`
   Contiene configuraciones específicas de la aplicación, como configuraciones de seguridad, configuración de beans, y otras configuraciones relacionadas con Spring.

### 2. `com.example.apiTienda.controller`
   En este paquete se encuentran los controladores de la aplicación que manejan las solicitudes HTTP. Los controladores actúan como puntos de entrada para la lógica de la aplicación y gestionan las interacciones entre el cliente y el servidor.

### 3. `com.example.apiTienda.controller.user`
   Controladores específicos para la gestión de usuarios, como autenticación y autorización.

### 4. `com.example.apiTienda.dto.request`
   Contiene clases que representan objetos de transferencia de datos (DTO) utilizados para mapear las solicitudes recibidas desde el cliente.

### 5. `com.example.apiTienda.dto.response.error`
   Clases que representan respuestas de error devueltas por la aplicación en caso de excepciones o problemas durante la ejecución.

### 6. `com.example.apiTienda.dto.response.user`
   Clases que representan respuestas relacionadas con la gestión de usuarios.

### 7. `com.example.apiTienda.entities`
   Contiene las entidades JPA (Java Persistence API) que representan los modelos de datos de la aplicación. Estas entidades se utilizan para interactuar con la base de datos.

### 8. `com.example.apiTienda.error`
   Clases relacionadas con la gestión de errores y excepciones en la aplicación.

### 9. `com.example.apiTienda.error.exception`
   Excepciones personalizadas y manejo de excepciones específicas de la aplicación.

### 10. `com.example.apiTienda.repository`
   Repositorios de Spring Data JPA que interactúan con la base de datos. Estos repositorios proporcionan métodos para realizar operaciones CRUD en las entidades.

### 11. `com.example.apiTienda.service`
   Interfaces que definen servicios generales de la aplicación. Estos servicios encapsulan la lógica de negocio y se utilizan para interactuar con las entidades y repositorios.

### 12. `com.example.apiTienda.service.impl`
   Implementaciones concretas de los servicios definidos en el paquete `com.example.apiTienda.service`. Aquí es donde se encuentra la lógica específica de la aplicación.

### 13. `com.example.apiTienda.service.user`
   Servicios relacionados con la gestión de usuarios, como autenticación y autorización.

### 14. `com.example.apiTienda.service.user.impl`
   Implementaciones específicas de servicios relacionados con la gestión de usuarios.

## Ejecución del Proyecto

Para ejecutar la aplicación, puedes utilizar un entorno de desarrollo integrado (IDE) como IntelliJ o Eclipse. Asegúrate de tener las dependencias necesarias y una base de datos configurada según las propiedades definidas en el archivo `application.properties`.

## [Documentación Postman](https://documenter.getpostman.com/view/32967765/2sA2rGwL4T)


