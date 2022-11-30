package main.login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
public class Controller {
    @FXML
    private TextField txtUser;
    @FXML
    private Label iblError;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    protected void handleButtonAction(MouseEvent event) throws IOException {
        if (event.getSource() == btnLogin){
            if (logIN()=="Success") {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                //stage.setMaximized(true);
                stage.close();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("home.fxml")));
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    private String logIN(){
        String status;
        String email=txtUser.getText().toString();
        String password=txtPass.getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            iblError.setText("Empty credentials");
            status="Error";
        }
        else if (password.length() < 8){
            status="Error";
            iblError.setText("Enter correct username/password");
        }
        else {
            iblError.setText("Login thành công...Xin đợi..");
            status="Success";
        }
        return status;
    }

}