package DAO;

public class Question {

	private int id;
	private String raw;
	private String titre;
	private String a;
	private String b;
	private String c;
	private String d;
	private String reponse;
	
	public Question(){}
 
	public Question(String raw, String titre, String a,String b,String c,String d,String r){
		this.raw = raw;
		this.titre = titre;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.reponse = r;
	}
 
	public int getId() {
		return id;
	}
 
	public void setId(int id) {
		this.id = id;
	}
 
	public String getraw() {
		return raw;
	}
 
	public void setraw(String raw) {
		this.raw = raw;
	}
 
	public String getA() {
		return a;
	}
 
	public void setA(String a) {
		this.a = a;
	}
	
	public String getB() {
		return b;
	}
 
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
 
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
 
	public void setD(String d) {
		this.d = d;
	}
	public String getReponse() {
		return reponse;
	}
 
	public void setReponse(String r) {
		this.reponse = r;
	}
	public String getTitre() {
		return titre;
	}
 
	public void setTitre(String titre) {
		this.titre = titre;
	}

 
	public String toString(){
		return "ID : "+id+"\nRAW : "+raw+"\nTitre : "+titre;
	}
	
}
