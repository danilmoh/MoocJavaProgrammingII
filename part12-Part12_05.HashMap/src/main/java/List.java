public class List<Type>{
    
    private Type[] values;
    private int firstFreeIndex;
    
    public List() {
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }
    
    public void add(Type value) {
        if(this.firstFreeIndex == this.values.length) {
            grow();
        }
        
        this.values[firstFreeIndex] = value;
        this.firstFreeIndex++;
    }
    
    private void grow() {
        int newSize = this.values.length + this.values.length/2;
        Type[] newValues = (Type[]) new Object[newSize];
        
        for(int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        
        this.values = newValues;
    }
    
    public boolean contains(Type value) { 
        return indexOfValue(value) >= 0;
    }
    
    public void remove(Type value) {
        int indexOfValue = indexOfValue(value);
        if(indexOfValue < 0) {
            return;
        }
        
        System.out.println("indexOfValue = " + indexOfValue);
        
        moveToTheLeft(indexOfValue);
        this.firstFreeIndex--;
    }
    
    private int indexOfValue(Type value) {
        for(int i = 0; i < values.length; i++) {
            if(value.equals(values[i])) {
                return i;
            }
        }
        
        return -1;
    }
    
    private void moveToTheLeft(int fromIndex) {
        for(int i = fromIndex; i < firstFreeIndex - 1; i++) {
            System.out.print("Something happened! ");
            values[i] = values[i+1];
        }
    } 
    
    public Type value(int index) {
        if(index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIndex + "]");
        }
        
        return this.values[index];
    }
    
    public int size() {
        return this.firstFreeIndex;
    }
}
