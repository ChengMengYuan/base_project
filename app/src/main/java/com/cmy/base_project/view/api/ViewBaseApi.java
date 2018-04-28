package com.cmy.base_project.view.api;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/**
 * 文 件 名: ViewBaseApi<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/4/28 15:39<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:<p>
 */
public interface ViewBaseApi extends View.OnClickListener {

    /**
     * [绑定布局]
     *
     * @return 布局文件
     */
    int setResourcesID();

    /**
     * [初始化控件]
     */
    void initView();

    /**
     * [初始化数据]
     */
    void initData();

    /**
     * [业务操作]
     *
     * @param context 上下文
     */
    void doBusiness(Context context);

    /**
     * 重写点击事件,防止快速点击
     *
     * @param view 被点击的view
     */
    void widgetClick(View view);

    /**
     * 判断是否是快速点击
     *
     * @return boolean
     */
    boolean fastClick();

//    /**
//     * 设置返回点击事件
//     */
//    void setBack(View backView);

    /**
     * @param targetActivityClass 目标activity
     */
    void openActivity(Class<?> targetActivityClass);

    /**
     * @param targetActivityClass 目标activity
     */
    void openActivity(Class<?> targetActivityClass, Bundle bundle);

    /**
     * @param targetActivityClass 目标activity
     */
    void openActivityAndCloseThis(Class<?> targetActivityClass);

    /**
     * @param targetActivityClass 目标activity
     */
    void openActivityAndCloseThis(Class<?> targetActivityClass, Bundle bundle);
}
