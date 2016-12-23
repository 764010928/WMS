package crazysheep.io.scanner.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.net.Callback;
import crazysheep.io.scanner.net.Entity.LoginEntity;
import crazysheep.io.scanner.net.O2OService;

public class MainActivity extends BaseTitleActivity {

    @BindView(R.id.account_et)
    EditText accountEt;
    @BindView(R.id.password_et)
    EditText passwordEt;
    @BindView(R.id.login)
    Button login;

    O2OService mO2OService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackEnable(false);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mO2OService =new O2OService();
        accountEt.setText("terminal");
        passwordEt.setText("123456");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.test_lab: {
                startActivity(new Intent(this, LabActivity.class));
            }
        }
        return true;
    }
    ProgressDialog dialog;
    @OnClick(R.id.login)
    public void onClick() {
        dialog=ProgressDialog.show(this,"提示","登录中...");
        mO2OService.Login(accountEt.getText().toString(), passwordEt.getText().toString(), new Callback<LoginEntity>() {
            @Override
            public void onSuccess(LoginEntity loginEntity) {
                dialog.dismiss();
                if(loginEntity.isSuccess()){
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    MainActivity.this.finish();
                }else
                    Toast.makeText(MainActivity.this,loginEntity.getErrCode()+":"+loginEntity.getErrMsg(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailed(Throwable throwable) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this,getString(R.string.net_error),Toast.LENGTH_LONG).show();
            }
        });
    }
}
