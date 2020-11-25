/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import models.Compte;
import models.Partenaire;
import services.bd.Transaction;
import views.utils.FormValidator;
import views.utils.Utils;

/**
 *
 * @author user
 */
public class AddCompteController implements Initializable {
    
    
    @FXML
    private TextField txtNci;
    
    
    private Transaction service;
    @FXML
    private TextField txtNomPrenom;
    @FXML
    private TextField txtTel;
    
    @FXML
    private TextField txtLogin;
   
    @FXML
    private TextField txtSolde;
    Partenaire part=null;
    @FXML
    private TextArea txtAdresse;
    @FXML
    private TableView<Compte> tblvComptes;
    @FXML
    private TableColumn<Compte, String> tblcNumero;
    //Observateur
    @FXML
    private TableColumn<Compte, String> tblcSolde;
    
    //Sujet d'observation
    private ObservableList<Compte> oblComptes;
    @FXML
    private PasswordField txtPwd;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnSaveCompte;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service=new Transaction();
         FormValidator.disabledBtn(btnSearch, txtNci);
         FormValidator.disabledBtn(btnSaveCompte, txtNci, txtSolde);
         FormValidator.isDouble(txtSolde);
    
    }    

    @FXML
    private void handleSearchPartenaire(ActionEvent event) {
         
           String nci=txtNci.getText();
            part=service.getPartenaireByNci(nci);
             oblComptes =Utils.searchPartenaire(txtNci, txtNomPrenom, txtTel, txtAdresse, txtLogin, txtPwd, part, service, oblComptes, tblvComptes, tblcNumero, tblcSolde);
        System.out.println(part);
    }
    
    

    @FXML
    private void handleCreateCompte(ActionEvent event) {
        double solde=Double.parseDouble(txtSolde.getText());
      
        if(part==null){
            String nci=txtNci.getText();
            String nomComplet=txtNomPrenom.getText();
            String adresse=txtAdresse.getText();
            String tel=txtTel.getText();
            String login=txtLogin.getText();
            String pwd=txtPwd.getText();
            part=new Partenaire(nci, nomComplet, adresse, tel, login, pwd);
        }
        
        Compte compte=new Compte("xxx2",solde,part);
        service.addCompteTransaction(compte);
        //this.loadTableView();
        oblComptes.add(compte);
        
        
    }
   
   
   


   
    
}
