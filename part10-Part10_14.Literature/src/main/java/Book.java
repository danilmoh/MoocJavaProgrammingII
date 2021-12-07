
public class Book {
    
    private String title;
    private int ageRecommendation;
    
    public Book(String title, int ageRecommendation) {
        this.title = title;
        this.ageRecommendation = ageRecommendation;
    }
    
    @Override
    public String toString() {
        return this.title + " (recommended for " + ageRecommendation + " year-olds or older)";
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public int getAgeRecommendation() {
        return this.ageRecommendation;
    }
}
