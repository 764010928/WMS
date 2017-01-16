package crazysheep.io.scanner.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import crazysheep.io.scanner.R;

/**
 * Created by Bing on 2016/12/7.
 */

public class BaseTitleActivity extends BaseActivity {
    Toolbar toolbar;
    boolean backEnable = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View setView(@LayoutRes int id) {
        View titleView = View.inflate(this, R.layout.activity_title, null);
        LinearLayout linearLayout = (LinearLayout) titleView.findViewById(R.id.layout);
        View view = View.inflate(this, id, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.addView(view);
        setContentView(titleView);

        initToolBar();
        if (backEnable) {
            toolbar.setNavigationIcon(R.mipmap.back);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        return titleView;
    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(setView(layoutResID));
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        toolbar.setTitle(title);
    }

    public void setBackEnable(boolean isEnable) {
        backEnable=isEnable;
    }

}
