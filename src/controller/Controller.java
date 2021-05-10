package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public TextField input;
    public Label lblTwo;
    public Label lblmorseTranslation;
    private String spaceString = " ";
    private String slashString ="/";
    private char space = spaceString.charAt(0);
    private char slash = slashString.charAt(0);
    private String decodedMorse = "";
    private String encodedText ="";

    private static final char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private static final String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",
            ".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    @FXML
    private void handleTransCodeButton(){
        decodedMorse = "";
        String code = input.getText() + " ";
        dissection(code);
    }

    public void handleTransTextButton() {

    }

    private void dissection(String code) {
        String codeLetter = "";

        for( char c : code.toCharArray()){
            if( c != slash ){
                if (c != space){
                    codeLetter = codeLetter+c;
                }else{
                    translateLetter(codeLetter);
                    codeLetter ="";
                }
            }else {
                decodedMorse = decodedMorse +" ";
            }
        }
    }

    private void translateLetter(String codeLetter) {
        for (int i = 0; i < letters.length; i++) {
            if( codeLetter.equals(morseCode[i])){
                decodedMorse = decodedMorse + letters[i];
            }
        }
        showTranslation();

    }

    private void showTranslation() {
        lblmorseTranslation.setText(decodedMorse);
        lblTwo.setVisible(true);
    }
}