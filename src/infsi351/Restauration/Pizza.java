package infsi351.Restauration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {
	
	static final Map<String, List<String>> ingredients = new HashMap<String, List<String>>();
	static final Map<String, Float> prixIngredients = new HashMap<String, Float>();
	static {
		List<String> type1 = Arrays.asList("ingredient1", "ingredient2", "ingredient3", "ingredient4");
		List<String> type3 = Arrays.asList("ingredient5", "ingredient6", "ingredient7");
		List<String> type2 = Arrays.asList("ingredient9", "ingredient10", "ingredient8");
		List<String> type4 = Arrays.asList("ingredient13", "ingredient14", "ingredient15", "ingredient16");

		ingredients.put("type_ingredient1", type1);
		ingredients.put("type_ingredient2", type2);
		ingredients.put("type_ingredient3", type3);
		//ingredients.put("type_ingredient4", type4);
		
		prixIngredients.put("type_ingredient1", (float)2.0);
		prixIngredients.put("type_ingredient2", (float)3.0);
		prixIngredients.put("type_ingredient3", (float)2.5);
		prixIngredients.put("type_ingredient4", (float)2.8);
		prixIngredients.put("type_ingredient5", (float)0.6);
		prixIngredients.put("type_ingredient6", (float)1.0);
		prixIngredients.put("type_ingredient7", (float)0.8);
		prixIngredients.put("type_ingredient8", (float)0.85);
		prixIngredients.put("type_ingredient9", (float)1);
		prixIngredients.put("type_ingredient10", (float)1.0);
		prixIngredients.put("type_ingredient13", (float)1.5);
		prixIngredients.put("type_ingredient14", (float)0.7);
		prixIngredients.put("type_ingredient15", (float)0.75);
		prixIngredients.put("type_ingredient16", (float)0.8);

	}
}
