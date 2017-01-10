package crazysheep.io.scanner.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.net.Entity.RuKuDetailEntity;

/**
 * Created by Bing on 2017/1/6.
 */

public class RuKuGoodsAdapter extends RecyclerView.Adapter<RuKuGoodsAdapter.ViewHolder> {
    List<RuKuDetailEntity.DataBean.ProductsBean> mList;

    public RuKuGoodsAdapter(List<RuKuDetailEntity.DataBean.ProductsBean> mList) {
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_ruku_goods_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RuKuDetailEntity.DataBean.ProductsBean data=mList.get(position);
        holder.goodsName.setText(data.getName());
        holder.goodsCount.setText(data.getExpectedCount()+"");
        holder.goodsCountNow.setText(data.getActualCount()+"");
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.goods_name)
        TextView goodsName;
        @BindView(R.id.goods_count)
        TextView goodsCount;
        @BindView(R.id.goods_count_now)
        TextView goodsCountNow;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
