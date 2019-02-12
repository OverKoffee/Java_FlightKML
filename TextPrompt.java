/*
Class created by Redmal on 2/12/2019.

This class will contain a generic method
that returns, in my case, either a JTextField
or JTextArea with a formatted prompt text toggle.
 */

import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextPrompt<T extends JTextComponent> {
    private String promptText;
    private Font promptFont;
    private Font inputFont;
    private T textBox;

    public TextPrompt(String promptText, T textBox){
        this.promptText = promptText;
        this.textBox = textBox;
        TextPromptObject();
    }

    public void TextPromptObject(){
        promptFont = new Font("promptFont", 2, 12); // italics and plain
        inputFont = new Font("inputFont",1,12); // bold and plain

        textBox.setText(promptText);
        textBox.setFont(promptFont);

        // add event listener to toggle prompt and input
        // text in the text object
        textBox.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                validateFocusGained();
            }
            public void focusLost(FocusEvent e) {
                validateFocusLost();
            }
        });
    }


    public void validateFocusGained(){
        if ((textBox.getText().equals("")) || (textBox.getText().equals(promptText))){
            textBox.setFont(inputFont);
            textBox.setText("");
        }
        else {
            textBox.setFont(inputFont);
        }
    }

    public void validateFocusLost(){
        if ((textBox.getText().equals("")) || (textBox.getText().equals(promptText))){
            textBox.setFont(promptFont);
            textBox.setText(promptText);
        }
        else {
            textBox.setFont(inputFont);
        }
    }

    public T getTextPrompt(){
        return textBox;
    }
}
