public class Main {
    public static void main(String []args) {

        if (args.length != 2) {
            System.err.println("Expected the database filepath.");
            return;
        }
        String db_filepath = args[1];

        ParseJson parseJson = new ParseJson();
        parseJson.parse(db_filepath);

        for (Programmer programmer : parseJson.programmers) {
            System.out.println(programmer);
        }
    }
}
