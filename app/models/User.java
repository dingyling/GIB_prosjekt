package models;

/**
 * Created by annesofiestranderichsen on 03.03.15.
 */
 
import java.util.ArrayList;
 
public class User {
  DatabaseVarer db=new DatabaseVarer();
	@SuppressWarnings("unused")
	public User(String epost){
		String passord=db.getPassword(epost);
		ArrayList<String> handleliste = db.getHandleliste(epost);
		
	}
}
