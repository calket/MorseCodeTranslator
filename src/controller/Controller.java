package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.Locale;

public class Controller {
    public TextField inputMorseCode;
    public TextField inputText;
    public Label lblTwo;
    public Label lblmorseTranslation;
    public Button btnCopy;
    private String spaceString = " ";
    private String slashString ="/";
    private char space = spaceString.charAt(0);
    private char slash = slashString.charAt(0);
    private String decodedMorse = "";
    private String encodedText ="";
    private String translation ="";

    private static final char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static final String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
            ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    @FXML
    private void handleTransCodeButton(){
        decodedMorse = "";
        String code = inputMorseCode.getText() + " ";
        dissection(code);
    }

    public void handleTransTextButton() {
        encodedText = "";
        String text = inputText.getText().toLowerCase();
        translateText(text);
    }

    public void handleCopyButton() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(translation);
        clipboard.setContent(content);
    }

    private void dissection(String code) {
        String codeLetter = "";
        for( char c : code.toCharArray()){
            if( c != slash ){
                if (c != space){
                    codeLetter = codeLetter+c;
                }else{
                    translateMorse(codeLetter);
                    codeLetter ="";
                }
            }else {
                decodedMorse += " ";
            }
        }
    }
    private void translateText(String t) {
        String s = null;
        for (char c : t.toCharArray()){
            if (c != space){
                for (int i = 0; i < letters.length; i++) {
                    if(c == letters[i]){
                        encodedText += morseCode[i]+ " ";
                    }
                }
            }else{
                encodedText += " / ";
            }
        }
        translation = encodedText;
        showTranslation(encodedText);
    }

    private void translateMorse(String codeLetter) {
        for (int i = 0; i < letters.length; i++) {
            if( codeLetter.equals(morseCode[i])){
                decodedMorse += letters[i];
            }
        }
        translation = decodedMorse;
        showTranslation(decodedMorse);

    }

    private void showTranslation(String translation) {
        btnCopy.setVisible(true);
        lblmorseTranslation.setText(translation);
        lblTwo.setVisible(true);

    }
}