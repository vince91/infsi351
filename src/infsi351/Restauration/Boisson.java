package infsi351.Restauration;


/* Une boisson contient plusieurs attributs : Contenance, Prix, Nom, Quantit� en stock*/
public class Boisson {

	private String nom;
	private int qteStock;
	private double prix;
	private double contenance;

	public Boisson(String nom, double prix){
		this.nom = nom;
		qteStock=0;
		this.prix = prix;
		contenance = 0.0;	
	}


	public void setPrix(double _prix) {
		prix = _prix;
	}
	public void setContenance(double _contenance) {
		contenance = _contenance;
	}
	public void setNom(String _nom){
		nom = _nom;	
	}
	public void setQteStock(int _qte){
		qteStock = _qte;
	}

	public double getPrix(){
		return prix;
	}
	public double getContenance() {
		return contenance;
	}
	public String getNom(){
		return nom;	
	}
	public int getQteStock(int _qte){
		return qteStock;
	}

	public void decrementStock(int vendu){
		qteStock = qteStock-vendu;
	}

}
