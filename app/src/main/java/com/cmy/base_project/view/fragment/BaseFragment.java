package com.cmy.base_project.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmy.base_project.app.BaseApplication;
import com.cmy.base_project.view.activity.BaseActivity;
import com.cmy.base_project.view.api.ViewBaseApi;

/**
 * 文 件 名: BaseFragment<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/4/27 16:53<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:所有Fragment的父类,新创建的Fragment都应该继承此类<p>
 */
public abstract class BaseFragment extends Fragment
        implements ViewBaseApi {
    protected Context context;
    protected Activity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        context = getContext();
        if (getArguments() != null) {

        }
    }

    public Context getContext() {
        if (activity == null) {
            return BaseApplication.getInstance();
        }
        return activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        doBusiness(context);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context.getApplicationContext();
        activity = (Activity) context;
    }

    /**
     * 重写点击事件,防止快速点击
     *
     * @param view 被点击的view
     */
    @Override
    public abstract void widgetClick(View view);

    @Override
    public void onClick(View view) {
        if (fastClick())
            widgetClick(view);
    }

    public boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    /**
     * @param targetActivityClass 目标activity
     */
    @Override
    public void openActivity(Class<?> targetActivityClass) {

    }

    /**
     * @param targetActivityClass 目标activity
     * @param bundle
     */
    @Override
    public void openActivity(Class<?> targetActivityClass, Bundle bundle) {

    }

    /**
     * @param targetActivityClass 目标activity
     */
    @Override
    public void openActivityAndCloseThis(Class<?> targetActivityClass) {

    }

    /**
     * @param targetActivityClass 目标activity
     * @param bundle
     */
    @Override
    public void openActivityAndCloseThis(Class<?> targetActivityClass, Bundle bundle) {

    }
}
