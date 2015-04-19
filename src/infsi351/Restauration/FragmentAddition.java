package infsi351.Restauration;

import java.util.ArrayList;
import java.util.List;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentAddition extends Fragment {
	
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";
	
	public FragmentAddition(){
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final Resources res = getResources();
		String packageName = getActivity().getPackageName();

		MainActivity main = (MainActivity)getActivity();
		
		View view = inflater.inflate(R.layout.addition_fragment, container, false);
		
		String euro = getResources().getString(R.string.euro);
		View content_cart = view.findViewById(R.id.cart_content);
		View content_drinks = view.findViewById(R.id.drink_content);
		
		List<Boisson> drink_list = main.commande.get_liste_boissons();
		List<Pizza> pizza_list = main.commande.get_liste_pizzas();
		
		float total = 0.0f;
		
		if(drink_list.size() > 0){
			for(int i =0; i < drink_list.size(); i ++){
				View item_drink = inflater.inflate(R.layout.drink_item_no_button, (ViewGroup) content_drinks, false);
				((TextView)item_drink.findViewById(R.id.cart_text_item)).setText(drink_list.get(i).getNom());
				((TextView)item_drink.findViewById(R.id.cart_price_item)).setText(drink_list.get(i).getPrix() + " " + euro);
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
				View item_cart = inflater.inflate(R.layout.cart_item_no_button, (ViewGroup) content_cart, false);
				((TextView)item_cart.findViewById(R.id.cart_text_item)).setText("Pizza base " + pizza_list.get(i).getBase());
				
				
				List<String> ingredientsString = new ArrayList<String>();

				for(String ing: pizza_list.get(i).getIngredient())
					ingredientsString.add(res.getString(res.getIdentifier(ing, "string", packageName)));
				
				((TextView)item_cart.findViewById(R.id.item_description)).setText(ingredientsString.toString());
				((TextView)item_cart.findViewById(R.id.cart_price_item)).setText(pizza_list.get(i).getPrix() + " " + euro);
				((LinearLayout)content_cart).addView(item_cart);
				total += pizza_list.get(i).getPrix();
			}
		}
		else {
			View item_cart = inflater.inflate(R.layout.empty_cart, (ViewGroup) content_cart, false);
			((TextView)item_cart.findViewById(R.id.cart_empty_item)).setText("Pas de pizza ? :(");
			((LinearLayout)content_cart).addView(item_cart);
		}
		
		((TextView)view.findViewById(R.id.total_cart)).setText(total + " " + euro);
		
		return view;
		
		
	}
}
