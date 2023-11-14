# 구현할 기능 목록
## 관계 도식
## 다이어그램 
## 다이어그램
### 구조 안내
- 주문(order) 과 계산(checkstand) 의 두 패키지로 분리
    - order 에는 날짜를 처리하는 day, 메뉴를 처리하는 menu 로 구성
    - checkstand 에는 할인과 이벤트를 처리하는 present, 뱃지를 처리하는 badge 로 구성되어있음

### 전체 구조
![total-simple](https://github.com/snaag/java-christmas-6-snaag/assets/42943992/5aa2a006-6de3-4910-8518-2126d2420190)

<details>
<summary>전체 구조 detail</summary>

![total-detail](https://github.com/snaag/java-christmas-6-snaag/assets/42943992/33967d8d-5d5f-40fb-a146-739a829c7ee5)

</details>


### 주문
![order](https://github.com/snaag/java-christmas-6-snaag/assets/42943992/a7762d3d-18b0-4445-ac96-6081a34802da)

<details>
<summary>주문 detail</summary>

![order-detail](https://github.com/snaag/java-christmas-6-snaag/assets/42943992/0a17d17e-917e-42ed-be1a-84f8dac96496)

</details>


### 계산
![checkstand](https://github.com/snaag/java-christmas-6-snaag/assets/42943992/c551ca35-2a68-4121-b0c5-5cdd02515a7c)

<details>
<summary>계산 detail</summary>

![checkstand-detail](https://github.com/snaag/java-christmas-6-snaag/assets/42943992/6fafdf6c-d7a8-4d99-861b-9413c57e6fbf)

</details>



### dto
- 에러 시 입력 무한 로직을 구현하기 위한 DTO

![dto](https://github.com/snaag/java-christmas-6-snaag/assets/42943992/c2c4379b-4e6f-4ea0-b4e3-36822107203b)

### utils
![utils](https://github.com/snaag/java-christmas-6-snaag/assets/42943992/9721b94a-565c-4bcb-93e4-67c722c9054f)


### view
![view](https://github.com/snaag/java-christmas-6-snaag/assets/42943992/82b5ce96-da99-461a-b1b2-47573324bda7)


- TODO

## 기능 목록
- [x] 날짜를 입력받는데, 이때 날짜의 유효성 검증하기
    - 방문할 날짜는 1 이상 31 이하의 숫자만 가능
        - 🚨 1 이상 31 이하의 숫자가 아닌 경우, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지 출력하고 다시 입력 가능해야 함
- [x] 날짜에 따라, 어느 할인 이벤트 기간(크리스마스 디데이, 평일, 특별)에 속해있는지 확인
- [ ] 주문을 받는데, 이때 주문받은 항목의 유효성 검증하기
    - 메뉴 중복
- [x] 주문을 받는데, 이때 주문받은 항목의 유효성 검증하기
    - [x] 메뉴 중복
        - 🚨 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 출력하고 다시 입력 가능해야 함
    - [x] 메뉴 주문 형식이 올바른지
        - 🚨 메뉴 형식이 예시와 다른 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 출력하고 다시 입력 가능해야 함
    - [x] 메뉴 주문 량이 올바른지
        - 🚨 메뉴의 개수는 1 이상의 숫자만 입력되어야 함. 이외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 출력하고 다시 입력 가능해야 함
    - [x] 존재하는 메뉴인지
        - 🚨 고객이 메뉴판에 없는 메뉴를 입력하는 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 출력하고 다시 입력 가능해야 함
    - [x] 음료만 주문하는지
        - 🚨 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력하고 다시 입력 가능해야 함
    - [x] 메뉴의 갯수가 20개보다 많은지 (최대 20개여야 가능)
        - 🚨 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력하고 다시 입력 가능해야 함
- [x] 전체 금액 출력하기
- [x] 증정 이벤트 계산하고 출력하기
- [x] 할인 계산하고 출력하기
    - 크리스마스 디데이 할인
    - 평일 할인
    - 특별 할인
    - 증정 이벤트 할인
- [x] 전체 할인 금액 합산하여 출력하기
- [x] 할인 전 금액에서 할인 금액 뺀 금액 출력하기
- [ ] 할인 금액에 따른 뱃지 계산하고 출력하기 
- [x] 할인 금액에 따른 뱃지 계산하고 출력하기 