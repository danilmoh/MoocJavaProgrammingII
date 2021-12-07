import java.util.HashMap;

public class Abbreviations {
    
    private HashMap<String, String> abbreviations;
    
    public Abbreviations(){
        abbreviations = new HashMap<>();
    }
    
    public void addAbbreviation(String abbreviation, String explanation){
        abbreviations.put(sanitizeString(abbreviation), explanation);
    }
    
    public boolean hasAbbreviation(String abbreviation){
        if(abbreviations.containsKey(abbreviation))
                return true;
        else
            return false;
    }
    
    public String findExplanationFor(String abbreviation){
        if(hasAbbreviation(abbreviation)){
            return abbreviations.get(abbreviation);
        } else {
            return null;
        }
    }
    
    public static String sanitizeString(String text){
        String s = text.toLowerCase();
        s = s.trim();
        
        return s;
    }
}
