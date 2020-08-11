package com.bubing.android.ui.viewpager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.bubing.android.BR;
import com.bubing.android.R;
import com.bubing.mvvm.base.BaseViewModel;
import com.bubing.mvvm.binding.command.BindingCommand;
import com.bubing.mvvm.binding.command.BindingConsumer;
import com.bubing.mvvm.bus.event.SingleLiveEvent;
import com.bubing.mvvm.utils.ToastUtils;

import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * @ClassName: ViewpagerViewModel
 * @Author: Bubing
 * @Date: 2020/8/4 1:05 PM
 * @Description: 所有例子仅做参考, 千万不要把它当成一种标准, 毕竟主打的不是例子, 业务场景繁多, 理解如何使用才最重要。
 */
public class ViewPagerViewModel extends BaseViewModel {
    public SingleLiveEvent<String> itemClickEvent = new SingleLiveEvent<>();

    public ViewPagerViewModel(@NonNull Application application) {
        super(application);
        //模拟3个ViewPager页面
        for (int i = 1; i <= 3; i++) {
            ViewPagerItemViewModel itemViewModel = new ViewPagerItemViewModel(this, "第" + i + "个页面");
            items.add(itemViewModel);
        }
    }

    //给ViewPager添加ObservableList
    public ObservableList<ViewPagerItemViewModel> items = new ObservableArrayList<>();
    //给ViewPager添加ItemBinding
    public ItemBinding<ViewPagerItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_viewpager);
    //给ViewPager添加PageTitle
    public final BindingViewPagerAdapter.PageTitles<ViewPagerItemViewModel> pageTitles = new BindingViewPagerAdapter.PageTitles<ViewPagerItemViewModel>() {
        @Override
        public CharSequence getPageTitle(int position, ViewPagerItemViewModel item) {
            return "条目" + position;
        }
    };
    //ViewPager切换监听
    public BindingCommand<Integer> onPageSelectedCommand = new BindingCommand<>(new BindingConsumer<Integer>() {
        @Override
        public void call(Integer index) {
            ToastUtils.showShort("ViewPager切换：" + index);
        }
    });
}
