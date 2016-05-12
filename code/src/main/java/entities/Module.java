package entities;

import java.util.ArrayList;
import java.util.Iterator;

public class Module {

    final private ArrayList<Task> tasks;
    final private String name;

    public Module(String name_, ArrayList<Task> tasks_) {
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

    public Module copy() {
        ArrayList<Task> tasks_copy = new ArrayList<>(this.tasks.size());
        this.tasks.forEach(task -> tasks_copy.add(task.copy()));

        return new Module(this.name, tasks_copy);
    }
}
