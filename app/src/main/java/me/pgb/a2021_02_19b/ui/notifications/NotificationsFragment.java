package me.pgb.a2021_02_19b.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.pgb.a2021_02_19b.ItemArrayAdapter;
import me.pgb.a2021_02_19b.R;
import me.pgb.a2021_02_19b.model.Dog;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private ArrayList<Dog> dogList = new ArrayList<Dog>();

    public void onCreate(Bundle mySavedBundle) {
        super.onCreate(mySavedBundle);

        notificationsViewModel = new ViewModelProvider(requireActivity()).get(NotificationsViewModel.class);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


    // Populating list items
        for(int i=0; i<100; i++) {
            dogList.add(new Dog("Dog: " + i, R.mipmap.ic_launcher));
        }

        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.each_list_item, dogList);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.list_item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);




        return root;
    }
}