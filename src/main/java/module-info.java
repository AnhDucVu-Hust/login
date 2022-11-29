module main.login {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.login to javafx.fxml;
    exports main.login;
}