
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        this.numbers = new ArrayList<>();
        Random numberGenerator = new Random();
        for(int i = 0 ; i < 7; i++) {
            int randomNumber = numberGenerator.nextInt(40)+1;
            while(containsNumber(randomNumber)) {
                randomNumber = numberGenerator.nextInt(40)+1;
            }
            this.numbers.add(randomNumber);
        }
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }
}

