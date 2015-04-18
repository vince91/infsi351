package infsi351.Restauration;

import java.net.URI;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class FragmentApresCommande extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";
	public boolean prete;
	
	public FragmentApresCommande() {
		prete=false;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		final View view = inflater.inflate(R.layout.aprescommande_fragment, container, false);
		final MainActivity mainActivity = (MainActivity) getActivity();
		
		//COUNTER
		CountDownTimer counter = new CountDownTimer(30*1*1000, 1000){
			public void onTick(long millisUntilFinished) {
		    	 final TextView counter_view = (TextView) view.findViewById(R.id.counter_value);
		    	 String v = String.format("%02d", millisUntilFinished/60000);
                 int va = (int)( (millisUntilFinished%60000)/1000);
		    	 counter_view.setText(v+":"+String.format("%02d",va));
		    	 //counter_view.setText("seconds remaining: " +v+":"+String.format("%02d",va));
		          }

		     public void onFinish() {
		    	 prete=true;
		    	 final TextView counter_view = (TextView) view.findViewById(R.id.counter_value);
		    	 counter_view.setText("Votre commande est en tran d'arriver ˆ la table!");
		    	 
		     }
		};
		prete=false;  
		counter.start();
		
		//BUTTON addition
		final Button button_addition = (Button) view.findViewById(R.id.button_addition);
        button_addition.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		if(prete==true){
        			mainActivity.voir_addition(view);
        		}else{
        			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                	builder.setMessage("Voulez attendre votre commande avant de demander l'addition").setTitle("Attendez commande");
             		AlertDialog dialog = builder.create();
             		dialog.show();
        		}
        		
            }
        });
        
		return view ;
	}
	
}