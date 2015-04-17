package infsi351.Restauration;

import java.util.ArrayList;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	        Bundle savedInstanceState) {

	    View rootView = inflater.inflate(R.layout.liste_boisson, container, false);
	    
	    String[] tab = {"membre1","membre2","membre3","membre4","membre5","membre6","membre7","membre8","membre9"};
	    ListView lv = (ListView)rootView.findViewById(R.id.listview);
	    ArrayAdapter<String> arrayadp = new ArrayAdapter<String>(((MainActivity) getActivity()),  android.R.layout.simple_list_item_1, tab); 
	

	    lv.setAdapter(arrayadp);

	    return rootView;
	}

  
	
	
}