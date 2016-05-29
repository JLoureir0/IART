package entities;

import java.util.ArrayList;
import java.util.Iterator;

public class Module {

    final private ArrayList<Task> tasks;
    final private String name;
    private String language;

    /**
     * construtor da class module
     * @param name_
     * @param tasks_
     */
    public Module(String name_, ArrayList<Task> tasks_) {
        this.name = name_;
        this.tasks = tasks_;
        language = "";
    }

    /**
     * metodo usado para obter o nome do modulo
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * array usado para obter as tasks
     * @return tasks
     */
    public ArrayList<Task> getTasks() { return tasks; }

    public void setModuleLanguage(String lang) {language = lang;}

    public String getModuleLanguage() {return language;}

    /**
     * metodo para converter as tasks em string
     * @return
     */
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

    /**
     * obtem o nome do modulo e as suas tasks
     * @return moduleName, tasks
     */
    public Module copy() {
        ArrayList<Task> tasks_copy = new ArrayList<>(this.tasks.size());
        this.tasks.forEach(task -> tasks_copy.add(task.copy()));

        return new Module(this.name, tasks_copy);
    }
}
