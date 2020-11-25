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
import models.Partenaire;

/**
 *
 * @author user
 */
public class PartenaireDao implements IDao<Partenaire>{

    private final String SQL_SELECT_ALL="SELECT * FROM `user` WHERE type LIKE 'Partenaire'";
    private static final String  SQL_INSERT="INSERT INTO `user` (`login`, `pwd`, `type`, `nci`, `nomComplet`, `adresse`, `tel`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private DaoMysql daoMysql;

    public PartenaireDao() {
        daoMysql=new DaoMysql();
    }
    
    
    @Override
    public Partenaire add(Partenaire user) {
       daoMysql.getConnection();
       daoMysql.initPS(SQL_INSERT);
        PreparedStatement psmt=daoMysql.getPstm();
        try {
            psmt.setString(1, user.getLogin());
            psmt.setString(2, user.getPwd());
            psmt.setString(3, user.getType());
            psmt.setString(4 ,((Partenaire)user).getNci()); 
            psmt.setString(5 ,((Partenaire)user).getNomComplet());
            psmt.setString(6 ,((Partenaire)user).getAdresse());
            psmt.setString(7 ,((Partenaire)user).getTel());
            psmt.executeUpdate();
            ResultSet rs=psmt.getGeneratedKeys();
            if(rs.next()){
               int id=rs.getInt(1);
               user.setId(id);  
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(PartenaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            daoMysql.closeConnection();
        }
          return user;   
       
       
    }

    @Override
    public List<Partenaire> selectAll() {
        daoMysql.getConnection();
        daoMysql.initPS(SQL_SELECT_ALL);
        ResultSet rs=daoMysql.executeSelect();
        List<Partenaire> partenaires=new ArrayList<>();
        try {
            while(rs.next()){
              Partenaire part=new Partenaire(
                                rs.getString("nci"), 
                                rs.getString("nomComplet"), 
                                rs.getString("adresse"), 
                                rs.getString("tel"),
                                rs.getInt("id_user"),
                                rs.getString("login"), 
                                rs.getString("pwd"));
              partenaires.add(part);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PartenaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            daoMysql.closeConnection();
        }
        return partenaires;
    }
    
}
