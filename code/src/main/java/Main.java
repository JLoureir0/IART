import java.util.PriorityQueue;

public class Main {
    public static void main(String []args) {

        if (args.length != 1) {
            System.err.println("Expected just one argument, the database filepath.");
            return;
        }
        String db_filepath = args[0];

        Parser parser = new Parser();
        ParsedData data = null;
        try {
            System.out.println("Parsing the json database file.");
            data = parser.parse(db_filepath);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        PriorityQueue<Programmer> programmers = data.getProgrammers();
        while (programmers.size() != 0) {
            System.out.println(programmers.poll());
        }


    }
}
