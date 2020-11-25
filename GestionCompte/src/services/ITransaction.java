/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Compte;
import models.Compte;
import models.Partenaire;
import models.Partenaire;

/**
 *
 * @author user
 */
public interface ITransaction {
   Compte addCompteTransaction(Compte compte) ;
   Partenaire addComptePartenaire(Partenaire partenaire);
   Compte setDepot(Compte compte,double mnt);
   Partenaire getPartenaireByNci(String nci);
   List<Compte> getComptesByPartenaire(Partenaire part);
}
