package bill.lesson3hw;

/**
 * Created by DHZ_Bill on 9/19/16.
 * Class ToDoItem
 */

public class ToDoItem {
    private String toDo; // the content of the item
    private long Id; // the id of the item
    public ToDoItem(String toDo){
        this.setToDo(toDo);
    }
    // setters and getters
    public void setToDo(String toDo){
        this.toDo = toDo;
    }
    public String getToDo(){
        return this.toDo;
    }
    public void setId(long Id){
        this.Id = Id;
    }
    public long getId(){
        return this.Id;
    }
}
