package infsi351.Restauration;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentComposition1 extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public FragmentComposition1() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.composition_layout1, container, false);

		 final Button button_tomate = (Button) view.findViewById(R.id.button_tomate);
         button_tomate.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 ((MainActivity) getActivity()).switchToComposition2("tomate");
             }
         });
         
         final Button button_creme = (Button) view.findViewById(R.id.button_creme);
         button_creme.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
            	 ((MainActivity) getActivity()).switchToComposition2("creme");
             }
         });         
		
		return view;
	}
	

}