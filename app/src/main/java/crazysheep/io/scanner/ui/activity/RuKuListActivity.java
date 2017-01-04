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

public class RuKuListActivity extends BaseActivity {

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    List mList;
    RuKuListAdapter adapter;

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
        for (int i = 0; i < 10; i++) {
            mList.add(i);
        }
        adapter.notifyDataSetChanged();
    }
}
