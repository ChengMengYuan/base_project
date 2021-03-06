package com.cmy.base_project.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.cmy.base_project.R;
import com.cmy.base_project.app.BaseApplication;

/**
 * 文 件 名: BaseActivity<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/4/27 20:51<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:所有Activity的父类,新创建的Activity都应该继承此类<p>
 */
public class MainActivity extends BaseActivity {


    /**
     * [绑定布局]
     *
     * @return 布局文件
     */
    @Override
    public int setResourcesID() {
        return 0;
    }

    /**
     * [初始化控件]
     */
    @Override
    public void initView() {

    }

    /**
     * [初始化数据]
     */
    @Override
    public void initData() {

    }

    /**
     * [业务操作]
     *
     * @param context 上下文
     */
    @Override
    public void doBusiness(Context context) {

    }

    /**
     * 重写点击事件,防止快速点击
     *
     * @param view 被点击的view
     */
    @Override
    public void widgetClick(View view) {

    }
}
