# WalkingClub

개인 일정과 댓글, 대댓글 기능이 있습니다.
일정을 등록하고, 해당 일정에 댓글과 대댓글을 남길 수 있는 구조로 되어 있습니다.
회원 기능 없이도 작성자 ID는 내부에서 처리됩니다.

---

## 기술 스택

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL / H2
- Jackson `@JsonView`

---

## 패키지 구조


```
com.example.walkingclub
├── controller       // REST API 컨트롤러
├── dto              // 요청, 응답 DTO + JsonView 정의
├── entity           // JPA Entity
├── exception        // 예외 처리
├── repository       // JPA Repository 인터페이스
└── service          // 비즈니스 로직 처리
```

---

## 주요 기능

- 일정 생성 / 수정 / 단건 조회 / 전체 조회 / 삭제
- 댓글 생성 / 조회 / 수정 / 삭제
- 대댓글 생성 / 조회 / 수정 / 삭제
- 댓글 수를 포함한 일정 전체 목록 조회 기능
- JsonView를 활용한 응답 필드 제한

---

## API 명세

### [일정]
| 메서드 | URL             | 설명            | 응답코드 |
|--------|------------------|------------------|----------|
| POST   | /schedule        | 일정 생성        | 201      |
| GET    | /schedule        | 일정 전체 조회   | 200      |
| GET    | /schedule/{id}   | 일정 단건 조회   | 200      |
| PUT    | /schedule/{id}   | 일정 수정        | 200      |
| DELETE | /schedule/{id}   | 일정 삭제        | 204      |

### [댓글]
| 메서드 | URL               | 설명          | 응답코드 |
|--------|--------------------|---------------|----------|
| POST   | /comment           | 댓글 생성      | 201      |
| GET    | /comment           | 댓글 조회      | 200      |
| PUT    | /comment/{id}      | 댓글 수정      | 200      |
| DELETE | /comment/{id}      | 댓글 삭제      | 204      |

### [대댓글]
| 메서드 | URL               | 설명             | 응답코드 |
|--------|--------------------|------------------|----------|
| POST   | /reply             | 대댓글 생성       | 201      |
| GET    | /reply             | 대댓글 조회       | 200      |
| PUT    | /reply/{id}        | 대댓글 수정       | 200      |
| DELETE | /reply/{id}        | 대댓글 삭제       | 204      |

---

## ERD

![ERD](https://github.com/user-attachments/assets/3b372349-8495-4e2f-9258-397be4b303da)

---

## JsonView / Validation 전략

- `@JsonView`를 활용하여 요청 상황별로 필요한 응답 필드만 선택적으로 반환
  - 예: 전체 조회, 단건 조회, 생성 시 반환 필드가 다름

- `@Validated(View.XXX.class)`로 유효성 검사 그룹 지정
  - 예: 댓글 생성 시 `scheduleId + comments` 필요, 수정 시 `comments`만 필요

→ View 클래스를 통해 JsonView와 Validation 그룹을 일관되게 분리, 관리함

---

## 엔티티 관계 요약

- Schedule (일정)
  - 1:N → Comment (댓글)
- Comment (댓글)
  - 1:N → Reply (대댓글)
- Reply (대댓글)
  - N:1 → Schedule
  - N:1 → Comment

---

## 트러블슈팅

- **작성자 ID가 null로 저장되는 문제**
  - 로그인 없이 ID를 자동 증가시키는 요구사항이 있었고,
  - DTO 변환 또는 서비스 내부에서 writerId를 직접 지정해 해결

- **일정 삭제 시 외래키 제약 오류 발생**
  - 일정 삭제 시 연관된 대댓글 → 댓글 → 일정 순으로
  - 서비스 계층에서 명시적으로 수동 삭제 처리하여 해결함

- **대댓글 조회 시 Repository 메서드 타입 오류 발생**
  - `findByCommentId(Long)`으로 작성했으나 JPA는 `Comment` 타입을 기대하고 있었음
  - `findByComment(Comment)`로 수정하고, `.findById()`로 Entity 조회 후 넘겨서 해결

---

## 후기

지피티 없이 해결하라는 과제 요구에 처음엔 꽤 당황했다.
코드는 직접 짤 수 있어도, 오류가 발생했을 때 해결 방법을 모르거나
새로운 기능이 필요한데 그걸 어떻게 찾을지 몰라 답답한 순간이 많았다.
나는 튜터님 찾아가는 걸 안 좋아해서 더 어려움을 느꼈다.

그렇지만 막상 하나하나 직접 하다 보니 의외로 재미도 있었고,
CRUD 하나라도 전보다는 훨씬 잘 짜게 된 것 같다는 느낌이 든다.
물론 아직도 부족한 점은 많지만, 스스로 해보면서 알게 된 기능도 많았고
그만큼 고생도 했지만 보람찬 과제였다.
