package crazysheep.io.scanner.adapter;

import android.content.Context;
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

/**
 * Created by Bing on 2016/12/30.
 */

public class RuKuListAdapter extends RecyclerView.Adapter<RuKuListAdapter.ViewHolder> {
    Context context;
    List mList;

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
            ButterKnife.bind(itemView);
//            R.layout.listview_ru_ku_list_item
        }
    }
}