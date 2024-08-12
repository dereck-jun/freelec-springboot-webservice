# 스프링 부트3 웹 서비스 출시하기 (프리렉)
이 프로젝트는 "스프링 부트와 AWS로 혼자 구현하는 웹 서비스" (저자: 이동욱)의 책에 있는 코드를 참고하였고, 버전의 차이로 일부 코드는 책과 상이할 수 있습니다.
또한 AWS 배포는 진행하지 않았기 때문에 핵심 기능을 제외한 배포를 위한 스크립트의 내용은 포함되어 있지 않습니다.

## 주의
이 프로젝트를 깃 클론을 사용해서 실행하면 제대로 작동되지 않습니다.
구글/네이버 토큰 정보가 없기 때문입니다. (개인적인 정보가 들어있는 설정 파일이기 때문에 ignore 처리 됨)
따라서 테스트 코드만 정상적으로 되니 코드만 참고하세요.

## 사용한 개발 도구
- IntelliJ IDEA Ultimate
- H2 Database

## 프로젝트 환경 점검
### 책의 환경
이 책의 모든 예제는 다음의 환경에서 진행됩니다.
- Java 8
- Gradle 4.x
- Spring Boot 2.1.x

### 프로젝트의 환경
이 프로젝트는 다음의 환경에서 진행됩니다.
- Java 17
- Gradle 8.x
- Spring Boot 3.3.x

## 버전 체크
### Gradle 버전 체크
`프로젝트 루트 경로 > gradle > wrapper > gradle-wrapper.properties` 내의 `distributionUrl` 확인

### Spring Boot 버전 체크
**build.gradle**
```gradle
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.3.2'
    id 'io.spring.dependency-management' version '1.1.6'
}
```
