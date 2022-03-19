// package JSON;
// public class JsonReader {
//     private String source;

//     //EFFECTS: constructor
//     public JsonReader(String source) {
//         this.source = source;
//     }

//     // EFFECTS: reads source file as string and returns it
//     private String readFile(String source) throws IOException {
//         StringBuilder contentBuilder = new StringBuilder();

//         try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
//             stream.forEach(s -> contentBuilder.append(s));
//         }

//         return contentBuilder.toString();
//     }

//     public Deck readDeck() throws IOException {
//         String jsonData = readFile(source);
//         JSONObject jsonObjectDeck = new JSONObject(jsonData);
//         return parseDeck(jsonObjectDeck);
//     }


//     private Deck parseDeck(JSONObject jsonObject) {
//         String name = jsonObject.getString("Deck Of Cards");
//         Deck deck = new Deck(name);
//         addCard(deck, jsonObject);
//         return deck;
//     }



//     private void addDeck(Deck deck, JSONObject jsonObject) {
//         JSONArray jsonArray = jsonObject.getJSONArray("Deck");
//         for (Object json : jsonArray) {
//             JSONObject nextCard = (JSONObject) json;
//             addCard(deck, nextCard);
//         }
//     }