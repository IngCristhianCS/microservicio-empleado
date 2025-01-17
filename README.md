# **Gestión de Empleados - API REST**

Este proyecto es una API REST desarrollada con **Spring Boot**, que permite gestionar empleados en una base de datos en memoria (**H2**). Incluye operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y una documentación interactiva con **Swagger**.

---

## **Características**
- CRUD para la entidad `Empleado`.
- Validaciones con **Jakarta Validation** para garantizar la calidad de los datos.
- Manejo global de errores con `@ControllerAdvice`.
- Documentación y pruebas interactivas con **Swagger**.
- Base de datos en memoria (**H2**) para desarrollo y pruebas.

---

## **Tecnologías Utilizadas**
- **Spring Boot 3.4.1**
- **Java 17**
- **Spring Data JPA**
- **H2 Database**
- **Springdoc OpenAPI (Swagger)**
- **Lombok**

---

## **Requisitos Previos**
- Java 17 instalado.
- Maven instalado.
- Un IDE como IntelliJ IDEA, Eclipse o Visual Studio Code.

---

## **Cómo Ejecutar el Proyecto**
1. **Clonar el Repositorio**
   ```bash
   git clone <URL-del-repositorio>
   cd <nombre-del-proyecto>
   ```

2. **Compilar el Proyecto**
   ```bash
   mvn clean install
   ```

3. **Ejecutar la Aplicación**
   ```bash
   mvn spring-boot:run
   ```

4. **Acceder a la Aplicación**
   - Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
   - H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## **Configuración de Base de Datos (H2)**
La base de datos H2 está configurada para ejecutarse en memoria. Los datos se reinician cada vez que se inicia la aplicación.

### **Credenciales de la Consola H2**
- **URL JDBC:** `jdbc:h2:mem:testdb`
- **Usuario:** `sa`
- **Contraseña:** *(sin contraseña)*

---

## **Documentación de la API**
La API está documentada con **Swagger** y puede ser accedida en [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

### **Endpoints Principales**
| Método | Endpoint                | Descripción                          |
|--------|-------------------------|--------------------------------------|
| GET    | `/api/empleados`        | Obtiene todos los empleados          |
| GET    | `/api/empleados/{id}`   | Obtiene un empleado por ID           |
| POST   | `/api/empleados`        | Crea un nuevo empleado               |
| PUT    | `/api/empleados/{id}`   | Actualiza un empleado existente      |
| DELETE | `/api/empleados/{id}`   | Elimina un empleado por ID           |

---

## **Estructura del Proyecto**
```
src/main/java/com/prueba/demo/empleado
├── controller         # Controladores REST
│   ├── EmpleadoController.java
│   └── handler        # Manejo global de excepciones
│       └── GlobalExceptionHandler.java
├── dto                # Data Transfer Objects
│   └── ResponseDTO.java
├── model              # Entidades JPA
│   └── Empleado.java
├── repository         # Repositorios JPA
│   └── EmpleadoRepository.java
├── service            # Lógica de negocio
│   ├── EmpleadoService.java
│   └── EmpleadoServiceImpl.java
└── config             # Configuración de Swagger
    └── SwaggerConfig.java
```

---

## **Manejo de Errores**
La API utiliza un controlador global para capturar y responder errores de forma uniforme.

### **Ejemplo de Respuesta de Error**
```json
{
    "uuid": "123e4567-e89b-12d3-a456-426614174000",
    "statusCode": 0,
    "message": "Error: Empleado con ID 1000 no encontrado",
    "info": null
}
```

---

## **Pruebas**
Puedes usar herramientas como **Postman** o **Swagger UI** para probar los endpoints de la API.

### **Ejemplo de Petición POST**
**URL:** `http://localhost:8080/api/empleados`  
**Body:**
```json
{
    "nombre": "Carlos",
    "apellidoPaterno": "Castillo",
    "apellidoMaterno": "López",
    "curp": "CACL920101HDFRRL09",
    "telefono": "1234567890",
    "sexo": "H"
}
```

### **Respuesta Esperada**
```json
{
    "uuid": "123e4567-e89b-12d3-a456-426614174000",
    "statusCode": 1,
    "message": "Empleado guardado con éxito",
    "info": {
        "id": 1,
        "nombre": "Carlos",
        "apellidoPaterno": "Castillo",
        "apellidoMaterno": "López",
        "curp": "CACL920101HDFRRL09",
        "telefono": "1234567890",
        "sexo": "H"
    }
}
```

---

## **Contribuciones**
1. Crea un fork del repositorio.
2. Crea una rama para tu funcionalidad.
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y haz un commit.
   ```bash
   git commit -m "Agrega nueva funcionalidad"
   ```
4. Sube los cambios a tu fork.
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un Pull Request en el repositorio principal.

---

## **Licencia**
Este proyecto está bajo la licencia **MIT**.
