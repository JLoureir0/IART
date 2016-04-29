import java.util.PriorityQueue;

public class ParsedData {
    private final PriorityQueue<Programmer> programmers;

    ParsedData(PriorityQueue<Programmer> programmers_) {
        this.programmers = programmers_;
    }

    public PriorityQueue<Programmer> getProgrammers() {
        return programmers;
    }
}
