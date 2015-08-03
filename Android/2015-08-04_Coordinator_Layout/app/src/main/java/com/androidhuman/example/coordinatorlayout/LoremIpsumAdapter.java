package com.androidhuman.example.coordinatorlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoremIpsumAdapter extends RecyclerView.Adapter<LoremIpsumAdapter.TextViewHolder> {

    private String[] items = new String[]{
            "Lorem", "ipsum", "dolor", "sit", "amet",
            "consectetur", "adipiscing", "elit", "Etiam", "hendrerit",
            "auctor", "dui", "ac", "lobortis", "Cras"
    };

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new TextViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.tvText.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        public TextView tvText;

        public TextViewHolder(View itemView) {
            super(itemView);
            tvText = (TextView) itemView.findViewById(R.id.text);
        }
    }

}


