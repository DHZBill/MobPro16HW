package bill.lesson3hw;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.ArrayList;

/**
 *  Fragment Settings contains 3 buttons that allows user to change background color
 */
public class Settings extends Fragment {

    public Settings() {
    }

    // Creates a view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        // Gets all 3 buttons
        Button yellowButton = (Button) v.findViewById(R.id.yellowButton);
        Button greenButton = (Button) v.findViewById(R.id.greenButton);
        Button blueButton = (Button) v.findViewById(R.id.blueButton);

        // Gets the view of the Activity
        final View view = getActivity().findViewById(R.id.container);

        // Puts the buttons into an ArrayList
        final ArrayList<Button> colorList = new ArrayList<>();
        colorList.add(yellowButton);
        colorList.add(greenButton);
        colorList.add(blueButton);

        // SUGGESTION: Use this for loop instead
        for (final Button button : colorList) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /* SUGGESTION:
                    Use switch statement (I know these weren't covered in class, but it's good practice!
                    */
                    switch (button.getId()) {
                        case R.id.yellowButton:
                            view.setBackgroundColor(Color.YELLOW);
                            break;

                        case R.id.greenButton:
                            view.setBackgroundColor(Color.GREEN);
                            break;

                        case R.id.blueButton:
                            view.setBackgroundColor(Color.BLUE);
                            break;
                    }
                }

            });

        }
        return v;

    }
}
