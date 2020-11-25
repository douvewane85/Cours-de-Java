/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bd;

import dao.DaoMysql;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Compte;
import models.Depot;
import models.Partenaire;

/**
 *
 * @author user
 */
public class CompteDao implements IDao<Compte>{

    private final String SQL_INSERT="INSERT INTO `compte` (`numero`, `solde`, `partenaire_id`) VALUES (?, ?, ?)";
    private final String SQL_SELECT_ALL="select * from compte c, user u where c.partenaire_id=u.id_user";
    private final String SQL_UPDATE="UPDATE `compte` SET `solde` = ? WHERE `compte`.`id_compte` = ?";
    private DaoMysql daoMysql;
    private DepotDao daoDepot;
    public CompteDao() {
        daoMysql=new DaoMysql();
        daoDepot=new DepotDao();
    }
    
    @Override
    public Compte add(Compte compte) {
        daoMysql.getConnection();
        daoMysql.initPS(SQL_INSERT);
        PreparedStatement ps=daoMysql.getPstm();
        try {
            ps.setString(1, compte.getNumero());
            ps.setDouble(2, compte.getSolde());
            ps.setInt(3,compte.getPartenaire().getId());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
               int id=rs.getInt(1);
               compte.setId(id);  
           }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            daoMysql.closeConnection(); 
        }
        
        return compte;
    }

    @Override
    public List<Compte> selectAll() {
         daoMysql.getConnection();
         daoMysql.initPS(SQL_SELECT_ALL);
         PreparedStatement ps=daoMysql.getPstm();
         List<Compte> comptes=new ArrayList<>();
        try {
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Compte cpt=new Compte();
                cpt.setId(rs.getInt("id_compte"));
                cpt.setNumero(rs.getString("numero"));
                cpt.setSolde(rs.getDouble("solde"));
                Partenaire part=new Partenaire(
                                rs.getString("nci"), 
                                rs.getString("nomComplet"), 
                                rs.getString("adresse"), 
                                rs.getString("tel"),
                                rs.getInt("id_user"),
                                rs.getString("login"), 
                                rs.getString("pwd"));
                
                cpt.setPartenaire(part);
                List<Depot> depots=daoDepot.selectAll(cpt);
                cpt.setDepot(depots);
                comptes.add(cpt);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            daoMysql.closeConnection();
        }
         
         return comptes;
    }
   public Compte update(Compte compte) {
       daoMysql.getConnection();
        daoMysql.initPS(SQL_UPDATE);
        PreparedStatement ps=daoMysql.getPstm();
        try {
            ps.setDouble(1, compte.getSolde());
            ps.setInt(2, compte.getId());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompteDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            daoMysql.closeConnection(); 
        }
        return compte; 
   } 
}
