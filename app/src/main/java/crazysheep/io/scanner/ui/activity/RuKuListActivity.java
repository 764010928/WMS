package crazysheep.io.scanner.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.adapter.RuKuListAdapter;
import crazysheep.io.scanner.net.Callback;
import crazysheep.io.scanner.net.Entity.RuKuEntity;
import crazysheep.io.scanner.net.O2OService;
import crazysheep.io.scanner.utils.ErrorMsgTip;

public class RuKuListActivity extends BaseTitleActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    List mList;
    RuKuListAdapter adapter;
    O2OService o2OService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ru_ku_list);
        ButterKnife.bind(this);
        initView();
        initData();
    }
    public void initView(){
        mList=new ArrayList();
        adapter=new RuKuListAdapter(this,mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }
    public void initData(){
        o2OService=new O2OService();
        o2OService.getRukuList(1, 100, new Callback<RuKuEntity>() {
            @Override
            public void onSuccess(RuKuEntity ruKuEntity) {
                if(ruKuEntity.isSuccess()){
                    mList.clear();
                    mList.addAll(ruKuEntity.getData().getData());
                    adapter.notifyDataSetChanged();
                }else
                    ErrorMsgTip.showMsg(ruKuEntity.getErrCode(),ruKuEntity.getErrMsg());
            }

            @Override
            public void onFailed(Throwable throwable) {
                ErrorMsgTip.showMsg(ErrorMsgTip.ERR_NOINTERNET);
            }
        });
    }
}
