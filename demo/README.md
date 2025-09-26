# Sistema de Gestión de Préstamos IMS

Sistema web desarrollado en Spring Boot para la gestión de préstamos de herramientas con base de datos MySQL.
Nota: para visualizar mejor el archivo Ctrl + Shift + V

## Requisitos del Sistema

### Herramientas Necesarias

- **Java 21** o superior
- **Maven 3.6+** 
- **MySQL 8.0+**
- **Git** (para clonar el repositorio)
- **IDE** (IntelliJ IDEA, Eclipse, VS Code)

## Instalación y Configuración

### 1. Clonar el Repositorio

```bash
# Clonar desde GitHub
git clone https://github.com/SarayTorres/prestamo_herramientas_back.git

# Navegar al directorio del proyecto
cd prestamos/demo
```

### 2. Instalar Java 21

#### Windows
1. Descargar Java 21 desde [Oracle](https://www.oracle.com/java/technologies/downloads/) o [OpenJDK](https://adoptium.net/)
2. Ejecutar el instalador y seguir las instrucciones
3. Verificar la instalación:
```bash
java -version
javac -version
```

### 3. Instalar Maven

#### Windows
1. Descargar Maven desde [Apache Maven](https://maven.apache.org/download.cgi)
2. Extraer en `C:\Program Files\Apache\maven`
3. Agregar `C:\Program Files\Apache\maven\bin` al PATH
4. Verificar:
```bash
mvn -version
```

### 4. Instalar y Configurar MySQL

#### Windows
1. Descargar MySQL Installer desde [MySQL Downloads](https://dev.mysql.com/downloads/installer/)
2. Ejecutar el instalador y seleccionar "MySQL Server"
3. Configurar contraseña para root (ejemplo: `123456`)
4. Iniciar el servicio MySQL


### 5. Configurar la Base de Datos

```bash
# Conectar a MySQL
mysql -u root -p

# Ejecutar el script de base de datos
source demo/database/bd_prestamos.sql
```

O ejecutar el archivo SQL directamente:
```bash
mysql -u root -p < demo/database/bd_prestamos.sql
```

### 6. Configurar la Aplicación

Editar el archivo `src/main/resources/application.properties`:

```properties
# Configuración de la conexión a MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/ims_prestamos?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456

# Driver JDBC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Configuración JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

**Importante:** Cambiar la contraseña de MySQL según tu configuración.

## Ejecutar la Aplicación

### Opción 1: Usando Maven
```bash
# Navegar al directorio del proyecto
cd demo

# Compilar y ejecutar
mvn spring-boot:run
```

### Opción 2: Usando el JAR
```bash
# Compilar el proyecto
mvn clean package

# Ejecutar el JAR
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

### Opción 3: Desde el IDE
1. Abrir el proyecto en tu IDE favorito
2. Localizar la clase `DemoApplication.java`
3. Ejecutar como aplicación Java

## Acceder a la Aplicación

Una vez ejecutada, la aplicación estará disponible en:
- **URL:** http://localhost:8080
- **API REST:** http://localhost:8080/prestamos

## Estructura del Proyecto

```
demo/
├── src/
│   ├── main/
│   │   ├── java/com/ims/demo/
│   │   │   ├── controller/     # Controladores REST
│   │   │   ├── model/          # Entidades JPA
│   │   │   ├── repository/     # Repositorios de datos
│   │   │   └── service/        # Lógica de negocio
│   │   └── resources/
│   │       └── application.properties
│   └── test/                   # Pruebas unitarias
├── database/
│   └── bd_prestamos.sql        # Script de base de datos
├── pom.xml                     # Configuración Maven
└── README.md                   # Este archivo
```

##  Tecnologías Utilizadas

- **Spring Boot 3.5.6** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **MySQL 8.0** - Base de datos
- **Maven** - Gestión de dependencias
- **Java 21** - Lenguaje de programación
- **Thymeleaf** - Motor de plantillas (opcional)

##  Endpoints de la API

### Préstamos
- `GET /prestamos` - Listar todos los préstamos
- `POST /prestamos/crear` - Crear nuevo préstamo
- `PUT /prestamos/cerrar/{id}` - Cerrar préstamo

### Usuarios
- `GET /usuarios` - Listar usuarios
- `POST /usuarios/crear` - Crear usuario

### Herramientas
- `GET /herramientas` - Listar herramientas
- `POST /herramientas/crear` - Crear herramienta




