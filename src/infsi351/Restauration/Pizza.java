package infsi351.Restauration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {
	
	static final Map<String, List<String>> INGREDIENTS = new HashMap<String, List<String>>();
	static {
		List<String> type1 = Arrays.asList("ingredient1", "ingredient2", "ingredient3", "ingredient4");
		List<String> type3 = Arrays.asList("ingredient5", "ingredient6", "ingredient7");
		List<String> type2 = Arrays.asList("ingredient9", "ingredient10", "ingredient8");
		//List<String> type4 = Arrays.asList("ingredient13", "ingredient14", "ingredient15", "ingredient16");

		INGREDIENTS.put("type_ingredient1", type1);
		INGREDIENTS.put("type_ingredient2", type2);
		INGREDIENTS.put("type_ingredient3", type3);
		//INGREDIENTS.put("type_ingredient4", type4);
	}
	
	private List<String> ingredients = new ArrayList<String>();
	private String base;
	
	public Pizza() {
		base = "ok";
	}
	
	public void ajouterIngredient(String ingredient) {
		ingredients.add(ingredient);
	}
	
	public void removeIngredient(String ingredient) {
		if (ingredients.contains(ingredient)) 
			ingredients.remove(ingredient);
	}
	
	public void changerBase(String base) {
		this.base = base;
	}

	public String getBase() {
		return base;
	}
	
	public List<String> getIngredient() {
		return ingredients;
	}
	
	public boolean checkIngredient(String ingredient) {
		return ingredients.contains(ingredient);
	}

}
