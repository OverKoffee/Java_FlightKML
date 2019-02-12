/*
Class created by Redmal on 2/11/2019.
This class will create a input text prompt for textfields.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextfieldPrompt {
    private JTextField textField;
    private Font promptFont;
    private Font inputFont;
    private String promptText;

    // passing 1 or 2 to constructor for
    // building the prompt text accordingly
    public TextfieldPrompt(int whichCoords){
        textField = new JTextField("");
        promptFont = new Font("promptFont", 2, 12); // italics and plain
        inputFont = new Font("inputFont",1,12); // bold and plain

        // set the prompt text string
        if (whichCoords == 1)
            promptText = "Enter first coords...";
        else if (whichCoords == 2)
            promptText = "Enter second coords...";

        textField.setText(promptText);
        textField.setFont(promptFont);

        // add event listener to toggle prompt and input
        // text in the textfield
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                validateFocusGained();
            }
            public void focusLost(FocusEvent e) {
                validateFocusLost();
            }
        });
    }

    public void validateFocusGained(){
        if ((textField.getText().equals("")) || (textField.getText().equals(promptText))){
            textField.setFont(inputFont);
            textField.setText("");
        }
        else {
            textField.setFont(inputFont);
        }
    }

    public void validateFocusLost(){
        if ((textField.getText().equals("")) || (textField.getText().equals(promptText))){
            textField.setFont(promptFont);
            textField.setText(promptText);
        }
        else {
            textField.setFont(inputFont);
        }
    }

    public JTextField getTextField(){
        return textField;
    }
}
