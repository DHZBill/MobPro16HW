package bill.lesson3hw;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DHZ_Bill on 9/19/16.
 * Create a custom adapter
 */
public class ToDoAdapter extends ArrayAdapter<ToDoItem> {
    @BindView(R.id.listItem) TextView listItem;
    @BindView(R.id.editButton) Button editButton;
    @BindView(R.id.deleteButton)
    Button deleteButton;
    public ToDoAdapter(Context context, ArrayList<ToDoItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final ToDoItem item = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todo_item, parent, false);
        }
        // Bind ButterKnife to this fragment
        ButterKnife.bind(this, convertView);
        // Create onClickListener for edit Button
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        String m_Text = input.getText().toString();
                        listItem.setText(m_Text);;
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                notifyDataSetChanged();
                builder.show();
            }
        });

        // Create onClickListener for delete Button
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(item); //remove the item
                notifyDataSetChanged();
            }
        });
        // Return the completed view to render on screen
        return convertView;
    }
}
