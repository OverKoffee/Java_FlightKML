/*
Class created by Redmal on 2/11/2019.
Class similar to TextfieldPrompt to
create a default prompt text in the
TextArea box for the user
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextAreaPrompt {
    private JTextArea textArea;
    private Font promptFont;
    private Font inputFont;
    private String promptText;

    public TextAreaPrompt(){
        textArea = new JTextArea("");
        promptFont = new Font("promptFont", 2, 12); // italics and plain
        inputFont = new Font("inputFont",1,12); // bold and plain

        // set the prompt text string
        promptText = "Paste list of coordinates here...";

        textArea.setText(promptText);
        textArea.setFont(promptFont);

        // add event listener to toggle prompt and input
        // text in the text area
        textArea.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                validateFocusGained();
            }
            public void focusLost(FocusEvent e) {
                validateFocusLost();
            }
        });
    }

    public void validateFocusGained(){
        if ((textArea.getText().equals("")) || (textArea.getText().equals(promptText))){
            textArea.setFont(inputFont);
            textArea.setText("");
        }
        else {
            textArea.setFont(inputFont);
        }
    }

    public void validateFocusLost(){
        if ((textArea.getText().equals("")) || (textArea.getText().equals(promptText))){
            textArea.setFont(promptFont);
            textArea.setText(promptText);
        }
        else {
            textArea.setFont(inputFont);
        }
    }

    public JTextArea getTextArea(){
        return textArea;
    }
}

