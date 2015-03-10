package DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
 
public class MaBaseSQLite extends SQLiteOpenHelper {
 
	private static final String TABLE_MUSIQUES = "table_musiques";
	private static final String COL_ID = "ID";
	private static final String COL_RAW = "RAW";
	private static final String COL_TITRE = "Titre";
 
	private static final String CREATE_BDD = "CREATE TABLE " + TABLE_MUSIQUES + " ("
	+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_RAW + " TEXT NOT NULL, "
	+ COL_TITRE + " TEXT NOT NULL);";
 
	public MaBaseSQLite(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		//on créé la table à partir de la requête écrite dans la variable CREATE_BDD
		db.execSQL(CREATE_BDD);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//On peut fait ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
		//comme ça lorsque je change la version les id repartent de 0
		db.execSQL("DROP TABLE " + TABLE_MUSIQUES + ";");
		onCreate(db);
	}
 
}