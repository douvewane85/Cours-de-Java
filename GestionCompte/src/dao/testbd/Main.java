/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.testbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Caissier;
import models.Partenaire;
import models.User;

/**
 *
 * @author user
 */
public class Main {

       private static final String SELECT_ALL="select * from user";
       private  static final String SELECT_BY_ONE="select * from user where id=?";
       private static final String  SQL_INSERT="INSERT INTO `user` (`login`, `pwd`, `type`, `nci`, `nomComplet`, `adresse`, `tel`, `matricule`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
       private  static final String  SQL_UPDATE="UPDATE `user` SET `matricule` = ?,login`= ?, `pwd`= ?, `type`= ?, `nci`= ?, `nomComplet`= ?, `adresse`= ?, `tel`= ? WHERE `user`.`id` = ?";
    
        private static Connection cnx;
       /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //1- Ajouter et Charger le Driver Driver
            Class.forName("com.mysql.jdbc.Driver");
            //2- Connexion à la BD
           cnx= DriverManager.getConnection("jdbc:mysql://localhost:3306/ta_java2020_ism","root","");
            User user=findOneBy(2);
            user.setId(0);
            user.setPwd("passer");
            persist(user);
            findAll().forEach(System.out::println);
            
            System.out.println("User Id: 2 "+ findOneBy(2));
            //NB : Entre 2 requetes les parties
            //3 et 4 qui peuvent changer
        } catch (ClassNotFoundException ex) {
            System.err.println("Erreur de chargement du Driver");
        }  catch (SQLException ex) { 
               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
           } 
    }
  
    public static List<User> findAll() throws SQLException{
       //3-Ecrire les requetes et Executer les Requetes
               //3.a Requetes Select
                PreparedStatement psmt=cnx.prepareStatement(SELECT_ALL);
                ResultSet rs=psmt.executeQuery();
                List<User> users=new ArrayList<>();
              //4-Recureper le Resultat
                 while(rs.next()){
                     //System.out.println("ok");
                     //System.out.println("ID"+rs.getInt(1)+"login "+ rs.getString(2));
                     //System.out.println("ID "+rs.getInt("id")+" login  "+ rs.getString("login"));
                     User user;
                     if(rs.getString("type").compareTo("Caissier")==0){
                        user=new Caissier();
                        user.setId(rs.getInt("id"));
                        user.setLogin(rs.getString("login"));
                        ((Caissier)user).setMatricule(rs.getString("matricule"));
                     }else{
                        user=new Partenaire(rs.getString("nci"), 
                                rs.getString("nomComplet"), 
                                rs.getString("adresse"), 
                                rs.getString("tel"), 
                                rs.getString("login"), 
                                rs.getString("pwd"));  
                     }
                      users.add(user);
                 
                 }
                 rs.close();
                 return users;
    }
    
     public static User findOneBy(int id) throws SQLException{
       //3-Ecrire les requetes et Executer les Requetes
               //3.a Requetes Select
                PreparedStatement psmt=cnx.prepareStatement(SELECT_BY_ONE);
                psmt.setInt(1, id);
                ResultSet rs=psmt.executeQuery();
                User user=null;
              //4-Recureper le Resultat
                 while(rs.next()){
                    
                     if(rs.getString("type").compareTo("Caissier")==0){
                        user=new Caissier();
                        user.setId(rs.getInt("id"));
                        user.setLogin(rs.getString("login"));
                        ((Caissier)user).setMatricule(rs.getString("matricule"));
                     }else{
                        user=new Partenaire(rs.getString("nci"), 
                                rs.getString("nomComplet"), 
                                rs.getString("adresse"), 
                                rs.getString("tel"), 
                                rs.getString("login"), 
                                rs.getString("pwd"));  
                     }
                      
                 
                 }
                 rs.close();
                 return user;
    }
     
     public static void persist(User user) throws SQLException{
         PreparedStatement psmt=cnx.prepareStatement(SQL_INSERT,Statement.RETURN_GENERATED_KEYS);
             //`login`, `pwd`, `type`, `nci`, `nomComplet`, `adresse`, `tel`, `matricule`  
             psmt.setString(1, user.getLogin());
             psmt.setString(2, user.getPwd());
             psmt.setString(3, user.getType());
             
              if(user.getType().compareTo("Caissier")==0){
             
          
                  psmt.setString(4 ,null); 
                  
                  psmt.setString(5 ,null);
                  psmt.setString(6 ,null);
                  psmt.setString(7 ,null);
                  psmt.setString(8 ,((Caissier)user).getMatricule());
                   System.out.println(user);
              }else{
                  psmt.setString(4 ,((Partenaire)user).getNci()); 
                  psmt.setString(5 ,((Partenaire)user).getNomComplet());
                  psmt.setString(6 ,((Partenaire)user).getAdresse());
                  psmt.setString(7 ,((Partenaire)user).getTel());
                   psmt.setString(8 ,null);
              }
           int nbreUserInsert=   psmt.executeUpdate();
           ResultSet rs=psmt.getGeneratedKeys();
           if(rs.next()){
               int id=rs.getInt(1);
               System.out.println("Id Généré "+id); 
           }
          
             
     }
}
