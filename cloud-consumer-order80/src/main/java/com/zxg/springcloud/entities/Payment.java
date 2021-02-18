package com.zxg.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xiaogang.zhang
 * @date 2021/2/17
 * @description
 */
@Data
//全参构造函数
@AllArgsConstructor
//无参构造函数
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
