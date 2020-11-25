/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Compte;
import models.Depot;
import models.Partenaire;
import services.bd.Transaction;
import views.utils.Utils;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DepotCompteController implements Initializable {

    @FXML
    private TextField txtNci;
    @FXML
    private TextField txtNomPrenom;
    @FXML
    private TextField txtTel;
    
    @FXML
    private TableView<Compte> tblvComptes;
    @FXML
    private TableColumn<Compte, String> tblcNumero;
    @FXML
    private TableColumn<Compte, String> tbcSolde;
    @FXML
    private TableView<Depot> tblvDepots;
    @FXML
    private TableColumn<Depot, String> tblcDate;
    @FXML
    private TableColumn<Depot, String> tblcMnt;
    @FXML
    private TextField txtMnt;
    @FXML
    private TextArea txtAdresse;
      
     private Transaction service;
     private ObservableList<Compte> oblComptes;
     Partenaire part;
     Compte cpt;
     private ObservableList<Depot> oblDepots;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        service=new Transaction();
    }    

    @FXML
    private void handleSearchPartenaire(ActionEvent event) {
          String nci=txtNci.getText();
           part=service.getPartenaireByNci(nci);
          oblComptes =Utils.searchPartenaire(txtNci, txtNomPrenom, txtTel, txtAdresse, part, service, oblComptes, tblvComptes, tblcNumero, tbcSolde);
    }

    @FXML
    private void handleSelectRowTableview(MouseEvent event) {
      cpt=tblvComptes.getSelectionModel().getSelectedItem();
      oblDepots=FXCollections.observableArrayList(cpt.getDepots());
      tblcDate.setCellValueFactory(new PropertyValueFactory<>("createAt"));
      tblcMnt.setCellValueFactory(new PropertyValueFactory<>("mnt"));
      tblvDepots.setItems(oblDepots);
    }

    @FXML
    private void handleAddDepot(ActionEvent event) {
        Double mnt=Double.parseDouble(txtMnt.getText());
          cpt.setDepot(mnt);
          service.setDepot(cpt, mnt);
          //Dernier Depot
          Depot depot=cpt.getDepots().get(cpt.getDepots().size()-1);
             //Mettre à jour la Table Depot
             oblDepots.add(depot);
             //Mettre à jour la Table Compte
             oblComptes =Utils.searchPartenaire(txtNci, txtNomPrenom, txtTel, txtAdresse, part, service, oblComptes, tblvComptes, tblcNumero, tbcSolde);
    }
    
}
