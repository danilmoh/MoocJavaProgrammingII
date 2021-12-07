
public class Container {
    private int amount;
    private int maxAmount;
    
    public Container(){
        this.amount = 0;
        this.maxAmount = 100;
    }
    
    public void add(int amount){
        if(amount <= 0)
            return;
        
        this.amount += amount;
        if(this.amount > 100)
            this.amount = 100;
    }
    
    public void remove(int amount){
        if(amount <= 0)
            return;
        
        this.amount -= amount;
        if(this.amount < 0){
            this.amount = 0;
        }
        
    }
    
    public void move(Container container, int amount){
        if(amount <=0)
            return;
        
        int possibleAmount = 0;
        if(amount > this.amount){
            possibleAmount = this.amount;
        } else {
            possibleAmount = amount;
        }
        
        
        this.remove(possibleAmount);
        container.add(possibleAmount);
        
    }
    
    public int contains(){
        return this.amount;
    }
    
    @Override
    public String toString(){
        return this.amount + "/" + this.maxAmount;
    }
}
