package crazysheep.io.scanner.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.net.Callback;
import crazysheep.io.scanner.net.Entity.LoginEntity;
import crazysheep.io.scanner.net.O2OService;

/**
 * 测试界面
 *
 * Created by yang.li on 2016/12/3.
 */
public class LabActivity extends AppCompatActivity {

    O2OService mockService;

    @BindView(R.id.result_tv) TextView resultTv;
    @BindView(R.id.test_btn) Button testBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab);
        ButterKnife.bind(this);

        mockService = new O2OService();
    }

    @OnClick(R.id.test_btn)
    void requestGist() {
        testBtn.setEnabled(false);
        resultTv.setText("开始请求...");
        mockService.Login("terminal", "123456", new Callback<LoginEntity>() {
            @Override
            public void onSuccess(LoginEntity loginEntity) {
                System.out.println(">>>>登录成功~");
            }

            @Override
            public void onFailed(Throwable throwable) {
                System.out.println(">>>>登录失败~");
            }
        });
//        mockService.gist("c2a7c39532239ff261be",
//                new Callback<GistEntity>() {
//                    @Override
//                    public void onComplete() {
//                        testBtn.setEnabled(false);
//                    }
//
//                    @Override
//                    public void onSuccess(GistEntity gistEntity) {
//                        testBtn.setEnabled(true);
//                        resultTv.setText(String.format("请求成功, gist: %s", gistEntity));
//                    }
//
//                    @Override
//                    public void onFailed(Throwable throwable) {
//                        testBtn.setEnabled(true);
//                        resultTv.setText(String.format("请求失败: error: %s", throwable));
//                    }
//                });
    }
}
