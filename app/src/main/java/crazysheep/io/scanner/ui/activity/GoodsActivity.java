package crazysheep.io.scanner.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.adapter.GoodsAdapter;
import crazysheep.io.scanner.net.Callback;
import crazysheep.io.scanner.net.Entity.GoodsEntity;
import crazysheep.io.scanner.net.O2OService;
import crazysheep.io.scanner.utils.ErrorMsgTip;

public class GoodsActivity extends BaseTitleActivity {

    O2OService o2OService = null;
    List<GoodsEntity.DataBeanX.DataBean> list = null;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    GoodsAdapter mAdapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        ButterKnife.bind(this);
        initView();
        getGoodsList();
    }

    public void initView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        mRecyclerView.setAdapter(mAdapter = new GoodsAdapter(list, this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter.setOnItemClickListener(new GoodsAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
            }
        });
    }

    public void getGoodsList() {
        String search=getIntent().getStringExtra("search");
        o2OService = new O2OService();
        o2OService.getGoodsList(search, new Callback<GoodsEntity>() {
            @Override
            public void onSuccess(GoodsEntity goodsEntity) {
                if (goodsEntity.isSuccess()) {
                    if(goodsEntity.getData().getTotal()>0){
                        list.clear();
                        list.addAll(goodsEntity.getData().getData());
                        mAdapter.notifyDataSetChanged();
                    }else {
                        ErrorMsgTip.showMsg("1");
                        finish();
                    }
                } else
                    ErrorMsgTip.showMsg(goodsEntity.getErrCode(),goodsEntity.getErrMsg());
            }

            @Override
            public void onFailed(Throwable throwable) {
                ErrorMsgTip.showMsg("0");
                finish();
            }
        });
    }
}
