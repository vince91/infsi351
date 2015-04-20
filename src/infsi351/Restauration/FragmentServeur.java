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
            	builder.setMessage("Voulez-vous une caraffe d'eau?").setTitle("Eau");
            	builder.setPositiveButton("Oui, svp!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    	AlertDialog.Builder builder_confirm = new AlertDialog.Builder(getActivity());
                    	if(numEau < MAX_CARAFFE_EAU){
                    		numEau++;
                    		builder_confirm.setMessage("Une caraffe d'eau arrivera bientot").setTitle("Eau command�");
                        	
                    	}else{
                    		builder_confirm.setMessage("Vous avez command� trop d'eau!").setTitle("Trop d'eau");
                    	}
                    	AlertDialog dialog_confirm = builder_confirm.create();
                    	dialog.dismiss();
                 		dialog_confirm.show();
                    }
                });
            	builder.setNegativeButton("No, merci!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
         // Create the AlertDialog
         		AlertDialog dialog = builder.create();
         		dialog.show();
            }
        });
        
      //BUTTON pain
        final Button button_pain = (Button) view.findViewById(R.id.button_pain);
        button_pain.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
            	
            	AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setMessage("Voulez-vous du pain?").setTitle("Pain");
            	builder.setPositiveButton("Oui, svp!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    	AlertDialog.Builder builder_confirm = new AlertDialog.Builder(getActivity());
                    	if(numPain < MAX_PAIN){
                    		numPain++;
                    		builder_confirm.setMessage("Du pain arrivera bientot").setTitle("Pain command�");
                    	}else{
                    		builder_confirm.setMessage("Vous avez command� trop de pain!").setTitle("Trop de pain");
                    	}
                    	AlertDialog dialog_confirm = builder_confirm.create();
                    	dialog.dismiss();
                 		dialog_confirm.show();
                    }
                });
            	builder.setNegativeButton("No, merci!", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
         // Create the AlertDialog
         		AlertDialog dialog = builder.create();
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
            		builder.setMessage("Un serveur arrivera bientot � votre table!").setTitle("Serveur coming soon");
            	}else{
            		builder.setMessage("Un serveur est en tran d'arriver � votre table.. Voulez-nous �xcuser pour l'attente.").setTitle("Serveur d�j� appell�");
                }
     
         		AlertDialog dialog = builder.create();
         		dialog.show();
            }
        });
        
        //BUTTON toilettes
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    	builder.setMessage("Voil� le plan pour arriver � les toilettes:").setTitle("Carte toilettes");
    	builder.setView(view_toilettes);
    	final AlertDialog dialog = builder.create();
        
        final Button button_toilette = (Button) view.findViewById(R.id.button_toilettes);
        button_toilette.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		dialog.show();
            }
        });
        
		
		return view ;	
	}
}