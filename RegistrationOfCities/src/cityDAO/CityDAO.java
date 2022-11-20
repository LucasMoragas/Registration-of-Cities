package cityDAO;//DAO (Data Access Object)

import city.City;
import link.Link;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Moragas Melo Oliveira
 */
public class CityDAO {
    Connection connection;
    
    public CityDAO() throws SQLException, ClassNotFoundException{
        this.connection = Link.getConnection();
    }
    
    public void insertCity(City city){
        PreparedStatement ps;
        String query = "insert into city values(?,?,?,?,?,?,?,?)";
        
        try{
           ps = this.connection.prepareStatement(query);
           
           ps.setString(1, city.getId());
           ps.setString(2, city.getName());
           ps.setBoolean(3, city.isFireBrigade());
           ps.setBoolean(4, city.isPenitentiary());
           ps.setInt(5, city.getCollection());
           ps.setInt(6, city.getEconomicActivity());
           ps.setFloat(7, city.getFunds());
           ps.setString(8, city.getNotes());
           ps.execute();
           ps.close();
           
           City.setAmountOfCities(City.getAmountOfCities() + 1);
           
           //JOptionPane.showMessageDialog(null, "SUCCESSFULLY PERFORMED OPERATION");
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
    }
    
    public ArrayList<City> showElements(){
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<City> cityList = null;
        String query = "select * from city";
        
        try{
            ps = this.connection.prepareStatement(query);
            rs = ps.executeQuery();
            cityList = new ArrayList<>();
            
            while(rs.next()){
                City city = new City();
                
                city.setId(rs.getString("id"));
                city.setName(rs.getString("name"));
                city.setFireBrigade(rs.getBoolean("firebrigade"));
                city.setPenitentiary(rs.getBoolean("penitentiary"));
                city.setCollection(rs.getInt("collection"));
                city.setEconomicActivity(rs.getInt("economicactivity"));
                city.setFunds(rs.getFloat("funds"));
                city.setNotes(rs.getString("notes"));
                
                cityList.add(city);
            }
            
            ps.close();
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
        
        return cityList;
    }
    
    public void updateCity(City city){
        PreparedStatement ps;
        String query = "update city set name =?, firebrigade=?, penitentiary=?, collection=?, economicactivity=?, funds=?, notes=? where id=?";
        
        try{
           ps = this.connection.prepareStatement(query);
           
           ps.setString(1, city.getName());
           ps.setBoolean(2, city.isFireBrigade());
           ps.setBoolean(3, city.isPenitentiary());
           ps.setInt(4, city.getCollection());
           ps.setInt(5, city.getEconomicActivity());
           ps.setFloat(6, city.getFunds());
           ps.setString(7, city.getNotes());
           ps.setString(8, city.getId());
           ps.execute();
           ps.close();
           
           //JOptionPane.showMessageDialog(null, "SUCCESSFULLY PERFORMED OPERATION");
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
    
    public void removeCity(String id){
        PreparedStatement ps;
        String query = "delete from city where id=?";
        
        try{
            ps = this.connection.prepareStatement(query);
            
            ps.setString(1, id);
            ps.execute();
            ps.close();
            
            //JOptionPane.showMessageDialog(null, "SUCCESSFULLY PERFORMED OPERATION");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
}
