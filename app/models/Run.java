package models;

/**
 * Created by annesofiestranderichsen on 03.03.15.
 */
 
import java.io.InputStream;
import java.util.ArrayList;

public class Run {

  static DatabaseVarer db= new DatabaseVarer();
	public static void main (String [ ] args){
		InputStream e = System.in;
		String epost =e.toString();
		InputStream p = System.in;
		String passord=p.toString();

		if (validUser(epost,passord)){
			User user= new User(epost);
		}
		else{
			System.out.println("Feil brukernavn eller passord");
		}

		ArrayList<String> handleliste = db.getHandleliste(epost);
		System.out.println(handleliste); //send handlelisten til javascript & html
	}


	public static boolean validUser(String epost, String passord){
		String regex= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		if(!epost.matches(regex)){
			return false;

		}
		if(!passord.equals(db.getPassword(epost))){
			return false;
		}
		else{
			return true;
		}
	}

	public static ArrayList<String> sortHandleliste(ArrayList<String> handleliste){
		// lager hovednoder langs stien i kartet, 
		//sorter utifra plasseringen til varen 
		//lag en korteste vei algoritme for å finne ut hvilken vare som er nærmest
		return handleliste;
	}

  
}
