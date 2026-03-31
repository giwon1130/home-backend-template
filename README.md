# Home Backend Template

Kotlin + Spring Boot starter template for personal backend services.

## Stack
- Kotlin 1.9
- Spring Boot 3.3
- Gradle (Kotlin DSL)
- JUnit 5

## What Included
- `POST /api/auth/login`: login with demo account and issue bearer token
- `GET /api/projects`: return project list for authenticated user
- Feature modules use `controller -> service -> parser -> repository` layering

## Quick Start
1. Copy env sample.
2. Run local profile.

```bash
cp .env.example .env
./gradlew bootRun --args='--spring.profiles.active=local'
```

Server default: `http://localhost:8081`

## Demo Account
- Email: `demo@home.io`
- Password: `home1234`

## API
### 1) Login
```bash
curl -X POST http://localhost:8081/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"email":"demo@home.io","password":"home1234"}'
```

### 2) Get Projects
```bash
curl http://localhost:8081/api/projects \
  -H "Authorization: Bearer <TOKEN_FROM_LOGIN>"
```

## Commands
```bash
./gradlew test
./gradlew build
./gradlew bootRun
```

## Project Structure
```
src/main/kotlin/com/giwon/hometemplate
├── HomeBackendTemplateApplication.kt
├── common/
└── features/
    ├── auth/
    │   ├── controller/
    │   ├── service/
    │   ├── parser/
    │   ├── repository/
    │   ├── model/
    │   └── dto/
    ├── project/
    │   ├── controller/
    │   ├── service/
    │   ├── parser/
    │   ├── repository/
    │   ├── model/
    │   └── dto/
    └── health/
```

## Notes
- This template uses in-memory repositories for demo speed.
- Replace repository layer with DB implementation when moving to production.

## Next Extensions
- Add `bootstrap/` configs (security, db, swagger)
- Add domain folders under `features/<domain>`
- Add Flyway migrations under `src/main/resources/db/migration`
- Add scheduled modules (for example: weather/news summary and notification delivery)
