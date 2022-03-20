package Sections;

// one flashcard 
public class Card { 
    private String question; 
    private String answer; 
    private int level;

    // initializes a card 
    public Card(String question, String answer, int level) { 
        this.question = question; 
        this.answer = answer; 
        this.level = level;
    }

    // returns question
    public String getQuestion() { 
        return question; 
    }

    // returns answer 
    public String getAnswer() { 
        return answer; 
    }

    // returns level of difficulty of flashcard 
    public int getLevel() { 
        return level; 
    }

    // public JSONObject toJson() {
    //     JSONObject json = new JSONObject();
    //     json.put("Question", question);
    //     json.put("Answer", answer);
    //     json.put("Level", level);
    //     return json;
    // }

}