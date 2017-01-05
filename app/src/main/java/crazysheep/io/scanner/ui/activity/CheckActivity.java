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
import crazysheep.io.scanner.net.Entity.CheckEntity;
import crazysheep.io.scanner.net.Entity.StartCheckEntity;
import crazysheep.io.scanner.net.O2OService;
import crazysheep.io.scanner.utils.User;

public class CheckActivity extends BaseTitleActivity {

    @BindView(R.id.edittext)
    EditText edittext;
    int taskId = -1;
    O2OService o2OService;
    @BindView(R.id.name)
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        ButterKnife.bind(this);
        init();
    }
    public void init(){
        taskId = getIntent().getIntExtra("taskId", -1);
        System.out.println(">>>>taskid"+taskId);
        o2OService = new O2OService();
        o2OService.startCheck(taskId, User.userinfo.getData().getUserId(), new Callback<StartCheckEntity>() {
            @Override
            public void onSuccess(StartCheckEntity startCheckEntity) {
                if (startCheckEntity.isSuccess())
                    System.out.println(">>>>开启盘点成功");
                else
                    System.out.println(">>>开启盘点失败");
            }

            @Override
            public void onFailed(Throwable throwable) {

            }
        });
        edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                //当actionId == XX_SEND 或者 XX_DONE时都触发
                //或者event.getKeyCode == ENTER 且 event.getAction == ACTION_DOWN时也触发
                //注意，这是一定要判断event != null。因为在某些输入法上会返回null。
                if (actionId == EditorInfo.IME_ACTION_SEND
                        || actionId == EditorInfo.IME_ACTION_DONE
                        || (event != null && KeyEvent.KEYCODE_ENTER == event.getKeyCode() && KeyEvent.ACTION_DOWN == event.getAction())) {
                    //处理事件
                    onScan();
                }
                return false;
            }
        });
    }
    public void onScan() {
        o2OService.CheckGoods(taskId, edittext.getText().toString(), new Callback<CheckEntity>() {
            @Override
            public void onSuccess(CheckEntity checkEntity) {
                if(checkEntity.isSuccess()){
                    Toast.makeText(CheckActivity.this,"盘点成功",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(CheckActivity.this,"盘点失败",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailed(Throwable throwable) {

            }
        });
    }
}
