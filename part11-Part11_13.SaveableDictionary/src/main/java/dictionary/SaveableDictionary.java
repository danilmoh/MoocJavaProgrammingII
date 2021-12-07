package dictionary;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SaveableDictionary {

    private List<Translation> translations;
    private String dictionaryPath;
    
    public SaveableDictionary(String file) {
        this.translations = new ArrayList<>();
        this.dictionaryPath = file;
    }
    
    public SaveableDictionary() {
        this.translations = new ArrayList<>();
        this.dictionaryPath = null;
    }
    
    public void add(String word, String translation) {
        Translation translObj = new Translation(word, translation);
        if(translations.contains(translObj)) {
            return;
        } else {
            translations.add(translObj);
        }
    }
    
    public String translate(String word) {
        
        if(hasWord(word)) {
            return translations.stream()
                    .filter(value -> value.equals(new Translation(word, null)))
                    .collect(Collectors.toCollection(ArrayList::new))
                    .get(0).getOppositeWord(word);
        }
        
        return null;
    }
    
    private boolean hasWord(String word) {
        if(this.translations.contains(new Translation(word, null)))
            return true;
        else 
            return false;
    }
    
    public void delete(String word) {
        
        if(hasWord(word)) {
            translations.remove(getIndexOf(word));
        }
    }
    
    public int getIndexOf(String word) {
        int index = -1;
        
        for(int i = 0; i < translations.size(); i++) {
            if(translations.get(i).equals(new Translation(word, null))) {
                index = i;
            }
        }
        
        return index;
    }
    
    public boolean load() {
        
        try (Scanner reader = new Scanner(Paths.get(dictionaryPath))){
            readTranslationsFromFile(reader);
        } catch (IOException e) {
            return false;
        }
        
        return true;
    }
    
    private void readTranslationsFromFile(Scanner reader) throws IOException {
        while(reader.hasNextLine()) {
            String line = reader.nextLine();

            String[] parts = line.split(":");

            Translation translation = new Translation(parts[0], parts[1]);
            this.translations.add(translation);
        }
    }
    
    public boolean save(){
        try {
            saveTranslationsToFile();
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }
    
    private void saveTranslationsToFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(dictionaryPath) ;
        Iterator<Translation> iterator = translations.iterator();
        
        while(iterator.hasNext()) {
            Translation translation = iterator.next();
            
            writer.println(translation.getWord()+":"+translation.getTranslation());
            
        }
        writer.close();
    }
}    
