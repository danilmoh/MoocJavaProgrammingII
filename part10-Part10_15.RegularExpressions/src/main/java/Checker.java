 

public class Checker {
    
    public boolean isDayOfWeek(String string) {
        String regexCheck = "(mon)|(tue)|(wed)|(thu)|(fri)|(sat)|(sun)";
        return string.matches(regexCheck);
    }
    
    public boolean allVowels(String string) {
        String regexCheck = "[aeiou]*";
        return string.matches(regexCheck);
    }
    
    public boolean timeOfDay(String string) {
        String regexCheck = "^(([0-2][0-3])|([0-1][0-9])):[0-5][0-9]:[0-5][0-9]$";
        return string.matches(regexCheck);
    }
    
    
}
