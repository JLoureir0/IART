package parser;

import entities.Module;
import entities.Programmer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ParsedData {
    private final PriorityQueue<Programmer> programmers;
    private final ArrayList<Module> modules;

    ParsedData(PriorityQueue<Programmer> programmers_, ArrayList<Module> modules_) {
        this.programmers = programmers_;
        this.modules = modules_;
    }

    public PriorityQueue<Programmer> getProgrammers() {
        return programmers;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public PriorityQueue<Programmer> getProgrammersCopy() {
        int programmers_size = this.programmers.size();
        if (programmers_size != 0) {
            PriorityQueue<Programmer> programmers_copy = new PriorityQueue<>(programmers_size);
            this.programmers.forEach(programmer -> programmers_copy.add(programmer.copy()));
            return programmers_copy;
        } else {
            return new PriorityQueue<>();
        }
    }

    public ArrayList<Module> getModulesCopy() {
        int modules_size = this.modules.size();
        if (modules_size != 0) {
            ArrayList<Module> modules_copy = new ArrayList<>(modules_size);
            this.modules.forEach(module -> modules_copy.add(module.copy()));
            return modules_copy;
        } else {
            return new ArrayList<>();
        }
    }

}
