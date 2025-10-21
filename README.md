# MaxSalud API

API REST para el sistema MaxSalud desarrollada con Spring Boot.

## Requisitos

- Java 17
- Maven
- Docker (para despliegue)
- Oracle Wallet (para conexión a la base de datos)

## Configuración

1. Copiar `application.properties.example` a `application.properties`
2. Actualizar las credenciales de la base de datos en `application.properties`
3. Colocar los archivos del wallet en la carpeta `wallet/`

## Despliegue con Docker

1. Construir la imagen:

```bash
docker build -t maxsalud-backend .
```

2. Ejecutar el contenedor:

```bash
docker run -d -p 8080:8080 maxsalud-backend
```

## Desarrollo local

1. Instalar dependencias:

```bash
mvn install
```

2. Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

## Endpoints principales

- GET /api/reportes - Lista de reportes disponibles
- [Agregar otros endpoints relevantes]
