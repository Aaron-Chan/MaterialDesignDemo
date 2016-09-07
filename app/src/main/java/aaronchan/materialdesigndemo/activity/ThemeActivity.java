package aaronchan.materialdesigndemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import aaronchan.materialdesigndemo.R;
import aaronchan.materialdesigndemo.utils.ThemeUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ThemeActivity extends AppCompatActivity {

    @BindView(R.id.btn_custom_theme1)
    Button mBtnCustomTheme1;
    @BindView(R.id.btn_custom_theme2)
    Button mBtnCustomTheme2;
    @BindView(R.id.btn_default_theme)
    Button mBtnDefaultTheme;
    @BindView(R.id.btn_dark_theme)
    Button mBtnDarkTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtil.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_theme);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_custom_theme1, R.id.btn_custom_theme2, R.id.btn_default_theme, R.id.btn_dark_theme})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_custom_theme1:
                ThemeUtil.changeTheme(this, ThemeUtil.CUSTOM_THEME1);
                break;
            case R.id.btn_custom_theme2:
                ThemeUtil.changeTheme(this, ThemeUtil.CUSTOM_THEME2);
                break;
            case R.id.btn_default_theme:
                ThemeUtil.changeTheme(this, ThemeUtil.DEFAULT_THEME);
                break;
            case R.id.btn_dark_theme:
                ThemeUtil.changeTheme(this, ThemeUtil.DARK_THEME);
                break;
        }
    }


}
