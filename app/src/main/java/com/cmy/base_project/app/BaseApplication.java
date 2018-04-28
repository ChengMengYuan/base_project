package com.cmy.base_project.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import okhttp3.OkHttpClient;


/**
 * 文 件 名: BaseApplication<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/4/27 16:33<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明: BaseApplication类是为了那些需要保存全局变量的类<p>
 */
public class BaseApplication extends Application {
    private static BaseApplication instance;
    private static Context mContext;
    /**
     * 包含所有Activity的集合,在BaseActivity中进行添加,在MainActivity的退出APP方法中销毁
     */
    public static List<Object> activities = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //某些库初始化的操作可以放在这里，例如GreenDao和Fresco等等
        /*初始化Fresco*/
        Fresco.initialize(this);
    }

    /**
     * 获取单例模式中唯一的MyApplication实例
     */
    public static BaseApplication getInstance() {
        if (instance == null) {
            instance = new BaseApplication();
        }
        return instance;
    }

    /**
     * 添加activity到容器中
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (!activities.contains(activity)) {
            activities.contains(activity);
        }
    }

    /**
     * 退出App时调用该方法
     * 遍历所有activity并且finish。
     */
    public void destory() {
        for (Object activity : activities) {
            ((Activity) activity).finish();
        }
        System.exit(0);
    }
}
