class Solution {
    
    public int fib(int number) {
        if (number == 0) {
            return 0;
        }
        
        Map<Integer, Integer> storage = new HashMap<Integer, Integer>();
        storage.put(1, 1);
        storage.put(2, 1);
        return fibonacci(number, storage);
    }
    
    private int fibonacci(int number, Map<Integer, Integer> storage) {
        if (storage.containsKey(number)) {
            return storage.get(number);
        }
        
        int value = fib(number - 1) + fib(number - 2);
        storage.put(number, value);
        return value;
    }
    
    /* public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        
        if (N <= 2) {
            return 1;
        }
        
        return fib(N - 1) + fib(N - 2);
    } */
}
