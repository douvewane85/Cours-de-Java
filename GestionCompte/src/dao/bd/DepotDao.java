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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Compte;
import models.Depot;

/**
 *
 * @author user
 */
public class DepotDao implements IDao<Depot> {

    private static final String  SQL_INSERT="INSERT INTO `depot` (`mnt`, `createAt`, `compte_id`) VALUES (?, ?, ?)";
    private final String SQL_SELECT_ALL="Select * from depot where compte_id=?";
    
    private DaoMysql daoMysql;

    public DepotDao() {
        daoMysql =new DaoMysql();
    }
    

    public Depot add(Depot depot, int id_Compte) {
        daoMysql.getConnection();
        daoMysql.initPS(SQL_INSERT);
        PreparedStatement ps=daoMysql.getPstm();
        try {
            ps.setDouble(1, depot.getMnt());
            ps.setString(2, depot.getCreateAt().toString());
             ps.setInt(3, id_Compte);
             daoMysql.executeMaj();
             ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
               int id=rs.getInt(1);
               depot.setId(id);  
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(DepotDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            daoMysql.closeConnection();
        }
        return depot;
    }

    @Override
    public List<Depot> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Depot add(Depot obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public List<Depot> selectAll(Compte compte) {
       daoMysql.getConnection();
       daoMysql.initPS(SQL_SELECT_ALL);
       PreparedStatement ps=daoMysql.getPstm();
       List<Depot> depots=new ArrayList<>();
        try {
            ps.setInt(1, compte.getId());
            ResultSet rs=daoMysql.executeSelect();
            while(rs.next()){
                Depot depot =new Depot();
                depot.setId(rs.getInt("id"));
                depot.setMnt(rs.getDouble("mnt"));
                depot.setCreateAt(LocalDate.parse(rs.getString("createAt")));
                depots.add(depot);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DepotDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            daoMysql.closeConnection();
        }
       return depots;
    }
    
}
