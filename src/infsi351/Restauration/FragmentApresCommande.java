package infsi351.Restauration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentApresCommande extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public FragmentApresCommande() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		
		/*TextView textView = new TextView(getActivity());
		textView.setGravity(Gravity.CENTER);
		textView.setText("FragmentApresCommande");
		return textView;
		*/
		return inflater.inflate(R.layout.aprescommande_fragment, container, false);
	}
}