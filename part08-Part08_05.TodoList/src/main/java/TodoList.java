import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> tasks;
    
    public TodoList(){
        this.tasks = new ArrayList<>();
    }
    
    public void add(String taskText){
        this.tasks.add(taskText);
    }
    
    public void remove(int index){
        if(index<=tasks.size() && index > 0)
        tasks.remove(index-1);
    }
    
    public void print(){
        for(int i = 0; i < tasks.size(); i++){
            System.out.println(i+1 + ": " + tasks.get(i));
        }
    }
}
