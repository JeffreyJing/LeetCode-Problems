class RandomizedSet {

    private Map<Integer, Integer> map;
    private Random rand;
    private List<Integer> values;
    public RandomizedSet() {
        this.map = new HashMap<Integer, Integer>();
        this.values = new ArrayList<Integer>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if (this.map.containsKey(val)) {
            return false;
        }    
        
        this.map.put(val, this.values.size());
        this.values.add(this.values.size(), val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!this.map.containsKey(val)) {
            return false;
        }
        
        int lastElement = this.values.get(this.values.size() - 1);
        int index = this.map.get(val);
        this.values.set(index, lastElement);
        this.map.put(lastElement, index);
        this.values.remove(this.values.size() - 1);
        this.map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return this.values.get(this.rand.nextInt(this.values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */