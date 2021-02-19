package me.pgb.a2021_02_19b;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import me.pgb.a2021_02_19b.model.Dog;

public class ItemArrayAdapter extends RecyclerView.Adapter<ItemArrayAdapter.ViewHolder> {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<Dog> dogList;
    // Constructor of the class
    public ItemArrayAdapter(int layoutId, ArrayList<Dog> dogList) {
        listItemLayout = layoutId;
        this.dogList = dogList;
    }

    @Override
    public int getItemCount() {
        return dogList == null ? 0 : dogList.size();
    }

    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        ImageView picture = holder.image;
        item.setText(dogList.get(listPosition).getName());
        picture.setImageResource(dogList.get(listPosition).getImage());
    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item;
        public ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = (TextView) itemView.findViewById(R.id.row_item);
            image = (ImageView) itemView.findViewById(R.id.dog_pic);
        }
        @Override
        public void onClick(View view) {
            Log.d("ON_CLICK", "onClick " + getLayoutPosition() + " for item " + item.getText());
        }
    }
}