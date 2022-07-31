package cz.jakvitov.psservice.controllers.support_objects;

/**
 * @Author Jakub Vítovec
 *  <h1>Support object containing replacement text for PsPost</h1>
 */
public class PostReplacementText {

    private String replacement;

    public PostReplacementText() {
    }

    public PostReplacementText(String replacement) {
        this.replacement = replacement;
    }

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }
}
