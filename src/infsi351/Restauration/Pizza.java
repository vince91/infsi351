package infsi351.Restauration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {
	
	static final Map<String, Integer> prixIngredients = new HashMap<String, Integer>();
	static final Map<String, List<String>> INGREDIENTS = new HashMap<String, List<String>>();
	static {
		List<String> type1 = Arrays.asList("ingredient1", "ingredient2", "ingredient3", "ingredient4");
		List<String> type3 = Arrays.asList("ingredient5", "ingredient6", "ingredient7");
		List<String> type2 = Arrays.asList("ingredient9", "ingredient10", "ingredient8");
		//List<String> type4 = Arrays.asList("ingredient13", "ingredient14", "ingredient15", "ingredient16");

		
		prixIngredients.put("ingredient1", 200);
		prixIngredients.put("ingredient2", 300);
		prixIngredients.put("ingredient3", 250);
		prixIngredients.put("ingredient4", 280);
		prixIngredients.put("ingredient5", 60);
		prixIngredients.put("ingredient6", 100);
		prixIngredients.put("ingredient7", 80);
		prixIngredients.put("ingredient8",85);
		prixIngredients.put("ingredient9", 100);
		prixIngredients.put("ingredient10", 100);
		prixIngredients.put("ingredient13", 150);
		prixIngredients.put("ingredient14", 70);
		prixIngredients.put("ingredient15", 75);
		prixIngredients.put("ingredient16", 80);

		INGREDIENTS.put("type_ingredient1", type1);
		INGREDIENTS.put("type_ingredient2", type2);
		INGREDIENTS.put("type_ingredient3", type3);
	}
	
	private List<String> ingredients = new ArrayList<String>();
	private String base;
	private Float prix;
	
	public Pizza() {
		base = "ok";
		prix = 0.0f;
	}
	
	public void ajouterIngredient(String ingredient) {
		ingredients.add(ingredient);
		prix += prixIngredients.get(ingredient);
	}
	
	public void removeIngredient(String ingredient) {
		if (ingredients.contains(ingredient))  {
			ingredients.remove(ingredient);
			prix -= prixIngredients.get(ingredient);
		}
	}
	
	public void changerBase(String base) {
		this.base = base;
	}
	
	public Float getPrix() {
		return (Float)prix/100.0f;
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
