/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.bd;

import dao.DaoMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;

/**
 *
 * @author user
 */
public class DaoUser {
    
    private final String SQL_CONNEXION="select * from user where login like ? and pwd like ?";
    private DaoMysql daoMysql;

    public DaoUser() {
        daoMysql=new DaoMysql();
    }
    
    
    public User connexionUser(String login , String pwd){
        daoMysql.getConnection();
        daoMysql.initPS(SQL_CONNEXION);
        PreparedStatement ps=daoMysql.getPstm();
        User user=null;
        try {
            ps.setString(1, login);
            ps.setString(2, pwd);
         ResultSet rs=   daoMysql.executeSelect();
         if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id_user"));
            user.setLogin(rs.getString("login"));
            user.setType(rs.getString("type"));
         }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUser.class.getName()).log(Level.SEVERE, null, ex);
        
        }finally{
            daoMysql.closeConnection();
        }
        return user;
    }
    
}
