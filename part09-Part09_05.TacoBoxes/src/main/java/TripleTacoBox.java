
public class TripleTacoBox implements TacoBox {
    
    private int tacos;
    
    public TripleTacoBox() {
        tacos = 3;
    }

    @Override
    public int tacosRemaining() {
        return this.tacos;
    }

    @Override
    public void eat() {
        if(tacos > 0) {
            tacos--;
        }
    }
    
}
