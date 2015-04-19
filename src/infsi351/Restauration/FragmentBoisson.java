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


		//Le groupe des vins blancs
		Group vins = new Group("Nos Vins Blancs");
		Boisson pouilly = new Boisson("AOC Pouilly-Fumé");
		vins.children.add(pouilly);
		Boisson riesling = new Boisson("AOC Riesling Grand Cru");
		vins.children.add(riesling);
		Boisson saumur = new Boisson("AOC Saumur");
		vins.children.add(saumur);
		Boisson bellet = new Boisson("AOC Bellet");
		vins.children.add(bellet);

		groups.append(1, vins);

		//Le groupe des vins rouges
		Group vinsrouges = new Group("Nos Vins Rouges");
		Boisson stemilion = new Boisson("AOC Saint-Emilion Grand Cru");
		vinsrouges.children.add(stemilion);
		Boisson saumurchampigny = new Boisson("AOC Saumur Champigny");
		vinsrouges.children.add(saumurchampigny);
		Boisson chateuneuf = new Boisson("AOC Châteauneuf-du-Pape");
		vinsrouges.children.add(chateuneuf);
		Boisson cahors = new Boisson("AOC Cahors");
		vinsrouges.children.add(cahors);
		

		groups.append(2, vinsrouges);
		


		//Le groupe des cocktails et aperos
		Group cocktails = new Group("Nos Cocktails et Nos Apéritifs");
		Boisson kirroyal = new Boisson("Kir Royal");
		cocktails.children.add(kirroyal);
		Boisson porto = new Boisson("Porto");
		cocktails.children.add(porto);
		Boisson tipunch = new Boisson("Ti Punch");
		cocktails.children.add(tipunch);
		Boisson sangria = new Boisson("Sangria");
		cocktails.children.add(sangria);
		
		groups.append(3, cocktails);
		
		//Le groupe des bières
		Group bieres = new Group("Nos Bières");
		Boisson leffe = new Boisson("Leffe");
		bieres.children.add(leffe);
		Boisson guinnessambree = new Boisson("Guinness Ambrée");
		bieres.children.add(guinnessambree);
		Boisson carlsbergElephant = new Boisson("Carlsberg Elephant");
		bieres.children.add(carlsbergElephant);
		Boisson delirium = new Boisson("Delirium");
		bieres.children.add(delirium);
		
		groups.append(4, bieres);

		//Le groupe des softs
		Group softs = new Group("Nos Jus et Nos Sodas");
		Boisson coca = new Boisson("Coca-Cola");
		softs.children.add(coca);
		Boisson icetea = new Boisson("Iced Tea");
		softs.children.add(icetea);
		Boisson jusorange = new Boisson("Jus d'orange");
		softs.children.add(jusorange);
		Boisson jusananas = new Boisson("Jus d'ananas");
		softs.children.add(jusananas);
		
		groups.append(5, softs);
				
				
	}




}