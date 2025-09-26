class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        k = k%dq.size();
        
        if(type == 2) {
            k = dq.size() - k;
        }
        
        while(k-- > 0) {
            dq.addFirst(dq.pollLast());
        }
        
    }
}