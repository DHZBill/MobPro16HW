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

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * The ToDoList Fragment contains a list of 5 textViews. Pops up an alert dialog for input
 * when clicking on a textView.
 */
public class MainActivityFragment extends Fragment {
    private String m_Text = "";                                     // declare user input

    public MainActivityFragment() {}

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

        /* SUGGESTION
        If you know the exact size of the ArrayList, good practice would be to declare the size
        in the constructor.
        */
        final ArrayList<TextView> itemList = new ArrayList<>(5);
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);

        // SUGGESTION: Use this for loop if indices do not matter
        for (final TextView item : itemList) {
            item.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Creates an AlertDialog. I learned from the code here:
                    // http://stackoverflow.com/questions/10903754/input-text-dialog-android
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

                    // Strings need to go into strings.xml!!
                    builder.setTitle(getResources().getString(R.string.dialog_title));

                    // Set up the input
                    final EditText input = new EditText(v.getContext());

                    /* POINTS DEDUCTED
                    Comment here. I don't know what this means. Also, quick look up
                    shows that InputType.TYPE_CLASS_TEXT = 1. So 1 | 1 = 1. The stackoverflow
                    page has it as TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD. You should
                    aim to understand and be able to explain lines like these in comments next
                    time.
                    */
                    input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
                    builder.setView(input);

                    // You can chain the methods like so:
                    builder.setPositiveButton(getResources().getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            m_Text = input.getText().toString();
                            item.setText(m_Text);
                        }
                    }).setNegativeButton(getResources().getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
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

