import algorithms.AStar;
import parser.ParsedData;
import parser.Parser;
import entities.Programmer;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Expected just one argument, the database filepath.");
            return;
        }
        String db_filepath = args[0];

        Parser parser = new Parser();
        ParsedData parsedData;
        try {
            System.out.println("Parsing the json database file.");
            parsedData = parser.parse(db_filepath);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        PriorityQueue<Programmer> programmers = parsedData.getProgrammers();

        Programmer programmer;
        while ((programmer = programmers.poll()) != null) {
            System.out.println(programmer);
        }

        parsedData.getModules().forEach((module -> System.out.println(module)));

        AStar astar = new AStar(parsedData);
        astar.compute().forEach((subResult) -> System.out.println(subResult));
    }
}
