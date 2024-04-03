public class Solution {
    /**
     * @param k: the number of auction participants
     * @return: the number of confusing numbers
     */
     HashMap<Integer, Integer> map;
     int count;
    public int theConfusingNumbers(int k) {
        // write your code here
        this.map = new HashMap<>();
        this.count = 0;
        map.put(0,0);
        map.put(1,1);
        map.put(6,9);
        map.put(8,8);
        map.put(9,6);
        dfs(0l,k);
        return count;
    }
    private void dfs(long curr , int k){
        if(curr > k) return;
        //logic
        if(isConfusing((int)curr)) count++;
        for(int digit: map.keySet()){
            long newNum = curr*10 + digit;
            if(newNum != 0){
                dfs(newNum, k);
            }
        }
    }

    private boolean isConfusing(int num){
        int temp = num;
        int result = 0;
        while(num > 0){
            int digit = num%10;
            result = result*10 + map.get(digit);
            num = num/10;
        }
        return result != temp;
    }
}
