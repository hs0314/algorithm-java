package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        /*
         stack을 디자인 -> 가장 작은 값을 o(1)로 받도록
         - leetcode.stack.MinStack
            - push
            - pop => 얘만 element를 삭제함
            - top
            - getMin => o(1)로 스택내 최소값 반환

         - constraints
            - 값은 int 범위내
            - 메서드는 항상 not empty 상태임 보장
            - call수는 30000 이내

         - 기존 스택 자료구조를 쓰고, getMin()을 o(1)로 가져오기 위해서 별도의 구조 사용 (? priority queue / programmers.heap)
         - (개선) 애초에 stack push할때 현재까지의 min값을 갱신해서 저장 (min을 가져오는 연산은 pop을 안함)

         - tc
            - int범위 최대로 들어왔을때 문제 (compareTo를 산술연산으로 하면 이슈있을수 있음..)
         */

         MStack minStack = new MStack();

         minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2



         
    }

    public static class MStack {
        private Stack<Pair> stack = new Stack<>();

        public MStack() {
        }

        public void push(int val) {
            int minSoFar = val;

            if (!stack.isEmpty()) {
                minSoFar = Math.min(stack.peek().getMinSoFar(), minSoFar);
            }

            Pair value = new Pair(val, minSoFar);
            stack.push(value);
        }
        
        public void pop() {
            stack.pop(); // empty 에서 호출 없음 보장
        }
        
        public int top() {
            return stack.peek().getValue();
        }

        public int getMin() {
            return stack.peek().getMinSoFar();
        }
    }

    private static class Pair {
        private int value;
        private int minSoFar;

        public Pair(int value, int minSoFar) {
            this.value = value;
            this.minSoFar = minSoFar;
        }

        public int getValue() {
            return this.value;
        }

        public int getMinSoFar() {
            return this.minSoFar;
        }
    }
}
