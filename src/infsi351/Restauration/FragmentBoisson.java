package infsi351.Restauration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

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
		Group champagnes = new Group(getResources().getString(R.string.groupchampagnes));
		Boisson moncuitrose = new Boisson(getResources().getString(R.string.moncuitrose), 27);
		champagnes.children.add(moncuitrose);
		Boisson jlvergnon = new Boisson(getResources().getString(R.string.jlvergnon), 29);
		champagnes.children.add(jlvergnon);
		Boisson ruinartrose = new Boisson(getResources().getString(R.string.ruinartrose), 38);
		champagnes.children.add(ruinartrose);
		Boisson krug = new Boisson(getResources().getString(R.string.kruggrandecuvee), 155);
		champagnes.children.add(krug);
		
		groups.append(0, champagnes);


		//Le groupe des vins blancs
		Group vins = new Group(getResources().getString(R.string.groupvinsblancs));
		Boisson pouilly = new Boisson(getResources().getString(R.string.pouillyfume), 15);
		vins.children.add(pouilly);
		Boisson riesling = new Boisson(getResources().getString(R.string.rieslinggrandcru), 15);
		vins.children.add(riesling);
		Boisson saumur = new Boisson(getResources().getString(R.string.saumur), 20);
		vins.children.add(saumur);
		Boisson bellet = new Boisson(getResources().getString(R.string.bellet), 22);
		vins.children.add(bellet);

		groups.append(1, vins);

		//Le groupe des vins rouges
		Group vinsrouges = new Group(getResources().getString(R.string.groupvinsrouges));
		Boisson cahors = new Boisson(getResources().getString(R.string.cahors), 18);
		vinsrouges.children.add(cahors);
		Boisson chateuneuf = new Boisson(getResources().getString(R.string.chateauneufpape), 27);
		vinsrouges.children.add(chateuneuf);
		Boisson saumurchampigny = new Boisson(getResources().getString(R.string.saumurchampigny), 29);
		vinsrouges.children.add(saumurchampigny);
		Boisson stemilion = new Boisson(getResources().getString(R.string.saintemilion), 58);
		vinsrouges.children.add(stemilion);
			

		groups.append(2, vinsrouges);
		


		//Le groupe des cocktails et aperos
		Group cocktails = new Group(getResources().getString(R.string.groupcocktails));
		Boisson kirroyal = new Boisson(getResources().getString(R.string.kirroyal), 13);
		cocktails.children.add(kirroyal);
		Boisson porto = new Boisson(getResources().getString(R.string.porto), 5);
		cocktails.children.add(porto);
		Boisson tipunch = new Boisson(getResources().getString(R.string.tipunch), 6.5);
		cocktails.children.add(tipunch);
		Boisson sangria = new Boisson(getResources().getString(R.string.sangria), 5.5);
		cocktails.children.add(sangria);
		
		groups.append(3, cocktails);
		
		//Le groupe des bi�res
		Group bieres = new Group(getResources().getString(R.string.groupbieres));
		Boisson leffe = new Boisson(getResources().getString(R.string.leffe), 6.9);
		bieres.children.add(leffe);
		Boisson guinnessambree = new Boisson(getResources().getString(R.string.guinnessambree), 7);
		bieres.children.add(guinnessambree);
		Boisson delirium = new Boisson(getResources().getString(R.string.delirium), 5);
		bieres.children.add(delirium);
		Boisson carlsbergElephant = new Boisson(getResources().getString(R.string.carlsberg), 4);
		bieres.children.add(carlsbergElephant);
		
		groups.append(4, bieres);

		//Le groupe des softs
		Group softs = new Group(getResources().getString(R.string.groupsofts));
		Boisson coca = new Boisson(getResources().getString(R.string.cocacola), 4.5);
		softs.children.add(coca);
		Boisson icetea = new Boisson(getResources().getString(R.string.icedtea), 4);
		softs.children.add(icetea);
		Boisson jusorange = new Boisson(getResources().getString(R.string.orange), 6);
		softs.children.add(jusorange);
		Boisson jusananas = new Boisson(getResources().getString(R.string.ananas), 6);
		softs.children.add(jusananas);
		
		groups.append(5, softs);
				
				
	}




}