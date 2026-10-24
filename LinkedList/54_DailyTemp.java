class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>(); // Empty stack
        for(int i = 0; i < temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){ // Condition false for the first time, second time 74 > 73, third time 75 > 74
                int previousday = stack.pop(); // 73
                arr[previousday] = i - previousday; // arr[0] = 1; 
            }
            stack.push(i); // 0
        }

        return arr;
    }
}