package crazysheep.io.scanner.ui.activity;

import android.os.Bundle;

import crazysheep.io.scanner.R;

public class HomeActivity extends BaseTitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setBackEnable(true);
    }
}
