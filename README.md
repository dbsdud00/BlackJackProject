# BlackJack Project

1. 참여자는 딜러와 게이머 1:1 게임
2. 카드는 4종류(클로버, 하트, 다이아몬드, 스페이드)이고,
	카드는 각 13장씩 총 52장을 한 세트로 한 게임에는 한세트만 사용한다.
3. 소유한 카드의 합이 21에 가장 근접한 사람이 승리한다.
4. 딜러는 소유한 카드의 합이 17 미만일 경우만 카드를 뽑는다.
5. 21점을 넘을경우 패배(버스트)
6. 양쪽 모두 추가 뽑기 없이, 카드를 오픈하면 딜러와 게이머 중 소유한 카드의 합이 21에 가장 가까운 쪽이 승리한다.
7. 처음에 각자 두장의 카드를 지급받는다.

```
게임시작   
소지금액 입력   
(1)loop strat *** 
게임 초기화(카드 초기화, 플레이어 초기화(딜러, 게이머 객체 초기화))   
베팅금액 입력   
게임 시작   
(2)loop start *** 
딜러와 게이머 2장씩 받기   
게이머 턴(게이머가 멈추거나 버스트 될떄까지)   
버스트 되면 winner는 딜러. (2)loop 나가기   
딜러 턴(17점이 넘어가거나 버스트 될때까지)   
버스트 되면 winner는 게이머. (2)loop 나가기.   
(2)loop end ***
게임결과로 딜러와 게이머의 점수를 보여주기   
둘다 버스트가 안났다면 (winner가 없으면) 점수 비교해서 winner 정하기
누가 이겼는지 출력
게이머가 이겼으면 소지금액에 베팅금액 더하기.
딜러가 이겼으면 소지금액에서 베팅금액 빼기.
비기면 아무것도 안함
돈 없으면 게임 에서 내쫓기
게임 더할지 선택 
게임 더 하고싶으면 (1)loop start로 돌아감
(1)loop end ***
본래 소지금액과 현재 소지금액을 비교해서 얼마를 잃었는지 땃는지 출력
현재 소지금 출력
게임종료 메세지 출력
```
