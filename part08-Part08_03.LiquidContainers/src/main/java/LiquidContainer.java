
public class LiquidContainer {
    private int amount;
    private int maxAmount;
    
    public LiquidContainer(){
        this.amount = 0;
        this.maxAmount = 100;
    }
    
    public void addAmount(int amount){
        if(amount <= 0)
            return;
        
        this.amount += amount;
        if(this.amount > 100)
            this.amount = 100;
    }
    
    public void removeAmount(int amount){
        if(amount <= 0)
            return;
        
        this.amount -= amount;
        if(this.amount < 0){
            this.amount = 0;
        }
        
    }
    
    public void moveAmount(LiquidContainer container, int amount){
        if(amount <=0)
            return;
        
        int possibleAmount = 0;
        if(amount > this.amount){
            possibleAmount = this.amount;
        } else {
            possibleAmount = amount;
        }
        
        
        this.removeAmount(possibleAmount);
        container.addAmount(possibleAmount);
        
    }
    
    @Override
    public String toString(){
        return this.amount + "/" + this.maxAmount;
    }
}
