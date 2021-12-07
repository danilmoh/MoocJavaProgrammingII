
public class Student extends Person {
    private int studyCredits;
    
    public Student(String name, String address) {
        super(name, address);
    }
    
    public void study() {
        studyCredits++;
    }
    
    public int credits() {
        return this.studyCredits;
    }
    
    @Override
    public String toString() {
        return super.getName() + "\n  " + super.getAddress()
                + "\n  Study credits " + this.studyCredits;
    }
}
