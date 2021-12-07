import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {
   
    private List<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList();
    }
    
    public void add(Card card) {
        if(card == null) {
            return;
        }
        
        cards.add(card);
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    public void print() {
        cards.stream()
                .sorted()
                .forEach(value -> System.out.println(value));
    }
    
    private int sumAll() {
        int sum;
        
        sum = cards.stream()
                .map(card -> card.getValue())
                .reduce(0, (previousSum, value) -> previousSum + value);
        
        return sum;
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
        cards.stream()
                .forEach(card -> System.out.println(card));
    }

    @Override
    public int compareTo(Hand compared) {
        int result = 0;
        result = sumAll() - compared.sumAll();
        return result;
    }
    
    
}
