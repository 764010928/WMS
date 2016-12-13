package crazysheep.io.scanner.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.net.Entity.GoodsEntity;

/**
 * Created by Bing on 2016/12/9.
 */

public class GoodsListAdapter extends BaseAdapter {
    List<GoodsEntity.DataBeanX.DataBean> list;
    Context context;

    public GoodsListAdapter(List<GoodsEntity.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null){
            view=View.inflate(context,R.layout.listview_goods_list_item,null);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else
            viewHolder= (ViewHolder) view.getTag();
        viewHolder.code.setText("code:"+list.get(i).getCode());
        viewHolder.name.setText("name:"+list.get(i).getName());
        viewHolder.color.setText("color:暂无");
        viewHolder.size.setText("size:暂无");
        viewHolder.brand.setText("brand:"+list.get(i).getBrand());
        return view;
    }
    static class ViewHolder{
        @BindView(R.id.goods_code)
        TextView code;
        @BindView(R.id.goods_name)
        TextView name;
        @BindView(R.id.goods_color)
        TextView color;
        @BindView(R.id.goods_size)
        TextView size;
        @BindView(R.id.goods_brand)
        TextView brand;

        public ViewHolder(View view) {
            ButterKnife.bind(this,view);
        }
    }
}
