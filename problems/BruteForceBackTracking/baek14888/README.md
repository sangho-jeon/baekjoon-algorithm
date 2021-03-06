## 14888 풀이

[문제 보러가기](https://www.acmicpc.net/problem/14888)

----

### 풀이

같은 것이 있는 순열의 문제다. 예를 들어 빨간공 4개, 파란공 2개가 있을 때 순서대로 놓을 수 있는 방법의 수는 중학교 때의 기억을 더듬어 보면   
$6! /(4!2!)$ 일 것이다. 

하지만 우리의 컴퓨터는 15번의 실행만 할 수 없다. 그냥 빨간 공 무한, 파란 공 무한인 경우의 순열을 다 찾고 빨간공의 합과 파란공의 합이 일치할 때 그 경우를 탐색해야 한다.

그러므로 위 문제에서는 최대 $4^11$의 연산을 해야한다 (이래서 input 크기가 중요하다.)   

그래서 comb함수를 재귀로 구현해서 각 순서마다 들어갈 수 있는 연산자를 번호로 표시해놓고 Arrays.equal로 우리가 받은 연산자 배열과 같은지 비교한 후 합을 구하는 sum함수로 넘겨 결과를 반환하는 구조다.


뭐 별로 어렵지는 않은 문제였지만 *같은 것이 있는 순열* 문제를 더 최적화 시킬 순 없을지 궁금하다.

##*추가!*
백트레킹을 적용해서 재귀를 돌릴때 operation num과 비교를 통해 가망없는 경우를 제외하고 순회하도록 수정   
기존 300ms애서 236ms로 효율성이 증가되었다! (큰 차이가 없다는게 좀 실망스럽지만...)