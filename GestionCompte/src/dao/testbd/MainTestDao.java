/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.testbd;

import dao.IDao;
import dao.bd.CompteDao;
import models.Compte;
import models.Partenaire;

/**
 *
 * @author user
 */
public class MainTestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IDao<Compte> daoCompte=new CompteDao();
        Partenaire part=new Partenaire();
        part.setId(1);
        Compte cpt=new Compte("cpt1", 500000, part);
        daoCompte.add(cpt);
        daoCompte.selectAll().forEach(System.out::println);
    }
    
}
