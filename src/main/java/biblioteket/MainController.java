package biblioteket;

import biblioteket.Persons.Loantagare;
import biblioteket.Persons.Person;
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
    
    //Variables to track active user
    Person.PersonTyp personTyp = Person.PersonTyp.NONE; 
    Person activeLibrarian = null;
    Loantagare activeUser = null;
    
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

      public void setBtnLogoutVisibility(Boolean bool){
          btnLogout.setVisible(bool);
      }

    public Person.PersonTyp getPersonTyp() {
        return personTyp;
    }

    public void setPersonTyp(Person.PersonTyp personTyp) {
        this.personTyp = personTyp;
    }

    public Person getActiveLibrarian() {
        return activeLibrarian;
    }

    public void setActiveLibrarian(Person activeLibrarian) {
        this.activeLibrarian = activeLibrarian;
    }

    public Loantagare getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(Loantagare activeUser) {
        this.activeUser = activeUser;
    }
    
    

    
}
