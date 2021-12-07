package application;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class Dictionary {
    private List<String> words;
    private Map<String, String> translations;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
        
        add("Слово", "Word");
    }
    
    public String get(String word) {
        return this.translations.get(word);
    }
    
    public void add(String word, String translation) {
        if(!this.translations.containsKey(word)) {
            this.words.add(word);
        }
        
        this.translations.put(word, translation);
    }
    
    public String getRandomWord() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(this.words.size());
        return this.words.get(randomIndex);
    }
    
}
