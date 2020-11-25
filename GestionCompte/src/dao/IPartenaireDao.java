/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import models.Partenaire;

/**
 *
 * @author user
 */
public interface IPartenaireDao {
    public Partenaire add(Partenaire partenaire);
    public List<Partenaire> selectAll();
    
}
