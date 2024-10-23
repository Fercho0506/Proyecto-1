package Activities;

public class Option {
    private String optionText; // Almacena el texto de la opción
    private boolean isCorrect; // Indica si la opción es correcta
    private String explanation; // Almacena la explicación

    // Constructor
    public Option(String optionText, boolean isCorrect, String explanation) {
        this.optionText = optionText;
        this.isCorrect = isCorrect;
        this.explanation = explanation;
    }

    // Getters
    public String getOptionText() {
        return optionText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getExplanation() {
        return explanation;
    }

    // Setters
    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
