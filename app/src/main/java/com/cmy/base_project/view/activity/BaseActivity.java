package com.cmy.base_project.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.cmy.base_project.app.BaseApplication;

/**
 * 文 件 名: BaseActivity<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/4/27 16:51<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:所有Activity的父类,新创建的Activity都应该继承此类<p>
 * {@link #widgetClick(View)} ()方法等同于{@link #onClick(View)}方法,实现了防止快速点击<p>
 * {@link #showInputMethod()}方法可以显示软键盘<p>
 * {@link #hideSoftInput()}方法可以隐藏软键盘<p>
 * {@link #initView()}方法用来初始化空间<p>
 * {@link #initData()}方法用来初始化数据<p>
 * {@link #doBusiness(Context)}方法用来实现业务逻辑<p>
 * {@link #openActivity(Class)}&{@link #openActivityAndCloseThis(Class)}方法用来实现界面跳转<p>
 */
public abstract class BaseActivity extends FragmentActivity
        implements View.OnClickListener{
    /**
     * context
     */
    protected Context context;
    /**
     * TAG
     */
    protected final String TAG = this.getClass().getSimpleName();
    /**
     * 当第一次调用一个Activity就会执行onCreate方法
     *
     * @param savedInstanceState Bundle
     * @param persistentState    PersistableBundle
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState,
                         @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        BaseApplication.getInstance().addActivity(this);
        context = this;
    }

    /**
     * 当Activity处于可见状态的时候就会调用onStart方法
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * 当Activity可以得到用户焦点的时候就会调用onResume方法
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * 当Activity被遮挡住的时候就会调用onPause方法
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * 当Activity处于不可见状态的时候就会调用onStop方法
     */
    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 当Activity没有被销毁的时候重新调用这个Activity就会调用onRestart方法
     */
    @Override
    protected void onRestart() {
        super.onRestart();
    }

    /**
     * 当Activity被销毁时会调用onDestroy方法
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initView();
        initData();
        doBusiness(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initView();
        initData();
        doBusiness(this);
    }

    /**
     * [初始化控件]
     */
    protected abstract void initView();

    /**
     * [初始化数据]
     */
    protected abstract void initData();

    /**
     * [业务操作]
     *
     * @param mContext
     */
    protected abstract void doBusiness(Context mContext);

    /**
     * View点击事件(防止快速点击引起的Bug)
     **/
    protected abstract void widgetClick(View view);

    @Override
    public void onClick(View view) {
        if (fastClick())
            widgetClick(view);
    }

    /**
     * [防止快速点击]
     *
     * @return lastClick
     */
    private boolean fastClick() {
        long lastClick = 0;
        if (System.currentTimeMillis() - lastClick <= 1000) {
            return false;
        }
        lastClick = System.currentTimeMillis();
        return true;
    }

    /**
     * [点击软键盘之外的空白处，隐藏软件盘]
     *
     * @param ev MotionEvent
     * @return onTouchEvent
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        return getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev);
    }

    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return !(event.getX() > left) || !(event.getX() < right)
                    || !(event.getY() > top) || !(event.getY() < bottom);
        }
        return false;
    }

    /**
     * [隐藏软件盘]
     */
    protected void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null) {
            if (imm != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    /**
     * [显示软键盘]
     */
    protected void showInputMethod() {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.showSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    /********************** activity跳转 **********************************/
    public void openActivity(Class<?> targetActivityClass) {
        openActivity(targetActivityClass, null);
    }

    public void openActivity(Class<?> targetActivityClass, Bundle bundle) {
        Intent intent = new Intent(this, targetActivityClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    public void openActivityAndCloseThis(Class<?> targetActivityClass) {
        openActivity(targetActivityClass);
        this.finish();
    }

    public void openActivityAndCloseThis(Class<?> targetActivityClass, Bundle bundle) {
        openActivity(targetActivityClass, bundle);
        this.finish();
    }
}
