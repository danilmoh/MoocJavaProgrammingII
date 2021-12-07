public class Hideout<T> {
    
    private T hiddenObj;
    private boolean hidden;
    
    public Hideout() {
        hidden = false;
    }
    
    public void putIntoHideout(T toHide) {
        hiddenObj = toHide;
        hidden = true;
    }
    
    public T takeFromHideout() {
        return hiddenObj;
    }
    
    public boolean isInHideout() {
        return hidden;
    }
    
}
