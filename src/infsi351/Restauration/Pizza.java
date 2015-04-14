package infsi351.Restauration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pizza {
	
	static final Map<String, List<String>> ingredients = new HashMap<String, List<String>>();
	static {
		List<String> type1 = Arrays.asList("ingredient1", "ingredient2", "ingredient3", "ingredient4");
		List<String> type3 = Arrays.asList("ingredient5", "ingredient6", "ingredient7");
		List<String> type2 = Arrays.asList("ingredient9", "ingredient10", "ingredient8");
		List<String> type4 = Arrays.asList("ingredient13", "ingredient14", "ingredient15", "ingredient16");

		ingredients.put("type_ingredient1", type1);
		ingredients.put("type_ingredient2", type2);
		ingredients.put("type_ingredient3", type3);
		//ingredients.put("type_ingredient4", type4);
	}
}
