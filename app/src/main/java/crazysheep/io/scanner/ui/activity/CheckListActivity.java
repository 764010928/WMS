package crazysheep.io.scanner.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.adapter.CheckListAdapter;
import crazysheep.io.scanner.net.Callback;
import crazysheep.io.scanner.net.Entity.CheckListEntity;
import crazysheep.io.scanner.net.O2OService;
import crazysheep.io.scanner.utils.ErrorMsgTip;

public class CheckListActivity extends BaseTitleActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    CheckListAdapter adapter;
    List<CheckListEntity.DataBeanX.DataBean> mList = null;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    O2OService o2OService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);
        ButterKnife.bind(this);
        o2OService = new O2OService();
        initView();
        initDate();
    }

    public void initDate() {
        o2OService.getCheckList(1, 100, new Callback<CheckListEntity>() {
            @Override
            public void onSuccess(CheckListEntity checkListEntity) {
                refresh.setRefreshing(false);
                if (checkListEntity.isSuccess()) {
                    mList.clear();
                    mList.addAll(checkListEntity.getData().getData());
                    adapter.notifyDataSetChanged();
                } else
                    ErrorMsgTip.showMsg(checkListEntity.getErrCode(), checkListEntity.getErrMsg());
            }

            @Override
            public void onFailed(Throwable throwable) {
                refresh.setRefreshing(false);
                ErrorMsgTip.showMsg(ErrorMsgTip.ERR_NOINTERNET);
            }
        });
    }

    public void initView() {
        mList = new ArrayList<>();
        adapter = new CheckListAdapter(this, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
        refresh.setColorSchemeColors(Color.BLUE,Color.RED,Color.YELLOW,Color.GREEN);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initDate();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            initDate();
        }
    }
}
