package infsi351.Restauration;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
		View view = inflater.inflate(R.layout.panier, container, false);
		View content_cart = view.findViewById(R.id.cart_content);
		View content_drinks = view.findViewById(R.id.drink_content);
		for(int i =0; i < 2; i ++){
			View item_cart = inflater.inflate(R.layout.cart_item, (ViewGroup) content_cart, false);
			((TextView)item_cart.findViewById(R.id.cart_text_item)).setText("Pizza numero " + i);
			((TextView)item_cart.findViewById(R.id.cart_price_item)).setText((i+1)*10 + "�");
			((LinearLayout)content_cart).addView(item_cart);
			
			View item_drink = inflater.inflate(R.layout.drink_item, (ViewGroup) content_drinks, false);
			((TextView)item_drink.findViewById(R.id.cart_text_item)).setText("Boisson numero " + i);
			((TextView)item_drink.findViewById(R.id.cart_price_item)).setText((i+1)*10 + "�");
			((LinearLayout)content_drinks).addView(item_drink);
		}
		
		((TextView)view.findViewById(R.id.total_cart)).setText(60 + "�");
		
		return view;
	}
}