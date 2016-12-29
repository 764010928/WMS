package crazysheep.io.scanner.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import crazysheep.io.scanner.net.Entity.CheckListEntity;
import crazysheep.io.scanner.ui.activity.CheckActivity;

/**
 * Created by Bing on 2016/12/14.
 */

public class CheckListAdapter extends RecyclerView.Adapter<CheckListAdapter.ViewHodler> {
    Context context;
    List<CheckListEntity.DataBeanX.DataBean> list;

    public CheckListAdapter(Context context, List<CheckListEntity.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_check_list_item, parent, false);
        ViewHodler hodler = new ViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(ViewHodler holder, int position) {
        CheckListEntity.DataBeanX.DataBean bean=list.get(position);
        holder.createTime.setText(context.getString(R.string.create_time,bean.getCreateTime()));
        holder.endTime.setText(context.getString(R.string.end_time,bean.getFinishTime()));
        holder.daiPandian.setText(context.getString(R.string.dai_pandian,bean.getExpectedCount()));
        holder.yipandian.setText(context.getString(R.string.yipandian,bean.getActualCount()));
        holder.operator.setText(context.getString(R.string.operator,bean.getCreatorName()));
        holder.sponsor.setText(context.getString(R.string.sponsor,bean.getCreatorName()));
        holder.status.setText(context.getString(R.string.status,bean.getStatusName()));
        holder.type.setText(context.getString(R.string.type,bean.getTypeName()));
        holder.checkID.setText(context.getString(R.string.check_id,bean.getCode()));
        holder.button.setOnClickListener(new MyOnClick(bean.getTaskId()));
    }
    class MyOnClick implements View.OnClickListener{
        int taskId;

        public MyOnClick(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, CheckActivity.class).putExtra("taskId",taskId);
            ((Activity)context).startActivityForResult(intent,1);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHodler extends RecyclerView.ViewHolder {
        @BindView(R.id.create_time)
        TextView createTime;
        @BindView(R.id.end_time)
        TextView endTime;
        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.sponsor)
        TextView sponsor;
        @BindView(R.id.operator)
        TextView operator;
        @BindView(R.id.dai_pandian)
        TextView daiPandian;
        @BindView(R.id.yipandian)
        TextView yipandian;
        @BindView(R.id.button)
        Button button;
        @BindView(R.id.check_id)
        TextView checkID;

        public ViewHodler(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
