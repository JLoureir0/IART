package algorithms;

import entities.*;
import parser.ParsedData;
import parser.deserializers.ProgrammerDeserializer;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.*;

public class AStar {

    final private LinkedList<SubResult> result;
    final private ParsedData parsedData;
    final private ArrayList<Module> modulos = new ArrayList<Module>();
    final private ArrayList<Technology> techno = new ArrayList<Technology>();
    final private ArrayList<Task> closedList;
    final private PriorityQueue<Task> openList;
    HashMap<Task, Double> gVals;


    public AStar(ParsedData data_) {
        this.parsedData = data_;
        this.result = new LinkedList<>();

        gVals = new HashMap<Task, Double>();
        closedList = new ArrayList<Task>();
        openList = new PriorityQueue<Task>();
    }
    /*
     * retona -1 se ja não houver mais tasks no modulo
     * retorna o index da proxima task se houver
     */
    public int getNeighborTask(int indexModule, int indexTask) {

        int taskNeighbor = 0;
        if(indexTask <= (modulos.get(indexModule).getTasks().size()) -2){
            ArrayList<Task> tasks = modulos.get(indexModule).getTasks();

            taskNeighbor = indexTask + 1;

        }else {
            return -1;

        }
        return taskNeighbor;
    }
    public int getTaskIndex(int indexModule, Task taskName) {

        int taskIndex = 0;

        for (int i = 0; i< modulos.get(indexModule).getTasks().size() -1 ; i++) {

            if (modulos.get(indexModule).getTasks().get(i).getName().equals(taskName.getName())) {
                taskIndex = i;
            } else {

            }
        }

        return taskIndex;
    }
    public int getModule(Task task) {

        int moduleIndex = 0;

        for (int i = 0; i< modulos.size() - 2 ; i++) {
            for (int j = 0; j < modulos.get(i).getTasks().size(); j++) {

                if (modulos.get(i).getTasks().get(j).getName().equals(task.getName())) {
                    moduleIndex = i;
                } else {

                }
            }
        }
        return moduleIndex;
    }
    public LinkedList<SubResult> printProgrammers(Task task){

        return result;
    }

    public LinkedList<SubResult> compute() {
        this.result.clear();
        PriorityQueue<Programmer> programmers = this.parsedData.getProgrammersCopy();
        ArrayList<Module> modules = this.parsedData.getModulesCopy();
        Programmer programmer;

        // obter as tasks
        for (int i = 0; i < modules.size(); i++) {
            String moduleName = modules.get(i).getName();
            ArrayList<Task> task = modules.get(i).getTasks();
            Module mod = new Module(moduleName, task);
            modulos.add(mod);

            //obter as tecnologias
            ArrayList<Task> tasks = mod.getTasks();
            for (int j = 0; j < tasks.size(); j++) {
                String techn = tasks.get(j).getTechnology();
                Technology tech = new Technology(techn);
                techno.add(tech);
            }

        }

// implemetacao do algoritmo em si

        double cost = 0;
        int indexMod = 0;
        int numberModules = modulos.size();
        int numberTasksModule = modulos.get(indexMod).getTasks().size();

        Task end = new Task(modulos.get(numberModules - 2).getTasks().get(numberTasksModule - 1).getName(), modulos.get(numberModules - 2).getTasks().get(numberTasksModule - 1).getTechnology());
        openList.clear();
        closedList.clear();
        Task start = new Task(modulos.get(0).getTasks().get(0).getName(), modulos.get(0).getTasks().get(0).getTechnology());
        gVals.put(start, 0.0);
        openList.add(start);

        while (!openList.isEmpty()) {
            Task current = openList.element();
            if (current.equals(end)) {
                System.out.println("Goal Reached");
                printProgrammers(current);

            }

            closedList.add(openList.poll());

            while ((programmer = programmers.poll()) != null) {

                //confirmar a linguagem do modulo
                if (modulos.get(getModule(current)).getModuleLanguage() == "") {
                    if (programmer.knowsTechnology(start.getTechnology())) {//confirma se o programmer sabe a tecnologia da task
                        cost += programmers.poll().getCost(); //programador com o menor custo
                        modulos.get(getModule(current)).setModuleLanguage(programmer.getLanguages().iterator().next().toString()); // colocar linguagem no modulo da task current
                        break;
                    } else {

                        if (programmer.knowsTechnology(start.getTechnology()) && programmer.knowsLanguage(modulos.get(getModule(current)).getModuleLanguage())) {
                            cost += programmers.poll().getCost(); //programador com o menor custo
                            break;
                        }
                        else{
                            System.out.println("No programmer knows the language and the technology required by the task");
                        }
                    }
                }
                Task neighbor = modules.get(indexMod).getTasks().get(getNeighborTask(indexMod, getTaskIndex(indexMod, current)));
                double hScore = gVals.get(current);

                if (closedList.contains(neighbor))
                    if (gVals.get(neighbor) == null)
                        gVals.put(neighbor, hScore);

                if (!openList.contains(neighbor))
                    openList.add(neighbor);


            }
        }
        return result;
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
