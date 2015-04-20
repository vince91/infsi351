package infsi351.Restauration;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

public class FragmentServeur extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";
	public static final int MAX_PAIN = 4;
	public static final int MAX_CARAFFE_EAU = 4;
	
	private int numPain;
	private int numEau;
	private boolean serveurAppelle;

	public FragmentServeur() {
		numPain=0;
		numEau=0;
		serveurAppelle=false;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		
		View view = inflater.inflate(R.layout.serveur_fragment, container, false);
		final View view_toilettes = inflater.inflate(R.layout.toilettes_fragment, container, false);
		
		//BUTTON eau
		final Button button_eau = (Button) view.findViewById(R.id.button_eau);
        button_eau.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	
            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setMessage(getResources().getString(R.string.want_some_water));
            	builder.setPositiveButton(getResources().getString(R.string.yes_i_do), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    	AlertDialog.Builder builder_confirm = new AlertDialog.Builder(getActivity());
                    	if(numEau < MAX_CARAFFE_EAU){
                    		numEau++;
                    		builder_confirm.setMessage(getResources().getString(R.string.water_is_coming));
                        	
                    	}else{
                    		builder_confirm.setMessage(getResources().getString(R.string.too_much_water));
                    	}
                    	AlertDialog dialog_confirm = builder_confirm.create();
                    	dialog_confirm.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    	dialog.dismiss();
                 		dialog_confirm.show();
                    }
                });
            	builder.setNegativeButton(getResources().getString(R.string.no_i_dont), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
         // Create the AlertDialog
         		AlertDialog dialog = builder.create();
         		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         		dialog.show();
            }
        });
        
      //BUTTON pain
        final Button button_pain = (Button) view.findViewById(R.id.button_pain);
        button_pain.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	
            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setMessage(getResources().getString(R.string.want_some_bread));
            	builder.setPositiveButton(getResources().getString(R.string.yes_i_do), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    	
                    	AlertDialog.Builder builder_confirm = new AlertDialog.Builder(getActivity());
                    	if(numPain < MAX_PAIN){
                    		numPain++;
                    		builder_confirm.setMessage(getResources().getString(R.string.bread_is_coming));
                    	}else{
                    		builder_confirm.setMessage(getResources().getString(R.string.too_muc_bread));
                    	}
                    	AlertDialog dialog_confirm = builder_confirm.create();
                    	dialog_confirm.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    	dialog.dismiss();
                 		dialog_confirm.show();
                    }
                });
            	builder.setNegativeButton(getResources().getString(R.string.no_i_dont), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
         // Create the AlertDialog
         		AlertDialog dialog = builder.create();
         		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         		dialog.show();
            }
        });
		
      //BUTTON appel serveur
        final Button button_serveur = (Button) view.findViewById(R.id.button_serveur);
        button_serveur.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	if(serveurAppelle==false){
            		serveurAppelle=true;
            		builder.setMessage(getResources().getString(R.string.garcon_is_coming));
            	}else{
            		builder.setMessage(getResources().getString(R.string.garcon_is_still_coming));
                }
     
         		AlertDialog dialog = builder.create();
         		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         		dialog.show();
            }
        });
        
      //BUTTON toilettes
        final Button button_toilette = (Button) view.findViewById(R.id.button_toilettes);
        button_toilette.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setMessage(getResources().getString(R.string.map_to_toilets));
            	builder.setView(view_toilettes);
         // Create the AlertDialog
         		AlertDialog dialog = builder.create();
         		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
         		dialog.show();
            }
        });
        
		
		return view ;	
	}
}