package bill.lesson3hw;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 *  MainActivity for Lesson3HW
 *  Contains a button that allows user to switch between 2 fragments
 */
public class MainActivity extends FragmentActivity {
    DatabaseHelper myDb;
    public static final String SettingsName = "backgroundColor";
    Button button;

    // Sets the view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
        // show activityFragment
        Fragment fragment = new MainActivityFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment, "MainActivityFragment");

        transaction.commit();
        button = (Button) findViewById(R.id.settings);
        button.setText("Settings");

        // Creates an OnClickListener for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch from MainActivityFragment to Settings.
                // I learned from the code here:
                // http://stackoverflow.com/questions/7793576/switching-between-fragment-view
                if(button.getText()=="Settings") {
                    Fragment fragment = new Settings();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment, "Settings");
                    transaction.addToBackStack(null);
                    transaction.commit();
                    button.setText("Back");
                }
                else{
                    Fragment fragment = new MainActivityFragment();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment, "MainActivityFragment");
                    transaction.addToBackStack(null);
                    transaction.commit();
                    button.setText("Settings");
                }
            }
        });
        // open up the settings file and get the color data from it
        SharedPreferences settings = getSharedPreferences(SettingsName, MODE_PRIVATE);
        int color = settings.getInt("backgroundColor", 0);
        findViewById(R.id.container).setBackgroundColor(color); //set the background color
    }
    // when the app stops, store data into the settings file
    @Override
    protected void onStop(){
        super.onStop();
        final View view = findViewById(R.id.container);
        int colorId = ((ColorDrawable)view.getBackground()).getColor(); // get the current background color
        SharedPreferences settings = getSharedPreferences(SettingsName, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("backgroundColor", colorId); // put the current color data into the file
        editor.commit(); // commit the edits
    }
}



