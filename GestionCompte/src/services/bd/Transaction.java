/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.bd;

import dao.IDao;
import dao.bd.CompteDao;
import dao.bd.DaoUser;
import dao.bd.DepotDao;
import dao.bd.PartenaireDao;
import java.util.List;
import java.util.stream.Collectors;
import models.Compte;
import models.Depot;
import models.Partenaire;
import models.User;
import services.ITransaction;

/**
 *
 * @author user
 */
public class Transaction implements ITransaction {

    
       PartenaireDao daoPartenaire;
       IDao<Compte>  daoCompte;
       DaoUser daoUser;
       DepotDao daoDepot ;
    public Transaction() {
        this.daoPartenaire=new PartenaireDao();
        this.daoCompte=new CompteDao();
        this.daoDepot=new DepotDao();
        this.daoUser=new DaoUser();
    }
    @Override
    public Compte addCompteTransaction(Compte compte) {
       //Partenaire n'existe pas
        if(compte.getPartenaire().getId()==0){
            this.addComptePartenaire(compte.getPartenaire());
        }
        //1-Creer le Compte
           daoCompte.add(compte);
        //2-Faire Compte
           this.setDepot(compte, compte.getSolde());
         
        return compte;
    }

    @Override
    public Partenaire addComptePartenaire(Partenaire partenaire) {
        return this.daoPartenaire.add(partenaire);
    }

    @Override
    public Compte setDepot(Compte compte, double mnt) {
        Depot depot=new Depot(mnt) ;
        //Ajoute Depot dans BD
         daoDepot.add(depot, compte.getId());
         //Mettre à Jour le Solde du compte
        ((CompteDao)daoCompte).update(compte);
        compte.getDepots().add(depot);
        return compte;
    }

    @Override
    public Partenaire getPartenaireByNci(String nci){
      List<Partenaire> partenaires= daoPartenaire.selectAll();
      
      for(Partenaire part :partenaires){
          if(part.getNci().compareTo(nci)==0){
              return part;
          }
      }
          return null;
    }
    @Override
    public List<Compte> getComptesByPartenaire(Partenaire part){
        List<Compte> comptes=daoCompte.selectAll();
       /* for(Compte cpt:comptes){
            if(cpt.getPartenaire().getId()!=part.getId()){
                comptes.remove(cpt);
            }
        }
      */
        return comptes.stream().filter((cpt)->cpt.getPartenaire().getId()==part.getId()).collect(Collectors.toList());
       
    }
    
    public User seConnecter(String login,String pwd){
        return daoUser.connexionUser(login, pwd);
    }
}
