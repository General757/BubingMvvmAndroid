package com.bubing.android.ui.main;

import android.Manifest;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bubing.android.BR;
import com.bubing.android.R;
import com.bubing.android.app.AppViewModelFactory;
import com.bubing.android.databinding.ActivityMainBinding;
import com.bubing.mvvm.base.BaseActivity;
import com.bubing.mvvm.http.DownLoadManager;
import com.bubing.mvvm.http.download.ProgressCallBack;
import com.bubing.mvvm.utils.ToastUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;
import okhttp3.ResponseBody;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int initContentView(Bundle saveInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

//    @Override
//    public MainViewModel initViewModel() {
//        AppViewModelFactory factory = AppViewModelFactory.getInstance(getApplication());
//        return ViewModelProviders.of(this, factory).get(MainViewModel.class);
//    }

    @Override
    public void initViewObservable() {
        //注册监听相机权限的请求
        viewModel.requestCameraPermissions.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                requestCameraPermissions();
            }
        });
        //注册文件下载的监听
        viewModel.loadUrlEvent.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String url) {
                downFile(url);
            }
        });
    }

    /**
     * 请求相机权限
     */
    private void requestCameraPermissions() {
        //请求打开相机权限
        RxPermissions rxPermissions = new RxPermissions(MainActivity.this);
        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            ToastUtils.showShort("相机权限已经打开，直接跳入相机");
                        } else {
                            ToastUtils.showShort("权限被拒绝");
                        }
                    }
                });
    }

    //文件下载
    private void downFile(String url) {
        String destFileDir = getApplication().getCacheDir().getPath();
        String destFileName = System.currentTimeMillis() + ".apk";
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("正在下载...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        DownLoadManager.getInstance().load(url, new ProgressCallBack<ResponseBody>(destFileDir, destFileName) {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
                progressDialog.dismiss();
            }

            @Override
            public void onSuccess(ResponseBody responseBody) {
                ToastUtils.showShort("文件下载完成！");
            }

            @Override
            public void progress(final long progress, final long total) {
                progressDialog.setMax((int) total);
                progressDialog.setProgress((int) progress);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                ToastUtils.showShort("文件下载失败！");
                progressDialog.dismiss();
            }
        });
    }
}
