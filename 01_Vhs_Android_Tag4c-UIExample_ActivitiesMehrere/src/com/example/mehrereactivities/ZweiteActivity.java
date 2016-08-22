package com.example.mehrereactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class ZweiteActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zweite);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Intent intent = getIntent();
		if (intent != null) {
			String vorname = (String) intent.getExtras().get(MainActivity.KEY_VORNAME);
			EditText editUpdateVorname = (EditText) findViewById(R.id.edit_update_vorname);
			editUpdateVorname.setText(vorname);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zweite, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_zweite,
					container, false);
			return rootView;
		}
	}

	public void okButtonClicked(View view) {
		goBack(true);
	}
	
	public void cancelButtonClicked(View view) {
		goBack(false);
	}
	
	private void goBack(boolean success) {
		if (success) {
			EditText editUpdateVorname = (EditText) findViewById(R.id.edit_update_vorname);
			String vorname = editUpdateVorname.getText().toString();
			Intent intent = getIntent();
			intent.putExtra(MainActivity.KEY_VORNAME, vorname);
			setResult(RESULT_OK, intent);
			finish();
		} else {
			setResult(RESULT_CANCELED);
			finish();			
		}
	}
}
