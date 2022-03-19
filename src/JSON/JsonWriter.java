package JSON;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    public void open() {
        writer = new PrintWriter(new File(destination));
    }

    public void writeDeck(Deck d) {
        JSONObject json = d.toJsonDeck();
        saveToFile(json.toString(TAB));
    }

     public void close() {
        writer.close();
    }

    private void saveToFile(String json) {
        writer.print(json);
    }
}
