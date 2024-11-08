package programmers._2022_kakao_blind_recruitment;

public class queuesum {
    public static void main(String[] args) {
        Solution_queuesum s = new Solution_queuesum();

        //[3, 2, 7, 2]	[4, 6, 5, 1]
        int[] queue1 = {1, 1, 1, 1};
        int[] queue2 = {1, 1, 7, 1};

        s.solution(queue1, queue2);
    }
}

class Solution_queuesum {
    public int solution(int[] queue1, int[] queue2) {
        /*
        - 산술처리 long 필요
        - 두 큐 원소 총합/2를 기준으로 최소한의 이동 (pop -> insert)
        - 불가한 경우 -1
          => 두 큐의 요소 수 만큼 이동해도 안되는 경우

          sum이 큰 곳에서 작은 곳으로 이동 반복
         */
        int answer = 0;
        final int firstQueueSize = queue1.length;

        QueueProcess q1 = new QueueProcess(queue1);
        QueueProcess q2 = new QueueProcess(queue2);

        while (true) {
            if (q1.getSum() == q2.getSum()
                    || (q1.getMoveCount() >= firstQueueSize && q2.getMoveCount() >= firstQueueSize)) {
                break;
            }
            if (q1.getSum() > q2.getSum()) {
                q1.move(q2);
            } else if (q1.getSum() < q2.getSum()) {
                q2.move(q1);
            }
        }

        if (q1.getSum() == q2.getSum()) {
            answer = q1.getMoveCount() + q2.getMoveCount();
        } else {
            answer = -1;
        }

        return answer;
    }

    static class QueueProcess {
        private int[] queue;
        private int moveCount;
        private int index = 0;
        private long sum;

        public QueueProcess(int[] queue) {
            this.queue = queue;

            for (int i = 0; i < queue.length; i++) {
                this.sum += (long) queue[i];
            }
        }

        public void move(QueueProcess other) {
            // 현 idx pop -> other의 sum 추가
            long targetElement = 0;
            if (this.index >= queue.length) {
                targetElement = other.queue[this.index % queue.length];
            } else {
                targetElement = this.queue[this.index];
            }
            other.add(targetElement);
            this.minus(targetElement);

            this.index++;
            this.moveCount++;
        }

        public void add(long num) {
            this.sum += num;
        }

        public void minus(long num) {
            this.sum -= num;
        }

        public long getSum() {
            return this.sum;
        }

        public int getMoveCount() {
            return this.moveCount;
        }
    }
}