package com.cmy.base_project.model.database.greendao;

import android.content.Context;

/**
 * 文 件 名: GreenDaoManager<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/4/28 10:04<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:数据库管理类<p>
 */
public class GreenDaoManager {
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static volatile GreenDaoManager mInstance = null;

    private GreenDaoManager(Context context) {
        DaoMaster.DevOpenHelper devOpenHelper =
                new DaoMaster.DevOpenHelper(context, "baluche.db", null);
        mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();

    }

    public static GreenDaoManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager(context);
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }
}
