package infsi351.Restauration;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentServeur extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	public FragmentServeur() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		
		View view = inflater.inflate(R.layout.serveur_fragment, container, false);
		
		final Button button_eau = (Button) view.findViewById(R.id.button_eau);
        button_eau.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	
            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setMessage("Voulez-vous une caraffe d'eau?").setTitle("Eau");
            	builder.setPositiveButton("Oui,svp!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                    }
                });
            	builder.setNegativeButton("No, merci!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
         // Set other dialog properties
         //...

         // Create the AlertDialog
         		AlertDialog dialog = builder.create();
         		dialog.show();
            }
        });
        
        final Button button_pain = (Button) view.findViewById(R.id.button_pain);
        button_pain.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	
            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setMessage("Voulez-vous du pain?").setTitle("Pain");
            	builder.setPositiveButton("Oui,svp!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                    }
                });
            	builder.setNegativeButton("No, merci!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
         // Set other dialog properties
         //...

         // Create the AlertDialog
         		AlertDialog dialog = builder.create();
         		dialog.show();
            }
        });
		
		
		
		return view ;	}
}