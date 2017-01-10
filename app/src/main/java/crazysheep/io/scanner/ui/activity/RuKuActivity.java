package crazysheep.io.scanner.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.net.Callback;
import crazysheep.io.scanner.net.Entity.RuKuDetailEntity;
import crazysheep.io.scanner.net.O2OService;
import crazysheep.io.scanner.utils.ErrorMsgTip;
import crazysheep.io.scanner.utils.User;

public class RuKuActivity extends BaseTitleActivity {

    @BindView(R.id.ruku_code)
    TextView rukuCode;
    @BindView(R.id.operator)
    TextView operator;
    @BindView(R.id.edittext)
    EditText edittext;
    String taskid,code;
    boolean isRuKu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ru_ku);
        ButterKnife.bind(this);
        init();
    }
    public void init(){
        isRuKu=getIntent().getBooleanExtra("isRuKu",false);
        taskid = getIntent().getStringExtra("taskId");
        code = getIntent().getStringExtra("code");
        rukuCode.setText(getString(isRuKu?R.string.ru_ku_code:R.string.chu_ku_code,code));
        operator.setText(getString(R.string.operator,User.userinfo.getData().getName()));
        edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                    onScan();
                }
                return false;
            }
        });
    }
    public void onScan(){
        O2OService mO2OService=new O2OService();
        mO2OService.scanRuKu(isRuKu,taskid, code, User.userinfo.getData().getUserId()+"", edittext.getText().toString(), new Callback<RuKuDetailEntity>() {
            @Override
            public void onSuccess(RuKuDetailEntity ruKuDetailEntity) {
                if(ruKuDetailEntity.isSuccess())
                    Toast.makeText(RuKuActivity.this,isRuKu?R.string.ruku_success:R.string.chuku_success,Toast.LENGTH_SHORT).show();
                else
                    ErrorMsgTip.showMsg(ruKuDetailEntity.getErrCode(),ruKuDetailEntity.getErrMsg());
            }

            @Override
            public void onFailed(Throwable throwable) {
                ErrorMsgTip.showMsg(ErrorMsgTip.ERR_NOINTERNET);
            }
        });
        edittext.setText("");
    }
}
