package bill.lesson3hw;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

/**
 *  MainActivity for Lesson3HW
 *  Contains a button that allows user to switch between 2 fragments
 */
public class MainActivity extends FragmentActivity {

    Button button;

    // Sets the view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creates an OnClickListener for the button
        button = (Button) findViewById(R.id.settings);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch from MainActivityFragment to Settings.
                // I learned from the code here:
                // http://stackoverflow.com/questions/7793576/switching-between-fragment-view
                Fragment fragment = new Settings();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.container, fragment, "Settings");
                transaction.addToBackStack(null);
                transaction.commit();
                button.setText("Back");

                // I didn't make the switch button work.
                // It only switches from ToDoList to Settings, but does not switch back.
            }
        });
    }
}



