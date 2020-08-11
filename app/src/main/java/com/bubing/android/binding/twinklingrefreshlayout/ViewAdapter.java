package com.bubing.android.binding.twinklingrefreshlayout;

import androidx.databinding.BindingAdapter;

import com.bubing.mvvm.binding.command.BindingCommand;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

/**
 * @ClassName: ViewAdapter
 * @Author: Bubing
 * @Date: 2020/8/4 3:02 PM
 * @Description: TwinklingRefreshLayout列表刷新的绑定适配器
 */
public class ViewAdapter {

    @BindingAdapter(value = {"onRefreshCommand", "onLoadMoreCommand"}, requireAll = false)
    public static void onRefreshAndLoadMoreCommand(TwinklingRefreshLayout layout, final BindingCommand onRefreshCommand, final BindingCommand onLoadMoreCommand) {
        layout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                if (onRefreshCommand != null) {
                    onRefreshCommand.execute();
                }
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                if (onLoadMoreCommand != null) {
                    onLoadMoreCommand.execute();
                }
            }
        });
    }
}
