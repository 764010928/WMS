package crazysheep.io.scanner.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.adapter.RuKuGoodsAdapter;
import crazysheep.io.scanner.net.Callback;
import crazysheep.io.scanner.net.Entity.RuKuDetailEntity;
import crazysheep.io.scanner.net.O2OService;
import crazysheep.io.scanner.utils.ErrorMsgTip;

public class RuKuDetailsActivity extends BaseTitleActivity {

    @BindView(R.id.ruku_id)
    TextView rukuId;
    @BindView(R.id.ruku_from)
    TextView rukuFrom;
    @BindView(R.id.ruku_to)
    TextView rukuTo;
    @BindView(R.id.tuku_status)
    TextView rukuStatus;
    @BindView(R.id.op)
    TextView op;
    @BindView(R.id.activity_ru_ku_details)
    RelativeLayout activityRuKuDetails;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    List<RuKuDetailEntity.DataBean.ProductsBean> mList = null;
    RuKuGoodsAdapter adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ru_ku_details);
        ButterKnife.bind(this);
        init();
    }

    public void init() {
        mList = new ArrayList<>();
        adapter = new RuKuGoodsAdapter(mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

        String taskid = getIntent().getStringExtra("taskId");
        String code = getIntent().getStringExtra("code");
        O2OService mO2OService = new O2OService();
        mO2OService.getRukuDetail(taskid, code, new Callback<RuKuDetailEntity>() {
            @Override
            public void onSuccess(RuKuDetailEntity ruKuDetailEntity) {
                if (ruKuDetailEntity.isSuccess()) {

                    rukuId.setText(getString(R.string.ru_ku_code,ruKuDetailEntity.getData().getCode()));
                    rukuFrom.setText(ruKuDetailEntity.getData().getFrom());
                    rukuTo.setText(ruKuDetailEntity.getData().getTo());
                    rukuStatus.setText(getString(R.string.ru_ku_status,ruKuDetailEntity.getData().getStatusName()));
                    String ops="";
                    for (int i = 0; i <ruKuDetailEntity.getData().getOperators().size() ; i++) {
                        ops+=ruKuDetailEntity.getData().getOperators().get(i).getName()+" ";
                    }
                    op.setText(getString(R.string.operator,ops));

                    mList.clear();
                    mList.addAll(ruKuDetailEntity.getData().getProducts());
                    adapter.notifyDataSetChanged();
                } else
                    ErrorMsgTip.showMsg(ruKuDetailEntity.getErrCode(), ruKuDetailEntity.getErrMsg());
            }

            @Override
            public void onFailed(Throwable throwable) {

            }
        });
    }
}
