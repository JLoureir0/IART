package algorithms;

import entities.Module;
import entities.Programmer;
import parser.ParsedData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AStar {

    final private LinkedList<SubResult> result;
    final private ParsedData parsedData;

    public AStar(ParsedData data_) {
        this.parsedData = data_;
        this.result = new LinkedList<>();
    }

    public LinkedList<SubResult> compute() {
        this.result.clear();
        PriorityQueue<Programmer> programmers = this.parsedData.getProgrammersCopy();
        ArrayList<Module> modules = this.parsedData.getModulesCopy();

        return this.result;
    }

    public class SubResult {
        final public String module;
        final public String task;
        final public String programmer;

        SubResult(String module, String task, String programmer) {
            this.module = module;
            this.task = task;
            this.programmer = programmer;
        }

        @Override
        public String toString() {
            return module + "-" + task + "-" + programmer;
        }
    }
}
