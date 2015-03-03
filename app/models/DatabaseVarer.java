package models;

/**
 * Created by annesofiestranderichsen on 03.03.15.
 */
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseVarer {
  
  DBConnection db;

	public void addUser(String epost, String passord){
		String sql= "INSERT INTO Users Values ("+epost+","+passord+");";
		db.updateQuery(sql);
	}

//	public ArrayList<String> getAlleVarerFromHandleliste(String epost){
//		String sql = "";
//	}

	public String getPassword(String epost){
		String password=null;
		String sql = "select passord from Varer where epost= "+epost+";";
		return(readQueryString(sql,password));
	}
	
	public String getVareNavn(int vareID){
		String vare=null;
		String sql = "select VARENAVN from Varer where vareID = "+vareID+";";
		return(readQueryString(sql,vare));
	}
	
	public String getKategor(int vareID){
		String kategori=null;
		String sql = "select KATEGORI from Varer where vareID = "+vareID+";";
		return(readQueryString(sql,kategori));
	}

	public String getPrice(int vareID){
		String price=null;
		String sql="select PRIS from VARER where vareID= "+vareID+";";
		return(readQueryString(sql,price));
	}
	
	public String getPlaceX(int vareID){
		String xVerdi=null;
		String sql="select xVerdi from VARER where vareID= "+vareID+";";
		return(readQueryString(sql,xVerdi));
	}
	
	public String getPlaceY(int vareID){
		String yVerdi=null;
		String sql="select yVerdi from VARER where vareID= "+vareID+";";
		return(readQueryString(sql,yVerdi));
	}
	
	public String getPlaceZ(int vareID){
		String zVerdi=null;
		String sql="select zVerdi from VARER where vareID= "+vareID+";";
		return(readQueryString(sql,zVerdi));
	}

	public ArrayList<String> getUser(String epost){
		ArrayList<String> users = new ArrayList<String>();
		String sql = "select EPOST from Users where epost = "+epost+";";
		return (readQueryArray(sql,users));
	}
	
	public ArrayList<String> getHandleliste(String epost){
		ArrayList<String> handleliste = new ArrayList<String>();
		String sql = "select HANDLELISTE from handlelister where handlelisteID = "+epost+";";
		return(readQueryArray(sql,handleliste));
	}
	
	public void addToHandleliste(int vareID, String epost){
		String sql = "INSERT INTO handleliste VALUES ('"+epost+","+vareID+"')";
		db.updateQuery(sql);
	}
	
	public void deleteFromHandleliste(int vareID, String epost){
		String sql = "DELETE from handleliste where vareID= '"+vareID+"' and EPOST ='"+epost+"';";
		db.updateQuery(sql);
	}
	
	public void deleteAllFromHandleliste(String epost){
		String sql = "DELETE from handleliste where EPOST ='"+epost+"';";
		db.updateQuery(sql);
		
	}
	public String readQueryString(String sql, String string){
		ResultSet rs = db.readQuery(sql);
		try {
			while (rs.next()) {
				string=rs.getString(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return string;
	}
	
	public ArrayList<String> readQueryArray(String sql, ArrayList<String> al){
		ResultSet rs = db.readQuery(sql);
		try {
			while (rs.next()) {
				al.add(rs.getString(1));	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return al;
	}

}
