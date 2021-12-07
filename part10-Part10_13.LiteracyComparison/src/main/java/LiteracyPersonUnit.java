
public class LiteracyPersonUnit implements Comparable<LiteracyPersonUnit> {
    
    private String gender;
    private String location;
    private int yearOfResearch;
    private double literacyPersentage;
    
    public LiteracyPersonUnit(String gender, String location, int yearOfResearch, double literacyPersentage) {
        this.gender = gender;
        this.location = location;
        this.yearOfResearch = yearOfResearch;
        this.literacyPersentage = literacyPersentage;
    }
    
    @Override
    public String toString() {
        return location + " (" + yearOfResearch + "), " +
                gender + ", " + literacyPersentage;
    }
    
    @Override 
    public int compareTo(LiteracyPersonUnit literacyPerson) {
        if(this.literacyPersentage > literacyPerson.literacyPersentage) {
            return 1;
        } else if(this.literacyPersentage < literacyPerson.literacyPersentage) {
            return -1;
        } else {
            return 0;
        }
    }
}
