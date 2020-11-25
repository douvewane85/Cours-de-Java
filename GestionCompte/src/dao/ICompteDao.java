/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Compte;
import models.Partenaire;

/**
 *
 * @author user
 */
public interface ICompteDao {
    public Compte add(Compte compte);
    public List<Compte> selectAll();
    
     
}
