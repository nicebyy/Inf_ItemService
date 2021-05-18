# Inf_ItemService

this Project is tiny ItemService in SpringFramework by Inflearn.

# 2021-05-17
## ItemDomain 리팩토링.(v2)
Controller가 기존에 Repository를 의존하던것을 Service로 변경. 
Service는 추상화된 Repository를 DI.

# 2021-05-18
## MemberDomain 추가.(v3)
Member 화면 폼 및 Member Domain 관련 MVC추가.
Slf4j와 AOP를 적용하여 각 컴포넌트 호출시 걸리는 시간을 log에 기록.
