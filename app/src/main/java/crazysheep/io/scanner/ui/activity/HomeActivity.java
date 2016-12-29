package crazysheep.io.scanner.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

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
                startActivity(new Intent(this,CheckListActivity.class));
                break;
            case R.id.yiwei:
                break;
            case R.id.chaxun:
                startActivity(new Intent(this, SearchGoodsActivity.class));
                break;
        }
    }

    private static boolean mBackKeyPressed = false;//记录是否有首次按键

    @Override
    public void onBackPressed() {
        if (!mBackKeyPressed) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mBackKeyPressed = true;
            new Timer().schedule(new TimerTask() {//延时两秒，如果超出则擦错第一次按键记录
                @Override
                public void run() {
                    mBackKeyPressed = false;
                }
            }, 2000);
        } else {//退出程序
            this.finish();
            System.exit(0);
        }
    }
}
