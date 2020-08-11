package com.bubing.android.ui.tabbar;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bubing.android.BR;
import com.bubing.android.R;
import com.bubing.android.databinding.ActivityTabbarBinding;
import com.bubing.android.ui.tabbar.fragment.TabBar1Fragment;
import com.bubing.android.ui.tabbar.fragment.TabBar2Fragment;
import com.bubing.android.ui.tabbar.fragment.TabBar3Fragment;
import com.bubing.android.ui.tabbar.fragment.TabBar4Fragment;
import com.bubing.mvvm.base.BaseActivity;
import com.bubing.mvvm.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

/**
 * @ClassName: TabBarActivity
 * @Description: 底部tab按钮的例子
 * @Author: Bubing
 * @Date: 2020/8/4 1:08 PM
 * 所有例子仅做参考,理解如何使用才最重要。
 */
public class TabBarActivity extends BaseActivity<ActivityTabbarBinding, BaseViewModel> {
    private List<Fragment> mFragments;

    @Override
    public int initContentView(Bundle saveInstanceState) {
        return R.layout.activity_tabbar;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initData() {
        super.initData();
        //初始化Fragment
        initFragment();
        //初始化底部Button
        initBottomTab();
    }

    @Override
    public BaseViewModel initViewModel() {
        return super.initViewModel();
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
    }

    private void initFragment() {
        mFragments = new ArrayList<>();
        mFragments.add(new TabBar1Fragment());
        mFragments.add(new TabBar2Fragment());
        mFragments.add(new TabBar3Fragment());
        mFragments.add(new TabBar4Fragment());
        //默认选中第一个
        commitAllowingStateLoss(0);
    }

    private void initBottomTab() {
        NavigationController navigationController = binding.pagerBottomTab.material()
                .addItem(R.mipmap.ic_launcher, "应用")
                .addItem(R.mipmap.ic_launcher, "工作")
                .addItem(R.mipmap.ic_launcher, "消息")
                .addItem(R.mipmap.ic_launcher, "我的")
                .setDefaultColor(ContextCompat.getColor(this, R.color.textColorVice))
                .build();
        //底部按钮的点击事件监听
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.frameLayout, mFragments.get(index));
//                transaction.commitAllowingStateLoss();
                commitAllowingStateLoss(index);
            }

            @Override
            public void onRepeat(int index) {
            }
        });
    }

    private void commitAllowingStateLoss(int position) {
        hideAllFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(position + "");
        if (currentFragment != null) {
            transaction.show(currentFragment);
        } else {
            currentFragment = mFragments.get(position);
            transaction.add(R.id.frameLayout, currentFragment, position + "");
        }
        transaction.commitAllowingStateLoss();
    }

    //隐藏所有Fragment
    private void hideAllFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i < mFragments.size(); i++) {
            Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(i + "");
            if (currentFragment != null) {
                transaction.hide(currentFragment);
            }
        }
        transaction.commitAllowingStateLoss();
    }
}
