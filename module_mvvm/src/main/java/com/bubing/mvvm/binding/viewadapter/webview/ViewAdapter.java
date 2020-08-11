package com.bubing.mvvm.binding.viewadapter.webview;

import android.text.TextUtils;
import android.webkit.WebView;

import androidx.databinding.BindingAdapter;

/**
 * @ClassName: ViewAdapter
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/4 10:41 AM
 */
public class ViewAdapter {

    @BindingAdapter({"render"})
    public static void loadHtml(WebView webView, final String html) {
        if (!TextUtils.isEmpty(html)) {
            webView.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
        }
    }
}
