package crazysheep.io.scanner.adapter;

import android.app.Activity;
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
    boolean isRuKu;

    public RuKuListAdapter(Context context, List<RuKuEntity.DataBeanX.DataBean> mList, boolean isRuKu) {
        this.context = context;
        this.mList = mList;
        this.isRuKu = isRuKu;
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
        holder.rukuButton.setText(isRuKu?R.string.scan_ru_ku:R.string.scan_chu_ku);

        holder.rukuId.setText(getString(isRuKu?R.string.ru_ku_code:R.string.chu_ku_code,data.getCode()));
        holder.rukuFrom.setText(data.getFrom());
        holder.rukuTo.setText(data.getTo());
        holder.rukuType.setText(getString(isRuKu?R.string.ru_ku_type:R.string.chu_ku_type,data.getTypeName()));
        holder.tukuStatus.setText(getString(R.string.ru_ku_status,data.getStatusName()));
        holder.rukuConut.setText(getString(isRuKu?R.string.ru_ku_count:R.string.chu_ku_count,data.getExpectedCount()));
        holder.rukuConutNow.setText(getString(isRuKu?R.string.ru_ku_count_now:R.string.chu_ku_count_now,data.getActualCount()));
    }
    public String getString(@StringRes int id,Object obj){
        return context.getString(id,obj);
    }
    class MyOnclick implements View.OnClickListener{
        int postion;
        boolean isScan;

        public MyOnclick(int postion, boolean isScan) {
            this.postion = postion;
            this.isScan = isScan;
        }

        @Override
        public void onClick(View v) {
            Intent mIntent=new Intent();
            mIntent.putExtra("taskId",mList.get(postion).getTaskId())
                    .putExtra("code",mList.get(postion).getCode())
                    .putExtra("isRuKu",isRuKu);
            if(isScan) {
                mIntent.setClass(context, RuKuActivity.class);
                ((Activity)context).startActivityForResult(mIntent,1);
            }
            else {
                mIntent.setClass(context, RuKuDetailsActivity.class);
                context.startActivity(mIntent);
            }

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
