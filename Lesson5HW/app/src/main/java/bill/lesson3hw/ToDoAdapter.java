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


/**
 * Created by DHZ_Bill on 9/19/16.
 * Create a custom adapter
 */
public class ToDoAdapter extends ArrayAdapter<ToDoItem> {
    DatabaseHelper myDb;
    public ToDoAdapter(Context context, ArrayList<ToDoItem> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ToDoHolder holder = new ToDoHolder();
        myDb = new DatabaseHelper(this.getContext());
        // Get the data item for this position
        holder.toDoItem = getItem(position);
        System.out.println(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todo_item, parent, false);
        }
        // I didn't figure out how to implement ButterKnife here.
        // Because all elements here is a property of the holder class
        holder.editButton = (Button)convertView.findViewById(R.id.editButton);
        holder.editButton.setTag(holder.toDoItem);
        holder.deleteButton = (Button)convertView.findViewById(R.id.deleteButton);
        holder.listItem = (TextView)convertView.findViewById(R.id.listItem);
//         Create onClickListener for edit Button
        holder.editButton.setOnClickListener(new View.OnClickListener() {
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
                        // change the text in the TextView and update the database
                        holder.toDoItem.setToDo(m_Text);
                        System.out.println("m_Text: " + m_Text + " toDoItem text: " + holder.toDoItem.getToDo() );
                        holder.listItem.setText(m_Text);
                        UpdateData(holder.toDoItem);
                    }
                });
                // Close the dialog if pressing on Cancel button
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
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(holder.toDoItem); //remove the item
                DeleteData(holder.toDoItem); //delete the item from the database
                notifyDataSetChanged();
            }
        });
        convertView.setTag(holder);
        setupItem(holder);
        // Return the completed view to render on screen
        return convertView;
    }
    // set the TextView
    private void setupItem(ToDoHolder holder){
        holder.listItem.setText(holder.toDoItem.getToDo());
    }
    public static class ToDoHolder{
        Button editButton;
        TextView listItem;
        Button deleteButton;
        ToDoItem toDoItem;

    }
    // update database
    public void UpdateData(ToDoItem toDoItem){
        myDb.updateData(toDoItem);
    }
    // delete from database
    public void DeleteData(ToDoItem toDoItem){
        myDb.deleteData(toDoItem);
    }
}
