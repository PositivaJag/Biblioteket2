package biblioteket;


import biblioteket.Database.DBConnection;
import biblioteket.Database.DBConnection.LoginResult;
import biblioteket.Persons.Loantagare;
import biblioteket.Persons.Person;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void pressLogin(ActionEvent event) {

        String mail = txtMail.getText();
        String pw = txtPassword.getText();
        
        System.out.println(mail+" "+pw);

        try {
            //check if user is blank
            if (mail.isEmpty()) {
                lblLoginMessage.setTextFill(Color.web("#FE0000"));
                lblLoginMessage.setText("Skriv in din mailadress");
            } //check if password is empty
            else if (pw.isEmpty()) {
                lblLoginMessage.setTextFill(Color.web("#FE0000"));
                lblLoginMessage.setText("Skriv in ditt lösenord");
                //check if mail and password is correct
            } else {

                LoginResult logginCheck = login(mail, pw);

                if (null == logginCheck) {
                    lblLoginMessage.setTextFill(Color.web("#FE0000"));
                    lblLoginMessage.setText("Något gick fel");
                } //Login successfull
                else {
                    switch (logginCheck) {
                        case NO_SUCH_USER:
                        case WRONG_PASSWORD:
                            lblLoginMessage.setTextFill(Color.web("#FE0000"));
                            lblLoginMessage.setText("Användarnamn eller lösenord är fel");
                            break;
                        case LOGIN_OK:                          
                            ((Node) (event.getSource())).getScene().getWindow().hide();
                            break;
                        default:
                            lblLoginMessage.setTextFill(Color.web("#FE0000"));
                            lblLoginMessage.setText("Något gick fel");
                            break;
                    }
                }
            }
        } catch (Exception e) {

        }
    }

  public LoginResult login(String mail, String password) throws Exception {

        try {
            //Connect to db
            DBConnection connection = DBConnection.getInstance();
 
            LoginResult pwCheck = connection.checkUserAndPassword(mail, password);
            
            //create loggin object if all is ok
            if (pwCheck == LoginResult.LOGIN_OK) {
                //Create librarian
//                Class<? extends Class> FWBControll = mainControll.class.getClass();
//                FWBControll.getMethod(setLogoutVisibility());
                if (connection.chechIfLibrarian(mail)) {
                    
                    
////                    for (int i = 0; i < 6; i++) {
////                        System.out.println(activeLibrarian.toString());
//   
//                    }
                   
                    
                } 
                //Create loantagare
                else {
                    String[] personDB = connection.getPersonData(mail);
                    

                    for (int i = 0; i < 6; i++) {
                       
                    }
                    
                }
            } 
            return pwCheck;
        }
        catch (SQLException e) {
            System.out.println("error: "+e);
        }
        throw new Exception("Unknown error");
    }


}
