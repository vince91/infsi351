package infsi351.Restauration;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentComposition2 extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";
	private String base;

	public FragmentComposition2(String base) {
		this.base = base;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.composition_layout2, container, false);
//		TextView textView = (TextView) view.findViewById(R.id.textView1);
//		textView.setText(base);
		
		return view;
	}
	

}