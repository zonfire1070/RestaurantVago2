package com.example.restaurantvago;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class customAdapter extends ArrayAdapter<MenuItems> {

    private Activity activity;

    public customAdapter(Activity activity, int resource, List<MenuItems> objects) {
        super(activity, resource, objects);
        this.activity = activity;
    }

    @Override
    public int getViewTypeCount() {
        // return the total number of view types. this value should never change
        // at runtime
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        // return a value between 0 and (getViewTypeCount - 1)
        return position % 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        // inflate layout from xml
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        int layoutResource = 0; // determined by view type
        int viewType = getItemViewType(position);
        switch (viewType) {
            case 0:
                layoutResource = R.layout.odd_listview;
                break;

            case 1:
                layoutResource = R.layout.even_listview;
                break;
        }

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(layoutResource, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        // set data to views
        holder.name.setText(getItem(position).getName());
        holder.foodPic.setImageResource(getItem(position).getPic());

        return convertView;
    }

    private class ViewHolder {
        private ImageView foodPic;
        private TextView name;

        public ViewHolder(View v) {
            foodPic = (ImageView) v.findViewById(R.id.menu_image);
            name = (TextView) v.findViewById(R.id.name);
        }
    }

}