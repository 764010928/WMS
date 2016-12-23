package crazysheep.io.scanner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.net.Entity.GoodsEntity;

/**
 * Created by Bin on 2016/8/29.
 */
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.MyViewHodler> implements View.OnClickListener {
    OnRecyclerViewItemClickListener onItemClickListener = null;
    Context context;
    List<GoodsEntity.DataBeanX.DataBean> list;

    public GoodsAdapter(List<GoodsEntity.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public GoodsAdapter.MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_goods_list_item, parent, false);
        view.setOnClickListener(this);
        MyViewHodler hodler = new MyViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(GoodsAdapter.MyViewHodler holder, int position) {
        holder.itemView.setTag(position);

        holder.code.setText("code:" + list.get(position).getCode());
        holder.name.setText("name:" + list.get(position).getName());
        holder.color.setText("color:暂无");
        holder.size.setText("size:暂无");
        holder.brand.setText("brand:" + list.get(position).getBrand());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View view) {
        if (onItemClickListener != null)
            onItemClickListener.onItemClick(view, (int) view.getTag());
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    //define interface
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int pos);
    }

    class MyViewHodler extends RecyclerView.ViewHolder {
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

        public MyViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}