package infsi351.Restauration;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentAccueil extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";
	private static final int NUM_PAGES = 5;
	private ViewPager mPager;
	private PagerAdapter mPagerAdapter;

	public FragmentAccueil() {
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Create a new TextView and set its text to the fragment's section
		// number argument value.
		
		View view = inflater.inflate(R.layout.screen_slide_accueil, container, false);
		
		mPager = (ViewPager) view.findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter( ((MainActivity) getActivity()).getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        
		
		return view;
		
	}
	
	private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
            this.pageSwitcher(3);
        }

        @Override
        public Fragment getItem(int position) {
        	
        	if (position == 0){
        		return new SlidePage1_Accueil();
        	}
        	else if (position == 1){
        		return new SlidePage2_Accueil();
        	}
        	else if (position == 2){
        		return new SlidePage3_Accueil();
        	}
        	else if (position == 3){
        		return new SlidePage4_Accueil();
        	}
        	else if (position == 4){
        		return new SlidePage5_Accueil();
        	}
        	else return new SlidePage1_Accueil();

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
        
        Timer timer;
        int page = 0;

        public void pageSwitcher(int seconds) {
            timer = new Timer(); // At this line a new Thread will be created
            timer.scheduleAtFixedRate(new RemindTask(), 0, seconds * 1000); // delay
                                                                            // in
            // milliseconds
        }

            // this is an inner class...
        class RemindTask extends TimerTask {

            @Override
            public void run() {

                // As the TimerTask run on a seprate thread from UI thread we have
                // to call runOnUiThread to do work on UI thread.
            	((MainActivity) getActivity()).runOnUiThread(new Runnable() {
                    public void run() {

                        if (page > 4) { // In my case the number of pages are 5
                            timer.cancel();
                            // Showing a toast for just testing purpose
                            Toast.makeText(((MainActivity) getActivity()).getApplicationContext(), "Timer stoped",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            mPager.setCurrentItem(page++);
                        }
                    }
                });

            }
        }

        
        
    }
}