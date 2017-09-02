package com.example.jqorz.test1.mvp.delegate.activity;


import com.example.jqorz.test1.mvp.MvpView;
import com.example.jqorz.test1.mvp.delegate.BaseDelegateCallback;
import com.example.jqorz.test1.mvp.delegate.MvpInternalDelegate;
import com.example.jqorz.test1.mvp.presenters.MvpPresenter;

/**
 * Created by jqorz on 2017/8/28.
 * 实现了ActivityDelegate，在生命周期里控制Presenter与MvpView：
 * 当Activity执行到各个生命周期时，这里会执行对应的生命周期
 */

public class ActivityDelegateImp<P extends MvpPresenter, V extends MvpView> implements ActivityDelegate {
    private BaseDelegateCallback<P, V> basemvpDelegateCallback;
    private MvpInternalDelegate<P, V> mvpInternalDelegate;

    //传入BaseDelegateCallback 去控制Presenter
    public ActivityDelegateImp(BaseDelegateCallback<P, V> basemvpDelegateCallback) {
        if (basemvpDelegateCallback == null)
            throw new NullPointerException("the basemvpDelegateCallback in ActivityDelegateImpn is null");
        this.basemvpDelegateCallback = basemvpDelegateCallback;
        mvpInternalDelegate = new MvpInternalDelegate<>(this.basemvpDelegateCallback);

    }

    @Override
    public void onCreate() {
        mvpInternalDelegate.createPresenter();
        mvpInternalDelegate.attachView();

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        mvpInternalDelegate.detachView();
    }
}
