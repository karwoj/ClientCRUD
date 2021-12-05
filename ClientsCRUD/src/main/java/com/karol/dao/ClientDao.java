package com.karol.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.karol.beans.Client;  
  
public class ClientDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Client c){  
    String sql = "insert into clients(NAME, SURNAME, EMAIL, ADDRESS, TELEPHONE, INFORMATION) values"
    		+ "('"+c.getName()+"',"
    		+ "'"+c.getSurname()+"',"
    		+ "'"+c.getEmail()+"',"
    		+ "'"+c.getAddress()+"',"
    		+ ""+c.getTelephone()+",'"
    		+ c.getInformation()+"')"; 
	return template.update(sql);
}  


public int update(Client c){  
    String sql="update clients "
		+ "set NAME = '"+c.getName()+"', " 
		+ "SURNAME = '"+c.getSurname()+"', "
		+ "EMAIL = '"+c.getEmail()+"', "
		+ "ADDRESS = '"+c.getAddress()+"', " 
		+ "TELEPHONE = "+c.getTelephone()+", " 
		+ "INFORMATION = '"+c.getInformation()
		+"' where ID="+c.getId()+"";   
    return template.update(sql);  
}  

public int delete(int id){  
    String sql="delete from clients where ID="+id+"";  
    return template.update(sql); 
}  
public Client getClientById(int id){  
    String sql = "SELECT * FROM CLIENTS WHERE ID = ?";
    return template.queryForObject(
    		sql, 
    		new Object[]{id},
    		new BeanPropertyRowMapper<Client>(Client.class));  

}  

public List<Client> getClients(){  
    return template.query("select * from clients",new RowMapper<Client>(){   
        public Client mapRow(ResultSet rs, int row) throws SQLException {  
            Client c=new Client();  
            c.setId(rs.getInt(1));  
            c.setName(rs.getString(2));
            c.setSurname(rs.getString(3));
            c.setEmail(rs.getString(4));
            c.setAddress(rs.getString(5));
            c.setTelephone(rs.getInt(6));
            c.setInformation(rs.getString(7));
            return c;  
        }
        
    });  
}


} 

