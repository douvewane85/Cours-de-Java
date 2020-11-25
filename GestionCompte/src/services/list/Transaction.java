/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.list;


import services.ITransaction;
import dao.list.CompteDao;
import dao.IDao;
import dao.list.PartenaireDao;
import java.util.List;
import java.util.stream.Collectors;
import models.Compte;
import models.Compte;
import models.Depot;
import models.Depot;
import models.Partenaire;
import models.Partenaire;
import models.User;

/**
 *
 * @author user
 */
public class Transaction implements ITransaction {
    
    PartenaireDao daoPartenaire;
    IDao<Compte>  daoCompte;
    public Transaction() {
        this.daoPartenaire=new PartenaireDao();
        this.daoCompte=new CompteDao();
    }
    
    
    @Override
    public Compte addCompteTransaction(Compte compte){
        //Partenaire n'existe pas
        if(compte.getPartenaire().getId()==0){
            this.addComptePartenaire(compte.getPartenaire());
        }
        
        this.setDepot(compte, compte.getSolde());
        daoCompte.add(compte);
        return compte;
    }
    @Override
    public Partenaire addComptePartenaire(Partenaire partenaire){
        return this.daoPartenaire.add(partenaire);
    }
    
    @Override
    public Compte setDepot(Compte compte,double mnt){
        Depot depot=new Depot(mnt) ;
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

    
    
}
