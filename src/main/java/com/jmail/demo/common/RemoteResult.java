package com.jmail.demo.common;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * rpc调用的返回值
 * <p/>
 * 使用泛型，指定返回值的类型和对应的值
 *
 * @author <a href="mailto:winstonvip@gmail.com">winston</a>
 * @version Created by IntelliJ IDEA.
 * Date: 2010-3-17 21:31
 * @since 1.0
 */
public class RemoteResult<T> implements Serializable {
    private boolean success = false; //默认值 false
    private String code;
    private String msg;
    private T data;

    public RemoteResult() {
    }

    public RemoteResult(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoteResult that = (RemoteResult) o;

        if (success != that.success) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (msg != null ? !msg.equals(that.msg) : that.msg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (success ? 1 : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "RemoteResult{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }


    public RemoteResult<T> succ(boolean success) {
        this.success = success;
        return this;
    }

    public RemoteResult<T> code(Object code) {
        if (code == null) {
            this.code = null;
            return this;
        } else {
            this.code = String.valueOf(code);
            return this;
        }
    }

    public RemoteResult<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    public RemoteResult<T> data(T data) {
        this.data = data;
        return this;
    }
}
