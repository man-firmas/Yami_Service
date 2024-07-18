package co.ao.yami_service;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Tela_hello_view_Controller {

    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}