/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views.utils;

import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Compte;
import models.Partenaire;
import services.ITransaction;


/**
 *
 * @author user
 */
public class  Utils {
   
    public static ObservableList<Compte> searchPartenaire(TextField txtNci,
           TextField txtNomPrenom,
           TextField txtTel,
           TextArea txtAdresse,
           TextField txtLogin,
           PasswordField txtPwd,
           Partenaire part,
           ITransaction service,
            ObservableList oblComptes,
            TableView<Compte> tblvComptes,
             TableColumn<Compte,String> tblcNumero,
             TableColumn<Compte,String> tblcSolde
            ){
        
          if(oblComptes!=null)oblComptes.clear();
        if(part!=null){
            txtNomPrenom.setText(part.getNomComplet());
            txtAdresse.setText(part.getAdresse());
            txtTel.setText(part.getTel());
            txtLogin.setText(part.getLogin());
            txtPwd.setText(part.getPwd());
            activeOrDisableFields(true, txtNomPrenom, txtTel, txtAdresse, txtLogin, txtPwd);
            List<Compte> comptes=service.getComptesByPartenaire(part);
            oblComptes=FXCollections.observableArrayList(comptes);
            loadTableView(tblvComptes, tblcNumero, tblcSolde, oblComptes);
            
        }else{
            activeOrDisableFields(false, txtNomPrenom, txtTel, txtAdresse, txtLogin, txtPwd);
            clearFields(txtNomPrenom, txtTel, txtAdresse, txtLogin, txtPwd);
        }
        return oblComptes;
    }
    
    public static ObservableList<Compte> searchPartenaire(TextField txtNci,
           TextField txtNomPrenom,
           TextField txtTel,
           TextArea txtAdresse,
           Partenaire part,
           ITransaction service,
            ObservableList oblComptes,
            TableView<Compte> tblvComptes,
             TableColumn<Compte,String> tblcNumero,
             TableColumn<Compte,String> tblcSolde
            ){
        String nci=txtNci.getText();
          part=service.getPartenaireByNci(nci);
          if(oblComptes!=null)oblComptes.clear();
        if(part!=null){
            txtNomPrenom.setText(part.getNomComplet());
            txtAdresse.setText(part.getAdresse());
            txtTel.setText(part.getTel());
            
            activeOrDisableFields(true, txtNomPrenom, txtTel, txtAdresse);
            List<Compte> comptes=service.getComptesByPartenaire(part);
            oblComptes=FXCollections.observableArrayList(comptes);
            loadTableView(tblvComptes, tblcNumero, tblcSolde, oblComptes);
            
        }else{
            activeOrDisableFields(false, txtNomPrenom, txtTel, txtAdresse);
            clearFields(txtNomPrenom, txtTel, txtAdresse);
        }
        return oblComptes;
    }
    
    public static void activeOrDisableFields(boolean etat,TextField txtNomPrenom,
           TextField txtTel,
           TextArea txtAdresse,
           TextField txtLogin,
           PasswordField txtPwd){
            txtNomPrenom.setDisable(etat);
            txtAdresse.setDisable(etat);
            txtTel.setDisable(etat);
            txtLogin.setDisable(etat);
            txtPwd.setDisable(etat);
    }
    
      public static void activeOrDisableFields(boolean etat,TextField txtNomPrenom,
           TextField txtTel,
           TextArea txtAdresse){
            txtNomPrenom.setDisable(etat);
            txtAdresse.setDisable(etat);
            txtTel.setDisable(etat);
           
    }
    
    public static void clearFields(TextField txtNomPrenom,
           TextField txtTel,
           TextArea txtAdresse,
           TextField txtLogin,
           PasswordField txtPwd)
    {
            txtNomPrenom.clear();
            txtAdresse.clear();
            txtTel.clear();
            txtLogin.clear();
            txtPwd.clear();
    }
    public static void clearFields(TextField txtNomPrenom,
           TextField txtTel,
           TextArea txtAdresse)
    {
            txtNomPrenom.clear();
            txtAdresse.clear();
            txtTel.clear();
    }
     public static void loadTableView(TableView<Compte> tblvComptes,
             TableColumn<Compte,String> tblcNumero,
             TableColumn<Compte,String> tblcSolde,
             ObservableList oblComptes){
             tblcNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
             tblcSolde.setCellValueFactory(new PropertyValueFactory<>("solde"));
        //Souscrire
             tblvComptes.setItems(oblComptes);
    }
     
     
     public  void changeView(Control field, String view) throws IOException{
         //Cacher la fenetre Source
           field.getScene().getWindow().hide();
           //Afficher la fenetre de Cible
           Parent root = FXMLLoader.load(getClass().getResource("/views/"+view+".fxml"));
           Scene scene = new Scene(root);
           Stage stage=new Stage();
           stage.setTitle("Transfert Argent");
           stage.setScene(scene);
           stage.show();
     }
}
