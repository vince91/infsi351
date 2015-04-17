package infsi351.Restauration;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
		final View view = inflater.inflate(R.layout.aprescommande_fragment, container, false);
		final View view_addition = inflater.inflate(R.layout.addition_fragment, container, false);
		
		CountDownTimer counter = new CountDownTimer(30*1*1000, 1000){

		     public void onTick(long millisUntilFinished) {
		    	 final TextView counter_view = (TextView) view.findViewById(R.id.counter_value);
		    	 String v = String.format("%02d", millisUntilFinished/60000);
                 int va = (int)( (millisUntilFinished%60000)/1000);
		    	 counter_view.setText(v+":"+String.format("%02d",va));
		    	 //counter_view.setText("seconds remaining: " +v+":"+String.format("%02d",va));
		          }

		     public void onFinish() {
		    	 final TextView counter_view = (TextView) view.findViewById(R.id.counter_value);
		    	 counter_view.setText("Votre commande est en tran d'arriver ˆ la table!");
		     }
		  };
		counter.start();
		
		final Button button_addition = (Button) view.findViewById(R.id.button_addition);
		button_addition.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            	builder.setMessage("Voilˆ l'addition de votre commande:").setTitle("Addition");
            	builder.setView(view_addition);
         // Create the AlertDialog
         		AlertDialog dialog = builder.create();
         		dialog.show();
            }
        });
		
		return view ;
	}
	
}