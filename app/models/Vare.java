package models;

/**
 * Created by annesofiestranderichsen on 03.03.15.
 */
public class Vare {
  @SuppressWarnings("unused")
	public Vare(int vareID){
		DatabaseVarer db= new DatabaseVarer();
		String navn= db.getVareNavn(vareID);
		String pris= db.getPrice(vareID);
		String kategori= db.getKategor(vareID);
		String xValue = db.getPlaceX(vareID);
		String yValue = db.getPlaceY(vareID);
		String zValue = db.getPlaceZ(vareID);
	}
}
