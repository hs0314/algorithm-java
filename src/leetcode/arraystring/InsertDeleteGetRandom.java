package leetcode.arraystring;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class InsertDeleteGetRandom {
    /*
     * insert(int) 는 set에 데이터가 없으면 insert -> insert시 true반환
     * remove(int)는 set에 데이터가 있으면 삭제하고 true 반환
     * int getRandom() 은 현재 set에서 랜덤 e반환 (이때 무조건 데이터 1개존재는 보장)
     *   => 각 e는 뽑힐 확률이 동일하게 보장되어야함
     * 위 모든 작업을 O(1)에 동작하도록 설계
     * 
     * 제한
     * - int범위
     * - 200000 call 발생 가능
     * - 무조건 하나의 e가 있음은 보장
     * 
     * todo
     * - 내부 map을 두고 insert, remove는 O(1)로 구현 가능  
     * - getRandom에서 뽑힐확률 동일하게 유지한다는건... rr?
     *   => O(1)이면 특정 key에 바로 접근이 가능... (treeMap으로 가중치를 value로해서 적은것 하나만..)
     */
    public static void main(String[] args) {
        RandomizedSet rset = new RandomizedSet();

        System.out.println(rset.insert(1));
        System.out.println(rset.insert(2));
        System.out.println(rset.insert(3));
        System.out.println(rset.getRandom());
        System.out.println(rset.remove(2));
        System.out.println(rset.getRandom());
        System.out.println(rset.getRandom());
        System.out.println(rset.getRandom());
    }
}

class RandomizedSet {

    // todo insert/delete O(1)은 map으로 해야한다..
    // queue에다가 넣고 get random이면 poll() -> offer() 반복
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> rset = new HashSet<>();

    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        boolean r = rset.add(val);
        q.offer(val);

        return r;
    }
    
    public boolean remove(int val) {
        boolean r =  rset.remove(val);

        return r;
    }
    
    public int getRandom() {
        int random = q.poll();
        while (!rset.contains(random)){ //delete 됐으면
            random = q.poll();
        }
        q.offer(random);

        return random;
    }
}
