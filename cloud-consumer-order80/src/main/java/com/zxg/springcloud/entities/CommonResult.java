package com.zxg.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaogang.zhang
 * @date 2021/2/17
 * @description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult <T>{
    //404,200
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
