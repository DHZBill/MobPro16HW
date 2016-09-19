package bill.lesson3hw;

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
public class MainActivityFragment extends Fragment {
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
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, v);
        // Construct the data source
        ArrayList<ToDoItem> arrayOfItems = new ArrayList<>();
        // Create the adapter to convert the array to views
        final ToDoAdapter adapter = new ToDoAdapter(this.getContext(), arrayOfItems);
        // Attach the adapter to a ListVie
        listView.setAdapter(adapter);

        //set the onClickListener for the add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoItem item = new ToDoItem("What to do?");
                adapter.add(item);
            }
        });
        return v;
    }
}

