package bill.lesson3hw;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import java.util.ArrayList;


/**
 * The ToDoList Fragment contains a list of 5 textViews. Pops up an alert dialog for input
 * when clicking on a textView.
 */
public class MainActivityFragment extends Fragment {
    private String m_Text = "";                                     // declare user input

    public MainActivityFragment() {
    }

    /**
     * Create a view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        //get all textViews in the ToDoList.
        TextView item1 = (TextView) v.findViewById(R.id.listItem1);
        TextView item2 = (TextView) v.findViewById(R.id.listItem2);
        TextView item3 = (TextView) v.findViewById(R.id.listItem3);
        TextView item4 = (TextView) v.findViewById(R.id.listItem4);
        TextView item5 = (TextView) v.findViewById(R.id.listItem5);

        //put them into an ArrayList
        final ArrayList<TextView> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);

        // for each textView, creates an OnCLickListener
        for (int i = 0; i < itemList.size(); i++) {
            final TextView item = itemList.get(i);
            item.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Creates an AlertDialog. I learned from the code here:
                    // http://stackoverflow.com/questions/10903754/input-text-dialog-android
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle("What to do?");

                    // Set up the input
                    final EditText input = new EditText(v.getContext());
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
                    builder.setView(input);

                    // Set up the buttons
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            m_Text = input.getText().toString();
                            item.setText(m_Text);;
                        }
                    });
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
            });
        }
        return v;
    }
}

