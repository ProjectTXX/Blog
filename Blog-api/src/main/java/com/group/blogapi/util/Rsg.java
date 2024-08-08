package com.group.blogapi.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rsg {
    private String msg;
    private Integer code; // 501数据库出错 502后端逻辑出错 200正常 504服务添加中
    private Object data;

    public Rsg(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public Rsg(Integer code, Object data){
        this.code=code;
        this.data=data;
    }

    public static  Rsg Ok(Object data){
        return new Rsg("请求成功",200,data);
    }

    public static Rsg Sqlerror(){
        return new Rsg("数据库操作失败",501);
    }

    public static Rsg Runerror(){
        return new Rsg("服务器错误",502);
    }

    public static Rsg Imperror(){
        return new Rsg("接口拓展中",504);
    }
}
