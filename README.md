[README.md](https://github.com/user-attachments/files/31203085/README.md)
API Transporte XYZ

Proyecto de la clase de programacion. Es una API hecha con Spring Boot que sirve
para que la empresa XYZ registre sus camiones y conductores, y pueda asociar
un conductor a un camion.

Tecnologias: Java 17, Spring Boot, Spring Security, H2, Maven.

Para correrlo se usa el comando mvn spring-boot:run y queda funcionando en el
puerto 8080.

La app crea dos usuarios automaticamente para poder probarla, uno con rol
ADMIN (admin / admin123) y otro con rol SUPERVISOR (supervisor / supervisor123).

Todo el API pide usuario y clave (basic auth), no hay ningun endpoint publico.
El admin es el unico que puede crear camiones y conductores. El supervisor
solo puede asociar un conductor a un camion. Los dos pueden ver los listados.

Endpoints:
- POST /api/camiones (solo admin)
- POST /api/conductores (solo admin)
- GET /api/camiones
- GET /api/conductores
- PUT /api/asociaciones/camiones/{id camion}/conductores/{id conductor}

Ejemplo para crear un camion (con curl):
curl -u admin:admin123 -X POST http://localhost:8080/api/camiones -H "Content-Type: application/json" -d "{\"placa\":\"ABC123\",\"tipoVehiculo\":\"Furgon\"}"
