package infsi351.Restauration;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.LinearLayout;
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
	private String base;

	public FragmentComposition2(String base) {
		this.base = base;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Resources res = getResources();
		String packageName = getActivity().getPackageName();
		
		View view = inflater.inflate(R.layout.composition_layout2, container, false);
		GridLayout gridLayout = (GridLayout) view.findViewById(R.id.gridLayout);
		float density = res.getDisplayMetrics().density;
		
		for (Map.Entry<String, List<String>> entry : Pizza.ingredients.entrySet())
		{
			View viewIngredient = inflater.inflate(R.layout.liste_ingredients, (ViewGroup) view, false);
			TextView titre = (TextView) viewIngredient.findViewById(R.id.titreIngredient);
			titre.setText(res.getString(res.getIdentifier(entry.getKey(), "string", packageName)));
			
			GridLayout ingredientGrid = (GridLayout) viewIngredient.findViewById(R.id.gridIngredient);
			
			for(String ingredient : entry.getValue()) {
				ToggleButton button = new ToggleButton(getActivity());
				
				String ingredientString = res.getString(res.getIdentifier(ingredient, "string", packageName));
				Log.d("app", ingredientString);
				button.setText(ingredientString);
				button.setTextOff(ingredientString);
				button.setTextOn(ingredientString);
				button.setWidth((int)(100 * density));
				ingredientGrid.addView(button);
				
				
			}
			
			gridLayout.addView(viewIngredient);
		    Log.d("app",entry.getKey() + "/" + entry.getValue());
		}

		return view;
	}
	

}