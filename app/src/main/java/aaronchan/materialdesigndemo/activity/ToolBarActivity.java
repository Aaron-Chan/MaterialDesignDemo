package aaronchan.materialdesigndemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import aaronchan.materialdesigndemo.R;
import aaronchan.materialdesigndemo.utils.ThemeUtil;

public class ToolBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtil.sTheme = ThemeUtil.NO_TITLE_THEME;
        ThemeUtil.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_tool_bar);
        findViewById(R.id.toolbar);
    }
}
