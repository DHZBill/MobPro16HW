package bill.lesson3hw;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * The ToDoList Fragment contains a list of 5 textViews. Pops up an alert dialog for input
 * when clicking on a textView.
 */
// Nice class descriptions
public class MainActivityFragment extends Fragment {
    DatabaseHelper myDb;
    @BindView(R.id.lvItems) ListView listView;
    @BindView((R.id.addButton)) Button addButton;
    public MainActivityFragment() {
    }

    /**
     * Create a view.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //create a DatabaseHelper
        myDb = new DatabaseHelper(this.getContext());
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, v); // bind the view
        // Construct the data source
        ArrayList<ToDoItem> arrayOfItems = new ArrayList<>();
        // Create the adapter to convert the array to views
        final ToDoAdapter adapter = new ToDoAdapter(this.getContext(), arrayOfItems);
        // Attach the adapter to a ListVie
        listView.setAdapter(adapter);
        // get all data from the database
        Cursor data = myDb.getAllData();
        // use data to construct items and add the items to adapter

        // You should move this to a method in the helper
        if (data.moveToFirst()) {
            while (data.isAfterLast() == false) { // Can be rewritten as while (!data.isAfterLast())
                String toDo = data.getString(data.getColumnIndex("TODO"));
                long id = data.getLong(data.getColumnIndex("ID"));
                ToDoItem item = new ToDoItem(toDo);
                item.setId(id);
                adapter.add(item);
                data.moveToNext();
            }
        }
        //set the onClickListener for the add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoItem item = new ToDoItem("What to do?");
                adapter.add(item);
                item.setId(myDb.insertData(item.getToDo())); // set the Id of the item when adding a new item
            }
        });
        return v;
    }
}

