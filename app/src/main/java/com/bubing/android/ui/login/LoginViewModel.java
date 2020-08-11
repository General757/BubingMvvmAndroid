package com.bubing.android.ui.login;

import android.app.Application;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.bubing.android.data.RepositoryModel;
import com.bubing.android.ui.main.MainActivity;
import com.bubing.mvvm.base.BaseViewModel;
import com.bubing.mvvm.bus.event.SingleLiveEvent;
import com.bubing.mvvm.binding.command.BindingAction;
import com.bubing.mvvm.binding.command.BindingCommand;
import com.bubing.mvvm.binding.command.BindingConsumer;
import com.bubing.mvvm.utils.RxUtils;
import com.bubing.mvvm.utils.ToastUtils;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @ClassName: LoginViewModel
 * @Description: java类作用描述
 * @Author: Bubing
 * @Date: 2020/8/3 2:46 PM
 */
public class LoginViewModel extends BaseViewModel<RepositoryModel> {
    //用户名的绑定
    public ObservableField<String> userName = new ObservableField<String>("");
    //密码的绑定
    public ObservableField<String> password = new ObservableField<String>("");
    //用户名清除按钮的显示隐藏绑定
    public ObservableInt clearBtnVisibility = new ObservableInt();
    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public class UIChangeObservable {//密码开关观察者
        public SingleLiveEvent<Boolean> pSwitchEvent = new SingleLiveEvent<Boolean>();
    }

    public LoginViewModel(@NonNull Application application, RepositoryModel repositoryModel) {
        super(application, repositoryModel);
        //从本地取得数据绑定到View层
        userName.set(model.getUserName());
        password.set(model.getPassword());
    }

    //清除用户名的点击事件, 逻辑从View层转换到ViewModel层
    public BindingCommand clearUserNameOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            userName.set("");
        }
    });
    //密码显示开关  (你可以尝试着狂按这个按钮,会发现它有防多次点击的功能)
    public BindingCommand passwordShowSwitchOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //让观察者的数据改变,逻辑从ViewModel层转到View层，在View层的监听则会被调用
            uc.pSwitchEvent.setValue(uc.pSwitchEvent.getValue() == null || !uc.pSwitchEvent.getValue());
        }
    });
    //用户名输入框焦点改变的回调事件
    public BindingCommand<Boolean> onFocusChangeCommand = new BindingCommand<Boolean>(new BindingConsumer<Boolean>() {
        @Override
        public void call(Boolean hasFocus) {
            clearBtnVisibility.set(hasFocus ? View.VISIBLE : View.INVISIBLE);
        }
    });
    //忘记密码按钮的点击事件
    public BindingCommand psdOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showShort("忘记密码-点击事件");
        }
    });    //登录按钮的点击事件
    public BindingCommand loginOnClickCommand = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            login();
        }
    });

    /**
     * 网络模拟一个登陆操作
     **/
    private void login() {
        if (TextUtils.isEmpty(userName.get())) {
            ToastUtils.showShort("请输入账号！");
            return;
        }
        if (TextUtils.isEmpty(password.get())) {
            ToastUtils.showShort("请输入密码！");
            return;
        }

        //RaJava模拟登录
        addSubscribe(model.login()
                .compose(RxUtils.schedulersTransformer()) //线程调度
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        showDialog();
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        dismissDialog();
                        //保存账号密码
                        model.saveUserName(userName.get());
                        model.savePassword(password.get());
                        //进入DemoActivity页面
                        startActivity(MainActivity.class);
                        //关闭页面
                        finish();
                    }
                }));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
