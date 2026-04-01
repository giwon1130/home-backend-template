# giwon-home-api

공개용 프로젝트 허브와 자기소개 페이지를 위한 Kotlin + Spring Boot API 서버다.

## Stack
- Kotlin 1.9
- Spring Boot 3.3
- Gradle (Kotlin DSL)
- JUnit 5

## What Included
- `GET /api/profile`: 공개 프로필 정보 제공
- `GET /api/projects`: 공개 프로젝트 카탈로그 제공
- 프로젝트별 `liveUrl / repositoryUrl / docsUrl` 링크 제공
- 기존 로그인 API는 템플릿 용도로 유지
- Feature modules use `controller -> service -> parser -> repository` layering

## Quick Start
1. Copy env sample.
2. Run local profile.

```bash
cp .env.example .env
./gradlew bootRun --args='--spring.profiles.active=local'
```

Server default: `http://localhost:8081`

## Docker
```bash
docker build -t giwon-home-api .
docker run -p 8081:8081 giwon-home-api
```

- `giwon-home`와 함께 띄울 때는 frontend repo의 `docker-compose.yml`을 사용한다.

## API
### 1) Profile
```bash
curl http://localhost:8081/api/profile
```

### 2) Get Projects
```bash
curl http://localhost:8081/api/projects
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
- 공개 허브/포트폴리오용 API를 먼저 제공하는 구조다.
- 허브에 연결할 서비스가 늘어나면 `ProjectRepository`에 링크만 추가하는 방식으로 확장한다.

## Next Extensions
- profile/projects 데이터를 파일 또는 DB로 분리
- 대표 프로젝트 정렬/필터 추가
- 공개 링크 외에 상세 설명 페이지 추가
- 다른 공개 서비스 API를 동일한 패턴으로 추가
