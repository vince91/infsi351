package infsi351.Restauration;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.GridLayout;
import android.widget.ToggleButton;

import java.util.Map;
import java.util.List;

public class FragmentComposition2 extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";
	private MainActivity mainActivity;
	private Pizza pizza;

	public FragmentComposition2() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		mainActivity = (MainActivity) getActivity();
		pizza = mainActivity.getPizza();

		Resources res = getResources();
		String packageName = getActivity().getPackageName();
		
		View view = inflater.inflate(R.layout.composition_layout2, container, false);

		final Button button_retour = (Button) view.findViewById(R.id.buttonRevenirBase);
        button_retour.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 ((MainActivity) getActivity()).backToComposition1();
             }
         });
        
		final Button button_valider = (Button) view.findViewById(R.id.buttonConfirmerPizza);
        button_valider.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 Log.d("app", pizza.getBase() + "-" + pizza.getIngredient());
             }
         });

		GridLayout gridLayout = (GridLayout) view.findViewById(R.id.gridLayout);
		float density = res.getDisplayMetrics().density;
		
		for (Map.Entry<String, List<String>> entry : Pizza.INGREDIENTS.entrySet())
		{
			View viewIngredient = inflater.inflate(R.layout.liste_ingredients, (ViewGroup) view, false);
			TextView titre = (TextView) viewIngredient.findViewById(R.id.titreIngredient);
			titre.setText(res.getString(res.getIdentifier(entry.getKey(), "string", packageName)));
			
			GridLayout ingredientGrid = (GridLayout) viewIngredient.findViewById(R.id.gridIngredient);
			
			for(String ingredient : entry.getValue()) {
				ToggleButton button = new ToggleButton(getActivity());
				
				final String ingredientString = res.getString(res.getIdentifier(ingredient, "string", packageName));
				button.setText(ingredientString);
				button.setTextOff(ingredientString);
				button.setTextOn(ingredientString);
				button.setWidth((int)(100 * density));
				ingredientGrid.addView(button);
				
				if (pizza.checkIngredient(ingredientString))
					button.toggle();
				
				button.setOnCheckedChangeListener(new OnCheckedChangeListener() {
					@Override
					public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
						if (isChecked)
							pizza.ajouterIngredient(ingredientString);
						else
							pizza.removeIngredient(ingredientString);
					}
				});
				
			}
			
			gridLayout.addView(viewIngredient);
		}

		return view;
	}
	

}