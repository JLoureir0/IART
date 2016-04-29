import java.util.ArrayList;
import java.util.Iterator;

public class Module {

    final private ArrayList<Task> tasks;
    final private String name;

    Module(String name_, ArrayList<Task> tasks_) {
        this.name = name_;
        this.tasks = tasks_;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        String tasks_str = null;
        Iterator iterator = this.tasks.iterator();
        if (iterator.hasNext()) {
            Task task = (Task) iterator.next();
            tasks_str = task.toString();
            while (iterator.hasNext()) {
                task = (Task) iterator.next();
                tasks_str += " " + task.toString();
            }
        }
        return this.name + "\t" + tasks_str;
    }
}
