package main.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class SuccessLogin extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login_success.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600 , 450);
        stage.setTitle("Thông tin");
        stage.setScene(scene);
        stage.show();
    }
}