package crazysheep.io.scanner.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crazysheep.io.scanner.R;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.caigou)
    Button caigou;
    @BindView(R.id.mendian)
    Button mendian;
    @BindView(R.id.pandian)
    Button pandian;
    @BindView(R.id.yiwei)
    Button yiwei;
    @BindView(R.id.chaxun)
    Button chaxun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.caigou, R.id.mendian, R.id.pandian, R.id.yiwei, R.id.chaxun})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.caigou:
                break;
            case R.id.mendian:
                break;
            case R.id.pandian:
                break;
            case R.id.yiwei:
                break;
            case R.id.chaxun:
                break;
        }
    }
}
