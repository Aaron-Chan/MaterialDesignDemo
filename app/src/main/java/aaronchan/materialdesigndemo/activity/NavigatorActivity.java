package aaronchan.materialdesigndemo.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import aaronchan.materialdesigndemo.R;
import aaronchan.materialdesigndemo.utils.ThemeUtil;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NavigatorActivity extends AppCompatActivity {

    @BindView(R.id.view_navigation)
    NavigationView mViewNavigation;
    @BindView(R.id.drawer)
    DrawerLayout mDrawer;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtil.sTheme = ThemeUtil.NO_TITLE_THEME;
        ThemeUtil.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_navigator);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mViewNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setCheckable(true);
                mDrawer.closeDrawers();
                return true;
            }
        });

    }


    @OnClick(R.id.fab)
    public void onClick() {
        Snackbar.make(mFab, "Hi", Snackbar.LENGTH_SHORT).show();
    }
}
