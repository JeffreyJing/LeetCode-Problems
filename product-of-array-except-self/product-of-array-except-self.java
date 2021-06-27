class Solution {
    public int[] productExceptSelf(int[] list) {
        // list = [1, 2, 3, 4]
        // products should finish as: [24, 12, 8, 6]
        int[] products = new int[list.length];
        products[0] = 1;
        for (int i = 1; i < list.length; i++) {
            products[i] = products[i - 1] * list[i - 1];
        }
        
        // products = [1, 1, 2, 6]
        
        int product = 1;
        for (int i = list.length - 1; i >= 0; i--) {
            products[i] *= product;
            product *= list[i];
        }
        
        // products = [24, 12, 8, 6]
        
        return products;
    }
}