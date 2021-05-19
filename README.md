# Inf_ItemService

인프런 스프링 백엔드 예제 복습용.(예제 itemService + @)

# 2021-05-17
## ItemDomain 리팩토링.(v2)
Controller가 기존에 Repository를 의존하던것을 Service로 변경. 
Service는 추상화된 Repository를 DI.

# 2021-05-18
## MemberDomain 추가.(v3)
Member 화면 폼 및 Member Domain 관련 MVC추가.
Slf4j와 AOP를 적용하여 각 컴포넌트 호출시 걸리는 시간을 log에 기록.

# 2021-05-19
## Domain별 Repository를 H2 실제 DB로 확장.(v4)
이전의 MemoryRepository를 그대로 두고 H2DB와 JPA를 이용하여 JpaRepository생성.
JpaRepository를 Primary설정 및 기본적인 CRUD기능 구현. (Item , Member)
Item , Member 엔티티에 @Entity 애노테이션 추가.

 
