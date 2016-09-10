package aaronchan.materialdesigndemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import aaronchan.materialdesigndemo.R;
import aaronchan.materialdesigndemo.fragment.CardFragment;
import aaronchan.materialdesigndemo.fragment.RecycleListFragment;
import aaronchan.materialdesigndemo.fragment.TitleFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TabActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tabs)
    TabLayout mTabs;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mTabs.addTab(mTabs.newTab().setText("Tab1"));
        mTabs.addTab(mTabs.newTab().setText("Tab2"));
        mTabs.addTab(mTabs.newTab().setIcon(R.mipmap.ic_launcher));
        setUpViewPager();
        mTabs.setupWithViewPager(mViewpager);
    }

    private void setUpViewPager() {
        TabFragmentViewPagerAdapter tabFragmentViewPagerAdapter = new TabFragmentViewPagerAdapter(getSupportFragmentManager());
        tabFragmentViewPagerAdapter.addFragment(new RecycleListFragment(), "List");
        tabFragmentViewPagerAdapter.addFragment(new TitleFragment(), "Title");
        tabFragmentViewPagerAdapter.addFragment(new CardFragment(), "Card");
        mViewpager.setAdapter(tabFragmentViewPagerAdapter);
    }

    static final class TabFragmentViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList;
        private List<String> mTitleList;

        public TabFragmentViewPagerAdapter(FragmentManager fm) {
            super(fm);
            mFragmentList = new ArrayList<>();
            mTitleList = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }
    }


}
