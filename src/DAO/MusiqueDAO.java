package DAO;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MusiqueDAO {
	
	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "musiques.db";
 
	private static final String TABLE_MUSIQUES = "table_musiques";
	private static final String COL_ID = "ID";
	private static final int NUM_COL_ID = 0;
	private static final String COL_RAW = "RAW";
	private static final int NUM_COL_RAW = 1;
	private static final String COL_TITRE = "Titre";
	private static final int NUM_COL_TITRE = 2;
 
	private SQLiteDatabase bdd;
 
	private MaBaseSQLite maBaseSQLite;
 
	public MusiqueDAO(Context context){
		//On créer la BDD et sa table
		maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
	}
 
	public void open(){
		//on ouvre la BDD en écriture
		bdd = maBaseSQLite.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'accès à la BDD
		bdd.close();
	}
 
	public SQLiteDatabase getBDD(){
		return bdd;
	}
 
	public long insertLivre(Musique m){
		//Création d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		values.put(COL_RAW, m.getraw());
		values.put(COL_TITRE, m.getTitre());
		//on insère l'objet dans la BDD via le ContentValues
		return bdd.insert(TABLE_MUSIQUES, null, values);
	}
 
	public int updateMusique(int id, Musique m){
		//La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simple préciser quelle livre on doit mettre à jour grâce à l'ID
		ContentValues values = new ContentValues();
		values.put(COL_RAW, m.getraw());
		values.put(COL_TITRE, m.getTitre());
		return bdd.update(TABLE_MUSIQUES, values, COL_ID + " = " +id, null);
	}
 
	public int removeLivreWithID(int id){
		//Suppression d'un livre de la BDD grâce à l'ID
		return bdd.delete(TABLE_MUSIQUES, COL_ID + " = " +id, null);
	}
 
	public Musique getLivreWithTitre(String titre){
		//Récupère dans un Cursor les valeur correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
		Cursor c = bdd.query(TABLE_MUSIQUES, new String[] {COL_ID, COL_RAW, COL_TITRE}, COL_TITRE + " LIKE \"" + titre +"\"", null, null, null, null);
		return cursorToMusique(c);
	}
 
	//Cette méthode permet de convertir un cursor en un livre
	private Musique cursorToMusique(Cursor c){
		//si aucun élément n'a été retourné dans la requête, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier élément
		c.moveToFirst();
		//On créé un livre
		Musique m = new Musique();
		//on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
		m.setId(c.getInt(NUM_COL_ID));
		m.setId(c.getString(NUM_COL_RAW));
		m.setTitre(c.getString(NUM_COL_TITRE));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return m;
	}
}
