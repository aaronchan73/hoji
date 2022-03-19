// package JSON;
// import org.json.JSONArray;
// import org.json.JSONObject;

// public class JsonWriter {
//     private static final int TAB = 4;
//     private PrintWriter writer;
//     private String destination;

//     // EFFECTS: constructs writer to write to destination file
//     public JsonWriter(String destination) {
//         this.destination = destination;
//     }

//     public void open() throws FileNotFoundException {
//         writer = new PrintWriter(new File(destination));
//     }

//     public void writeDeck(Deck d) {
//         JSONObject json = d.toJsonDeck();
//         saveToFile(json.toString(TAB));
//     }

//      public void close() {
//         writer.close();
//     }

//     private void saveToFile(String json) {
//         writer.print(json);
//     }
// }
