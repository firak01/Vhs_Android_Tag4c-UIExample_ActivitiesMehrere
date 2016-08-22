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

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public static final String PACKAGE = "com.example.mehrereactivities";
    public static final String KEY_VORNAME = PACKAGE + "." + "VORNAME";
    public static final int REQUEST_CODE = 42;
   
    public void sendButtonClicked(View view) {
    	String vorname = ((EditText) findViewById(R.id.edit_vorname)).getText().toString();
    	
    	Intent intent = new Intent(getApplicationContext(), ZweiteActivity.class);
    	intent.putExtra(KEY_VORNAME, vorname);
    	startActivityForResult(intent, REQUEST_CODE);
    }


	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		super.onActivityResult(arg0, arg1, arg2);
		if (arg0 == REQUEST_CODE) {
			if (arg1 == RESULT_OK) {
				String vorname = (String) arg2.getExtras().get(MainActivity.KEY_VORNAME);				
				EditText editVorname = (EditText) findViewById(R.id.edit_vorname);
				editVorname.setText(vorname);
			}
		}
	}
    
    

}
