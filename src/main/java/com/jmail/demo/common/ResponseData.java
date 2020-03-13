package com.jmail.demo.common;

import java.io.Serializable;

/**
 * 统一返回实体
 * <p>Create Time: 2019年06月25日 13:59  </p>
 * <p>@author zhangxs7  </p>
 **/
public class ResponseData<T> implements Serializable {
    private String code;
    private String msg;
    private T data;

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

    public ResponseData code(String code) {
        this.code = code;
        return this;
    }

    public ResponseData msg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResponseData data(T data) {
        this.data = data;
        return this;
    }

    public static ResponseData success(Object data){
        return new ResponseData().code(CodeEnum.success.getCode()).msg(CodeEnum.success.getMsg()).data(data);
    }

    public static ResponseData error(){
        return new ResponseData().code(CodeEnum.error.getCode()).msg(CodeEnum.error.getMsg()).data("");
    }

    public static ResponseData error(String errorCode, String errorMsg){
        return new ResponseData().code(errorCode).msg(errorMsg).data("");
    }


    /**
     * 错误码
     */
    public enum CodeEnum{

        /**
         * 成功
         */
        success("200","SUCCESS"),
        /**
         * 失败
         */
        error("1010","ERROR");

        private String code;
        private String msg;

        private CodeEnum(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
