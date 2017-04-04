package com.clsaa.blog.gateway.zuul.response;

import org.springframework.http.HttpStatus;

/**
 * Created by eggyer on 2017/3/17.
 */
public class ResultObj {
    private Meta meta;
    private Object data;
    private PagerResult pagerResult;

    public ResultObj() {}

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public PagerResult getPagerResult() {
        return pagerResult;
    }

    public void setPagerResult(PagerResult pagerResult) {
        this.pagerResult = pagerResult;
    }


    /**
     * <p>自定义错误信息返回</p>
     * @param code
     * @param msg
     * @return
     */
    public static ResultObj errorWithMsg(Integer code,String msg){
        ResultObj resultObj = new ResultObj();
        Meta meta = new Meta();
        meta.setResult(false);
        meta.setCode(code);
        meta.setMsg(msg);
        resultObj.setMeta(meta);
        return resultObj;
    }


    /**
     * <p>自定义错误信息返回</p>
     * @param code
     * @param msg
     * @param log
     * @return
     */
    public static ResultObj errorWithLog(Integer code,String msg,String log){
        ResultObj resultObj = new ResultObj();
        Meta meta = new Meta();
        meta.setResult(false);
        meta.setCode(code);
        meta.setMsg(msg);
        meta.setLog(log);
        resultObj.setMeta(meta);
        return resultObj;
    }

    /**
     * <p>返回数据</p>
     * @param msg
     * @param data
     * @return
     */
    public static ResultObj successWithData(String msg,Object data){
        ResultObj resultObj = new ResultObj();
        Meta meta = new Meta();
        meta.setResult(true);
        meta.setCode(HttpStatus.OK.value());
        meta.setMsg(msg);
        resultObj.setMeta(meta);
        resultObj.setData(data);
        return resultObj;
    }

    /**
     * <p>返回数据</p>
     * @param msg
     * @param data
     * @return
     */
    public static ResultObj successWithData(String msg,String log,Object data){
        ResultObj resultObj = new ResultObj();
        Meta meta = new Meta();
        meta.setResult(true);
        meta.setCode(200);
        meta.setMsg(msg);
        meta.setLog(log);
        resultObj.setMeta(meta);
        resultObj.setData(data);
        return resultObj;
    }

}
