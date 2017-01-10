package crazysheep.io.scanner.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import crazysheep.io.scanner.R;
import crazysheep.io.scanner.adapter.MenuAdapter;

public class HomeActivity extends BaseTitleActivity {


    String[] menus = {"入库", "出库", "商品信息查询", "库存盘点", "移位操作"};
    @BindView(R.id.gridview)
    GridView gridview;
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackEnable(false);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
    }

    public void initView() {
        adapter = new MenuAdapter(menus, this);
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(HomeActivity.this, RuKuListActivity.class).putExtra("isRuKu",true));
                        break;
                    case 1:
                        startActivity(new Intent(HomeActivity.this, RuKuListActivity.class).putExtra("isRuKu",false));
                        break;
                    case 2:
                        startActivity(new Intent(HomeActivity.this, SearchGoodsActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(HomeActivity.this, CheckListActivity.class));
                        break;
                    case 4:
                        break;
                }
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.test_lab: {
                finish();
                startActivity(new Intent(this,MainActivity.class));
            }
        }
        return true;
    }
}
