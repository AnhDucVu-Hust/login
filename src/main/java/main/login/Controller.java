package main.login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller{
    @FXML
    private TextField txtUser;
    @FXML
    private Label iblError;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    protected void handleButtonAction(MouseEvent event){
        if (event.getSource() == btnLogin){
            logIN();
        }
    }
    private void logIN(){
        String email=txtUser.getText().toString();
        String password=txtPass.getText().toString();
        if (password.length() < 8) {
            iblError.setText("Error");
        }
    }

}