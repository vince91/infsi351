package infsi351.Restauration;

import java.net.URI;

import android.app.ActionBar.LayoutParams;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
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
	private VideoView myVideoView;
	private int position = 0;
	private ProgressDialog progressDialog;
	private MediaController mediaControls;
	
	
	
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
		    	 counter_view.setText(getResources().getString(R.string.commande_is_coming));
		    	 
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
                	builder.setMessage(getResources().getString(R.string.wait_before_bill));
             		AlertDialog dialog = builder.create();
             		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
             		dialog.show();
        		}
        		
            }
        });
        
      //BUTTON video
      	final Button button_video = (Button) view.findViewById(R.id.button_camera);
      	button_video.setOnClickListener(new View.OnClickListener() {
      		public void onClick(View v) {
      			final Dialog dialog = new Dialog(getActivity());// add here your class name
      		    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
      		    dialog.setContentView(R.layout.video_fragment);//add your own xml with defied with and height of videoview
      		    dialog.show();
      		    WindowManager.LayoutParams lp = new WindowManager.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
      		    lp.copyFrom(dialog.getWindow().getAttributes());
      			dialog.getWindow().setAttributes(lp);
      			
      			if (mediaControls == null) {
      				mediaControls = new MediaController(mainActivity);
      			}
      			
      			final VideoView videoView = (VideoView) dialog.findViewById(R.id.video_view);
          		//Uri uri = Uri.parse("android.resource://"+mainActivity.getPackageName()+"/"+R.raw.video_pizza);
      			String path = "https://www.youtube.com/watch?v=eqNrYViVXe8";
      			Uri uri = Uri.parse(path);
          		videoView.setVideoURI(uri);
          		videoView.setMediaController(mediaControls);
          		videoView.requestFocus();
          		
          		videoView.setOnPreparedListener(new OnPreparedListener() {
          			public void onPrepared(MediaPlayer mediaPlayer) {
          			// close the progress bar and play the video
	          			progressDialog.dismiss();
          			//if we have a position on savedInstanceState, the video playback should start from here
	          			videoView.seekTo(position);
	          			if (position == 0) {
	          				myVideoView.start();
	          			} else {
          			//if we come from a resumed activity, video playback will be paused
	          				myVideoView.pause();
	          			}
          			}
          		});
          		
          		
          		videoView.start();
      			
            }
     
        });
              
		return view ;
	}
	
}