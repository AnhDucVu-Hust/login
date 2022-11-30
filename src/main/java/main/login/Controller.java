package main.login;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import main.login.MyConnection;
import javafx.scene.paint.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

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
    private Label lblErrors;

    @FXML
    protected void handleButtonAction(MouseEvent event) {
        if (event.getSource() == btnLogin) {
            logIN();
        }
    }

    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }

    private void logIN() {
        String email = txtUser.getText().toString();
        String password = txtPass.getText().toString();
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        conn = MyConnection.conDB();
        if (password.length() < 8) {
            iblError.setText("Error");
        } else {
            String sql = "SELECT * FROM userinfo WHERE username = ? and password = ?";
            String status = "Success";
            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    System.out.println("Login Fail!");
                    status = "Error";
                } else {
                    System.out.println("Login Success!");
                    SuccessLogin.launch();
                    
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
    }
}
