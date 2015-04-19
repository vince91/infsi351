package infsi351.Restauration;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewParent;

public class MainActivity extends FragmentActivity implements
		ActionBar.TabListener {

	public Commande commande;
	public Boolean commande_validee;
	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current tab position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	private Pizza pizza;
	
	private Tab compositionTab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		commande = new Commande();
		commande_validee = false;

		// Set up the action bar to show tabs.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		compositionTab = actionBar.newTab().setText(R.string.title_section2)
				.setTabListener(this);

		// For each of the sections in the app, add a tab to the action bar.
		actionBar.addTab(actionBar.newTab().setText(R.string.title_section1)
				.setTabListener(this));
		actionBar.addTab(compositionTab);
		actionBar.addTab(actionBar.newTab().setText(R.string.title_section3)
				.setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText(R.string.title_section4)
				.setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText(R.string.title_section5)
				.setTabListener(this));
	}

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current tab position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current tab position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, show the tab contents in the
		// container view.
		
		int tab_num = tab.getPosition();
			
		Fragment frag;

		if (tab_num == 0)
			frag = new FragmentAccueil();
		else if (tab_num == 1) {
			pizza = new Pizza();
			frag = new FragmentComposition1();
		}
		else if (tab_num == 2)
			frag = new FragmentBoisson();
		else if (tab_num == 3)
			frag = new FragmentServeur();
		else{
			if(!commande_validee){frag = new FragmentPanier();}
			else{frag = new FragmentApresCommande();}
		}
		
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, frag).commit();
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction) {
	}
	
	public void switchToComposition2() {
		Fragment fragment = new FragmentComposition2();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
		fragmentTransaction.replace(R.id.container, fragment);
		fragmentTransaction.commit();
	}
	
	public void switchToComposition1(boolean left)
	{
		Fragment fragment = new FragmentComposition1();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		if (left)
			fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
		else
			fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
		fragmentTransaction.replace(R.id.container, fragment);
		fragmentTransaction.commit();	
		getActionBar().setSelectedNavigationItem(1);		
	}
	
	public void refresh_da_panier(){
		Fragment fragment = new FragmentPanier();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.container, fragment);
		fragmentTransaction.commit();
	}
	
	public void valider_la_commande(View v){
		Fragment fragment = new FragmentApresCommande();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
		fragmentTransaction.replace(R.id.container, fragment);
		fragmentTransaction.commit();
		commande_validee = true;
	}
	
	public void switch_tab_to_panier(View v){
		Fragment fragment = new FragmentPanier();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
		fragmentTransaction.replace(R.id.container, fragment);
		fragmentTransaction.commit();
	}
	
	public void switch_tab_to_composition(View v){
		Fragment fragment = new FragmentComposition1();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
		fragmentTransaction.replace(R.id.container, fragment);
		fragmentTransaction.commit();
	}
	
	public void switch_tab_to_garcon(View v){
		Fragment fragment = new FragmentServeur();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
		fragmentTransaction.replace(R.id.container, fragment);
		fragmentTransaction.commit();
	}
	
	public void switch_tab_to_boisson(View v){
		Fragment fragment = new FragmentBoisson();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
		fragmentTransaction.replace(R.id.container, fragment);
		fragmentTransaction.commit();
		getActionBar().setSelectedNavigationItem(2);		
	}
	
	public void voir_addition(View v){
		Fragment fragment = new FragmentAddition();
		android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
		fragmentTransaction.replace(R.id.container, fragment);
		fragmentTransaction.commit();
	}
	
	public void setPizza(Pizza p){
		pizza = p;
	}
	
	public Pizza getPizza() {
		return pizza;
	}
	
	public void validerPizza() {
		commande.add_pizza(pizza);
		pizza = new Pizza();
	}


}
