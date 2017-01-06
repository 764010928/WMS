package crazysheep.io.scanner.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;

/**
 * Created by Bing on 2017/1/4.
 */

public class MenuAdapter extends BaseAdapter {
    String[] strs;
    Context context;
    int[] colors = {R.color.colorPrimary, R.color.colorAccent, android.R.color.holo_blue_dark};

    public MenuAdapter(String[] strs, Context context) {
        this.strs = strs;
        this.context = context;
    }

    @Override
    public int getCount() {
        return strs.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_menu_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.textview.setText(strs[position]);
//        RandomColor randomColor=new RandomColor();
//        viewHolder.cardview.setCardBackgroundColor(randomColor.randomColor());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.textview)
        TextView textview;
        @BindView(R.id.cardview)
        CardView cardview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
