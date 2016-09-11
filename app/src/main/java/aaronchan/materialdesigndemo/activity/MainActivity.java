package aaronchan.materialdesigndemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import aaronchan.materialdesigndemo.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_theme)
    Button mBtnTheme;
    @BindView(R.id.btn_toolbar)
    @Nullable
    Button mBtnToolbar;
    @BindView(R.id.btn_tab)
    Button mBtnTab;
    @BindView(R.id.btn_navigation)
    Button mBtnNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Optional
    @OnClick({R.id.btn_theme, R.id.btn_toolbar, R.id.btn_tab, R.id.btn_navigation})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_theme:
                intent = new Intent(this, ThemeActivity.class);
                break;
            case R.id.btn_toolbar:
                intent = new Intent(this, ToolBarActivity.class);
                break;
            case R.id.btn_tab:
                intent = new Intent(this, TabActivity.class);
                break;
            case R.id.btn_navigation:
                intent = new Intent(this, NavigatorActivity.class);
                break;
        }
        startActivity(intent);
    }
}
