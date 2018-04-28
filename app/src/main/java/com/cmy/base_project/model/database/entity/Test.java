package com.cmy.base_project.model.database.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 文 件 名: Test<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/4/28 15:18<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:<p>
 */
@Entity
public class Test {
    private String string;

    @Generated(hash = 874553793)
    public Test(String string) {
        this.string = string;
    }

    @Generated(hash = 372557997)
    public Test() {
    }

    public String getString() {
        return this.string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
