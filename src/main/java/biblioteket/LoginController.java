package biblioteket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnAbort;

    @FXML
    private Label lblLoginMessage;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtPassword;

    @FXML
    void pressAbort(ActionEvent event) {
         ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void pressLogin(ActionEvent event) {
        MainController mainControll = App.getMainControll();
        mainControll.setBtnLogoutDisable(true);
    }

}