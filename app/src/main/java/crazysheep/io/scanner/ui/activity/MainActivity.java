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
import crazysheep.io.scanner.net.GitHubService;

public class MainActivity extends BaseTitleActivity {

    @BindView(R.id.account_et)
    EditText accountEt;
    @BindView(R.id.password_et)
    EditText passwordEt;
    @BindView(R.id.login)
    Button login;

    GitHubService mGitHubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setBackEnable(false);
        mGitHubService=new GitHubService();
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

    @OnClick(R.id.login)
    public void onClick() {
        final ProgressDialog dialog=ProgressDialog.show(this,"提示","登录中...");
        mGitHubService.Login(accountEt.getText().toString(), passwordEt.getText().toString(), new Callback<LoginEntity>() {
            @Override
            public void onSuccess(LoginEntity loginEntity) {
                dialog.hide();
                if(loginEntity.isSuccess()){
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                }else
                    Toast.makeText(MainActivity.this,loginEntity.getErrCode()+":"+loginEntity.getErrMsg(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailed(Throwable throwable) {
                dialog.hide();
                Toast.makeText(MainActivity.this,throwable.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
