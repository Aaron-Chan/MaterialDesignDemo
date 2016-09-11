package aaronchan.materialdesigndemo.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import aaronchan.materialdesigndemo.R;
import aaronchan.materialdesigndemo.utils.ThemeUtil;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CollapsingActivity extends AppCompatActivity {

    @BindView(R.id.collapsingTool)
    CollapsingToolbarLayout mCollapsingTool;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtil.sTheme = ThemeUtil.NO_TITLE_THEME;
        ThemeUtil.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_collapsing);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        mCollapsingTool.setTitle("title");

    }
}
