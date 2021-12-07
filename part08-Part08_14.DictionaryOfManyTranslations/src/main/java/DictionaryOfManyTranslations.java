import java.util.HashMap;
import java.util.ArrayList;

public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> translations;
    
    public DictionaryOfManyTranslations() {
        this.translations = new HashMap<>();
    }
    
    public void add(String word, String translation){
        translations.putIfAbsent(word, new ArrayList<>());
        
        ArrayList<String> wordTranslations = translations.get(word);
        if(!wordTranslations.contains(translation)){
            wordTranslations.add(translation);
        }
        
    }
    
    public ArrayList<String> translate(String word){
        if(translations.containsKey(word)) {
            return translations.get(word);
        } else {
            return new ArrayList<String>();
        }
    }
    
    public void remove(String word){
        if(translations.containsKey(word)) {
            translations.remove(word);
        }
    }
}
