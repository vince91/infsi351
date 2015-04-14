package infsi351.Restauration;

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
        
        
    }
}