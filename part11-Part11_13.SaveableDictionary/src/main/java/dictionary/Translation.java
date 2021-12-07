package dictionary;

import java.util.Objects;

public class Translation {
    private final String word;
    private final String translation;
    
    public Translation(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }
    
    public String getWord() {
        return this.word;
    }
    
    public String getTranslation() {
        return this.translation;
       
    }
    
    public String getOppositeWord(String word) {
        if(this.word.equals(word)) {
            return this.translation;
        }
        if(this.translation.equals(word)) {
            return this.word;
        }
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash * word.length() * translation.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Translation other = (Translation) obj;
        
        if (Objects.equals(this.word, other.word)) {
            return true;
        }
        if (Objects.equals(this.word, other.translation)) {
            return true;
        }
        
        if (Objects.equals(this.translation, other.translation)) {
            return true;
        }
        if (Objects.equals(this.translation, other.word)) {
            return true;
        }
        return false;
    }
    
    
}
