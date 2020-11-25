/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import models.User;
import services.bd.Transaction;
import views.utils.FormValidator;
import views.utils.Utils;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ConnexionController implements Initializable {

    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtPwd;
    @FXML
    private Button btnConnexion;
    @FXML
    private Text lblError;

     private Transaction service;
     private Utils utils;
     private User user;
     private static ConnexionController CConnexion;

    public static ConnexionController getCConnexion() {
        return CConnexion;
    }

    public User getUser() {
        return user;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FormValidator.disabledBtn(btnConnexion, txtLogin,txtPwd);
        service=new Transaction();
        utils=new Utils();
        CConnexion=this;
    }    

    @FXML
    private void handleConnexionUser(ActionEvent event) throws IOException {
      user=  service.seConnecter(txtLogin.getText(), txtPwd.getText());
      if(user==null){
          lblError.setVisible(true);
      }else{
          utils.changeView(txtPwd, "Dashboard");
      }
    }
    
}
