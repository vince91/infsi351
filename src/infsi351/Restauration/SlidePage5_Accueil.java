package infsi351.Restauration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SlidePage5_Accueil extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public SlidePage5_Accueil() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.accueil_layout_slide5, container, false);


		         
		
		return view;
	}
	

}
