package crazysheep.io.scanner.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.net.Callback;
import crazysheep.io.scanner.net.Entity.CheckEntity;
import crazysheep.io.scanner.net.O2OService;
import crazysheep.io.scanner.utils.ErrorMsgTip;
import crazysheep.io.scanner.utils.User;

public class DisplacementActivity extends BaseTitleActivity {

    @BindView(R.id.edit_old)
    EditText editOld;
    @BindView(R.id.edit_goods)
    EditText editGoods;
    @BindView(R.id.edit_new)
    EditText editNew;
    @BindView(R.id.button)
    Button button;
    O2OService mO2OService;
    @BindView(R.id.button_clear)
    Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displacement);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        mO2OService = new O2OService();
        editOld.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND || actionId == EditorInfo.IME_ACTION_DONE || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                    editGoods.setFocusable(true);
                }
                return false;
            }
        });
        editGoods.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND || actionId == EditorInfo.IME_ACTION_DONE || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                    editNew.setFocusable(true);
                }
                return false;
            }
        });
        editNew.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND || actionId == EditorInfo.IME_ACTION_DONE || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                    button.setFocusable(true);
                }
                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(editOld.getText().toString().isEmpty()
//                        ||editGoods.getText().toString().isEmpty()
//                        ||editNew.getText().toString().isEmpty()){
//                    ErrorMsgTip.showMsg();
//                }

            }
        });
    }

    @OnClick({R.id.button, R.id.button_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                move();
                break;
            case R.id.button_clear:
                editNew.setText("");
                editGoods.setText("");
                editOld.setText("");
                editOld.requestFocus();
                break;
        }
    }
    public void move(){
        mO2OService.Move(editOld.getText().toString(), editGoods.getText().toString(), editNew.getText().toString(), User.userinfo.getData().getUserId() + "", new Callback<CheckEntity>() {
            @Override
            public void onSuccess(CheckEntity checkEntity) {
                if (checkEntity.isSuccess()) {
                    Toast.makeText(DisplacementActivity.this, R.string.move_success, Toast.LENGTH_SHORT).show();
                    editNew.setText("");
                    editGoods.setText("");
                    editOld.setText("");
                    editOld.requestFocus();
                } else
                    ErrorMsgTip.showMsg(checkEntity.getErrCode(), checkEntity.getErrMsg());
            }

            @Override
            public void onFailed(Throwable throwable) {
                ErrorMsgTip.showMsg(ErrorMsgTip.ERR_NOINTERNET);
            }
        });
    }
}
