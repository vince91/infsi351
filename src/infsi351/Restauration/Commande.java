package infsi351.Restauration;

import java.util.ArrayList;
import java.util.List;

public class Commande {

	private List<Boisson> liste_boissons;
	private List<Pizza> liste_pizzas;
	
	public Commande(){
		liste_boissons = new ArrayList<Boisson>();
		liste_pizzas = new ArrayList<Pizza>();
	}
	
	public int get_liste_boissons_size(){
		return liste_boissons.size();
	}
	
	public int get_liste_pizzas_size(){
		return liste_pizzas.size();
	}
	
	public List<Boisson> get_liste_boissons(){
		return liste_boissons;
	}
	
	public List<Pizza> get_liste_pizzas(){
		return liste_pizzas;
	}
	
	public void add_boisson(Boisson b){
		liste_boissons.add(b);
	}
	
	public void add_pizza(Pizza p){
		liste_pizzas.add(p);
	}
	
	public void set_pizza_of_the_list(int id, Pizza p){
		liste_pizzas.set(id, p);
	}
	
	public void set_boisson_of_the_list(int id, Boisson b){
		liste_boissons.set(id, b);
	}
	
	public void delete_pizza_of_the_list(int id){
		liste_pizzas.remove(id);
	}
	
	public void delete_boisson_of_the_list(int id){
		liste_boissons.remove(id);
	}
}
