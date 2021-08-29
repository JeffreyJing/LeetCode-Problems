import java.util.NoSuchElementException;
class Vector2D {

    private int[][] vector;
    private int inner;
    private int outer;
    
    public Vector2D(int[][] vec) {
        this.vector = vec;
        this.inner = 0;
        this.outer = 0;
    }
    
    private void update() {
        while (outer < vector.length && inner == vector[outer].length) {
            inner = 0;
            outer++;
        }
    }
    
    public int next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        
        return vector[outer][inner++];
    }
    
    public boolean hasNext() {
        update();
        return this.outer < this.vector.length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */