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
}
