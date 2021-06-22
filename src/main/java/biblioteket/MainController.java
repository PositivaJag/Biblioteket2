package biblioteket;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainController implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnLogout;

    final MainController mainControll = this;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
    
    @FXML
    void pressHome(ActionEvent event) {

    }

    @FXML
    void pressLogin(ActionEvent event) {
        Login();

    }

    @FXML
    void pressLogout(ActionEvent event) {

    }
    
      private boolean Login() {

        try {
            Parent root
                    = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage stage = new Stage();
            Scene popup = new Scene(root);
            stage.setScene(popup);
            stage.show();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

      public void setBtnLogoutDisable(Boolean bool){
          btnLogout.setDisable(false);
      }
    
    

    
}
