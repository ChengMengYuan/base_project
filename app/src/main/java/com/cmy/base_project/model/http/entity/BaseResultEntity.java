package com.cmy.base_project.model.http.entity;

/**
 * 文 件 名: BaseResultEntity<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/4/28 10:37<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:<p>
 */
public class BaseResultEntity<T> {
    /**
     * 判断标示
     */
    private int code;
    /**
     * 提示信息
     */
    private String message;

    /**
     * 显示数据（用户需要关心的数据）
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
