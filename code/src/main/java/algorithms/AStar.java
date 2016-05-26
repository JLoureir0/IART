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
    ;

    public AStar(ParsedData data_) {
        this.parsedData = data_;
        this.result = new LinkedList<>();
    }

    public LinkedList<SubResult> compute() {
        this.result.clear();
        PriorityQueue<Programmer> programmers = this.parsedData.getProgrammersCopy();
        ArrayList<Module> modules = this.parsedData.getModulesCopy();

        //obter o trabalhador com menos custo
        Programmer programmer = programmers.poll();



        ArrayList<Module> modulos = new ArrayList<Module>();
        ArrayList<Technology> techno = new ArrayList<Technology>();

// obter as tasks
        for(int i = 0; i< modules.size(); i++) {

                String moduleName = modules.get(i).getName();

                ArrayList<Task> task = modules.get(i).getTasks();


            Module mod = new Module(moduleName,task);

            modulos.add(mod);

//obter as tecnologias
                ArrayList<Task> tasks = mod.getTasks();

            for(int j = 0; j < tasks.size(); j++) {

                String techn = tasks.get(j).getTechnology();

                Technology tech = new Technology(techn);

                techno.add(tech);
            }

            }


// verificar se o programador sabe uma tecnologia das utilizadas no modulo


        //verificar a função programmer.knowsTechnologies
/*
        for(int i = 0; i < techno.size(); i++)
        {
            System.out.println("programador sabe a tecnologia: " + programmer.getTechnologies());

            System.out.println(" tecnologia: " + techno.get(i).getName());

            if(programmer.knowsTechnology(techno.get(i).getName()) == true)
            {
                System.out.println("programador : " + techno.get(i).getName());
            }else {
                System.out.println("programador nao sabe nenhuma das tecnologias ");
            }
        }
*/

// implemetacao do algoritmo em si


        LinkedList<Module> openList = new LinkedList<Module>();  //a visitar
        LinkedList<Module> closedList = new LinkedList<Module>();// ja visitado

        openList.add(0,modulos.get(0));

        boolean done = false;
        Module current;

        while(!done)
        {

            current = modulos.get(0); // ou programmer?
            closedList.add(0,current);
            openList.remove(current);


            if( (current.getTasks() == null)){ // se ja nao houver tasks restantes atinge o objetivo
                return result;
            }

            List<Module> otherModules = modulos;

            for(int i = 1; i < otherModules.size(); i++) {
                Module curentOther = otherModules.get(i);

                if (!openList.contains(curentOther)) {

                    //set current node as previous for this node
                    //set h costs of this node (estimated costs to goal)
                    //set g costs of this node ( costs from start to this node)

                    openList.add(curentOther);


                } else {

                    // se os custos do no seguinte forem menores que os do anterior

                    //set current node as previous for this node
                    // set g costs of this node (costs from start to this node)
                }


                if (openList.isEmpty()) //no path exists
                {
                    return new LinkedList<SubResult>(); //return empty list
                }

            }
            return null; //unreachable

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
