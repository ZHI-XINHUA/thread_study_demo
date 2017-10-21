package package2;

/**
 * Created by zhixinhua on 17/10/19.
 */
public class Task implements  Comparable<Task> {
    private int id;
    private String name;

    public  Task(){

    }

    public  Task(int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Task task) {
        return (this.id>task.id)?1:(this.id<task.id)?-1:0;
    }

    @Override
    public String toString() {
        return this.id+">"+this.name;
    }
}
