package com.bubing.android.ui.viewpager;

import androidx.fragment.app.Fragment;

import com.bubing.android.ui.base.BasePagerFragment;
import com.bubing.android.ui.tabbar.fragment.TabBar1Fragment;
import com.bubing.android.ui.tabbar.fragment.TabBar2Fragment;
import com.bubing.android.ui.tabbar.fragment.TabBar3Fragment;
import com.bubing.android.ui.tabbar.fragment.TabBar4Fragment;
import com.bubing.mvvm.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ViewPagerGroupFragment
 * @Author: Bubing
 * @Date: 2020/8/4 1:09 PM
 * @Description: ViewPager+Fragment的实现
 */
public class ViewPagerGroupFragment extends BasePagerFragment {

    @Override
    protected List<Fragment> pagerFragment() {
        List<Fragment> list = new ArrayList<>();
        list.add(new TabBar1Fragment());
        list.add(new TabBar2Fragment());
        list.add(new TabBar3Fragment());
        list.add(new TabBar4Fragment());
        return list;
    }

    @Override
    protected List<String> pagerTitleString() {
        List<String> list = new ArrayList<>();
        list.add("page1");
        list.add("page2");
        list.add("page3");
        list.add("page4");
        return list;
    }
}
