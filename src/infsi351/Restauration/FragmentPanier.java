package infsi351.Restauration;


import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentPanier extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public FragmentPanier() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		
		
		MainActivity main = (MainActivity)getActivity();
		
		View view = inflater.inflate(R.layout.panier, container, false);
		
		
		View content_cart = view.findViewById(R.id.cart_content);
		View content_drinks = view.findViewById(R.id.drink_content);
		
		List<Boisson> drink_list = main.commande.get_liste_boissons();
		List<Pizza> pizza_list = main.commande.get_liste_pizzas();
		
		float total = 0.0f;
		
		if(drink_list.size() > 0){
			for(int i =0; i < drink_list.size(); i ++){
				View item_drink = inflater.inflate(R.layout.drink_item, (ViewGroup) content_drinks, false);
				((TextView)item_drink.findViewById(R.id.cart_text_item)).setText(drink_list.get(i).getNom());
				((TextView)item_drink.findViewById(R.id.cart_price_item)).setText(drink_list.get(i).getPrix() + "€");
				
				Button btn_delete = (Button) item_drink.findViewById(R.id.button_delete_item);
				btn_delete.setId(i);
				btn_delete.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						MainActivity main = (MainActivity)getActivity();
						main.commande.delete_boisson_of_the_list(v.getId());
						main.refresh_da_panier();
					}

				});
				
				((LinearLayout)content_drinks).addView(item_drink);
				total += drink_list.get(i).getPrix();
			}
		}
		else {
			View item_drink = inflater.inflate(R.layout.empty_cart, (ViewGroup) content_drinks, false);
			((TextView)item_drink.findViewById(R.id.cart_empty_item)).setText("Pas de boisson ? :(");
			((LinearLayout)content_drinks).addView(item_drink);
		}
		if(pizza_list.size() > 0){
			for(int i =0; i < pizza_list.size(); i++){
				View item_cart = inflater.inflate(R.layout.cart_item, (ViewGroup) content_cart, false);
				((TextView)item_cart.findViewById(R.id.cart_text_item)).setText("Pizza base " + pizza_list.get(i).getBase());
				((TextView)item_cart.findViewById(R.id.item_description)).setText(pizza_list.get(i).getIngredient().toString());
				((TextView)item_cart.findViewById(R.id.cart_price_item)).setText(pizza_list.get(i).getPrix() + " €");
				
				Button btn_delete = (Button) item_cart.findViewById(R.id.button_delete_item);
				btn_delete.setId(i);
				btn_delete.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						MainActivity main = (MainActivity)getActivity();
						main.commande.delete_pizza_of_the_list(v.getId());
						main.refresh_da_panier();
					}
				});
				
				((LinearLayout)content_cart).addView(item_cart);
				total += pizza_list.get(i).getPrix();
			}
		}
		else {
			View item_cart = inflater.inflate(R.layout.empty_cart, (ViewGroup) content_cart, false);
			((TextView)item_cart.findViewById(R.id.cart_empty_item)).setText("Pas de pizza ? :(");
			((LinearLayout)content_cart).addView(item_cart);
		}
		
		((TextView)view.findViewById(R.id.total_cart)).setText(total + " €");
		
		return view;
		
		
	}
	
}