package crazysheep.io.scanner.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.net.Entity.RuKuEntity;
import crazysheep.io.scanner.ui.activity.RuKuActivity;
import crazysheep.io.scanner.ui.activity.RuKuDetailsActivity;

/**
 * Created by Bing on 2016/12/30.
 */

public class RuKuListAdapter extends RecyclerView.Adapter<RuKuListAdapter.ViewHolder> {
    Context context;
    List<RuKuEntity.DataBeanX.DataBean> mList;

    public RuKuListAdapter(Context context, List mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.listview_ru_ku_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RuKuEntity.DataBeanX.DataBean data=mList.get(position);

        holder.rukuId.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG);
        holder.rukuId.getPaint().setAntiAlias(true);
        holder.rukuId.setOnClickListener(new MyOnclick(position,false));
        holder.rukuButton.setOnClickListener(new MyOnclick(position,true));

        holder.rukuId.setText(getString(R.string.ru_ku_code,data.getCode()));
        holder.rukuFrom.setText(data.getFrom());
        holder.rukuTo.setText(data.getTo());
        holder.rukuType.setText(getString(R.string.ru_ku_type,data.getTypeName()));
        holder.tukuStatus.setText(getString(R.string.ru_ku_status,data.getStatusName()));
        holder.rukuConut.setText(getString(R.string.ru_ku_count,data.getExpectedCount()));
        holder.rukuConutNow.setText(getString(R.string.ru_ku_count_now,data.getActualCount()));
    }
    public String getString(@StringRes int id,Object obj){
        return context.getString(id,obj);
    }
    class MyOnclick implements View.OnClickListener{
        int postion;
        boolean isRuku;

        public MyOnclick(int postion, boolean isRuku) {
            this.postion = postion;
            this.isRuku = isRuku;
        }

        @Override
        public void onClick(View v) {

            if(isRuku)
                context.startActivity(new Intent(context, RuKuActivity.class).putExtra("taskId",mList.get(postion).getTaskId()).putExtra("code",mList.get(postion).getCode()));
            else
                context.startActivity(new Intent(context, RuKuDetailsActivity.class).putExtra("taskId",mList.get(postion).getTaskId()).putExtra("code",mList.get(postion).getCode()));
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ruku_id)
        TextView rukuId;
        @BindView(R.id.ruku_from)
        TextView rukuFrom;
        @BindView(R.id.ruku_to)
        TextView rukuTo;
        @BindView(R.id.ruku_type)
        TextView rukuType;
        @BindView(R.id.tuku_status)
        TextView tukuStatus;
        @BindView(R.id.ruku_conut)
        TextView rukuConut;
        @BindView(R.id.ruku_conut_now)
        TextView rukuConutNow;
        @BindView(R.id.ruku_button)
        Button rukuButton;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
