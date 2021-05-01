package controller;

import javafx.scene.control.TextField;

public class Controller {

    String morse;
    public TextField input;

    public void handleTransButton(){
        morse = input.getText();
        System.out.println(morse);
    }

}
