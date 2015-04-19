package infsi351.Restauration;

import java.util.ArrayList;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentBoisson extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public FragmentBoisson() {
	}

	//	public void onCreateView(LayoutInflater inflater, ViewGroup container,
	//			Bundle savedInstanceState) {
	//		// Create a new TextView and set its text to the fragment's section
	//		// number argument value.
	//		
	//		//View view = inflater.inflate(R.layout.liste_boisson, container, false);
	//
	//		//return view;
	//		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
	//		        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
	//		        "Linux", "OS/2" };
	//		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
	//		        android.R.layout.simple_list_item_1, values);
	//		    setListAdapter(adapter);
	//	}

	SparseArray<Group> groups = new SparseArray<Group>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.liste_boisson, container, false);

		//	    String[] tab = {"membre1","membre2","membre3","membre4","membre5","membre6","membre7","membre8","membre9"};
		//	    ListView lv = (ListView)rootView.findViewById(R.id.listview);
		//	    ArrayAdapter<String> arrayadp = new ArrayAdapter<String>(((MainActivity) getActivity()),  android.R.layout.simple_list_item_1, tab); 
		//	
		//
		//	    lv.setAdapter(arrayadp);
		createData();
		ExpandableListView listView = (ExpandableListView) rootView.findViewById(R.id.listView);
		MyExpandableListAdapter adapter = new MyExpandableListAdapter(((MainActivity) getActivity()),
				groups);
		listView.setAdapter(adapter);



		return rootView;
	}

	public void createData() {
		
		//Le groupe des champagnes
		Group champagnes = new Group("Nos Champagnes");
		Boisson moncuitrose = new Boisson("Moncuit Rosé");
		champagnes.children.add(moncuitrose);
		Boisson jlvergnon = new Boisson("Jean Louis Vergnon");
		champagnes.children.add(jlvergnon);
		Boisson ruinartrose = new Boisson("Ruinart Rosé");
		champagnes.children.add(ruinartrose);
		Boisson krug = new Boisson("Krug Grande Cuvée Rosé");
		champagnes.children.add(krug);
		
		
		groups.append(0, champagnes);


		//Le groupe des vins
		Group vins = new Group("Nos Vins Blancs");
		Boisson pouilly = new Boisson("AOC Pouilly-Fumé");
		champagnes.children.add(pouilly);
		Boisson riesling = new Boisson("AOC Riesling Grand Cru");
		champagnes.children.add(riesling);
		Boisson saumur = new Boisson("AOC Saumur");
		champagnes.children.add(saumur);
		Boisson bellet = new Boisson("AOC Bellet");
		champagnes.children.add(bellet);
		
		groups.append(1, vins);
		


		//Le groupe des cocktails et aperos
		Group cocktails = new Group("Nos Cocktails et Nos Apéritifs");
		for (int i = 0; i < 5; i++) {
			Boisson cock = new Boisson("Cocktail " + i);
			//bieres.children.add("Sub Item" + i);
			cocktails.children.add(cock);
		}
		groups.append(2, cocktails);
		
		//Le groupe des bières
		Group bieres = new Group("Nos Bières");
		for (int i = 0; i < 5; i++) {
			Boisson biere = new Boisson("Bière " + i);
			//bieres.children.add("Sub Item" + i);
			bieres.children.add(biere);
		}
		groups.append(3, bieres);

		//Le groupe des softs
		Group softs = new Group("Nos Jus et Nos Sodas");
		for (int i = 0; i < 5; i++) {
			Boisson soft = new Boisson("Soft " + i);
			//bieres.children.add("Sub Item" + i);
			softs.children.add(soft);
		}
		groups.append(4, softs);
				
				
	}




}