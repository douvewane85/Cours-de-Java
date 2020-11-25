/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

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
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import models.User;
import views.utils.Utils;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane anchorContent;
    @FXML
    private Button btnDeconnexion;

    private Utils utils;
    @FXML
    private Text lblNomComplet;
    @FXML
    private Text lblProfil;
    private User user;
    @FXML
    private Pane pnlTransaction;
    @FXML
    private Pane pnlSecurite;
    @FXML
    private Button btnFaireDepot;
    @FXML
    private Button btnMnuAddCompte;
    @FXML
    private Button btnMnuSetTransaction;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
           
            utils = new Utils();
            //Recuperation du User Connecté
            user=  ConnexionController.getCConnexion().getUser();
          lblNomComplet.setText("Nom et Prenom: "+user.getLogin() );
          lblProfil.setText("Profil : "+user.getType());
         
          getAutorisation();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void loadView(String viewName,AnchorPane anchorContent) throws IOException{
        AnchorPane viewLoader = FXMLLoader.load(getClass().getResource("../views/"+viewName+".fxml"));
            anchorContent.getChildren().clear();
            anchorContent.getChildren().add(viewLoader);
    }

    @FXML
    private void handleLoadViewAddCompte(ActionEvent event) {
        try {
            this.loadView("addCompte", anchorContent);
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleLoadViewSetDepot(ActionEvent event) throws IOException {
         this.loadView("depotCompte", anchorContent);
    }

    @FXML
    private void handleBtnDeconnexion(ActionEvent event) throws IOException {
         utils.changeView(btnDeconnexion, "connexion");
    }
    
    public void getAutorisation() throws IOException{
          pnlTransaction.setDisable(true);
          pnlSecurite.setDisable(true);
        if(user.getType().compareTo("Partenaire")==0){
            pnlTransaction.setDisable(false);
            //Vue chargée Par defaut pour le Partenaire
             this.loadView("addCompte", anchorContent);
        }else{
           if(user.getType().compareTo("Caissier")==0){
              pnlTransaction.setDisable(false);
              btnMnuAddCompte.setDisable(true);
              btnMnuSetTransaction.setDisable(true);
              //Vue chargée Par defaut pour le Caissier
               this.loadView("depotCompte", anchorContent);
           }else{
               if(user.getType().compareTo("AS")==0){
                    pnlTransaction.setDisable(false);
                    pnlSecurite.setDisable(false);
                  this.loadView("addCompte", anchorContent); 
               }
           } 
        }
    }
    
}
