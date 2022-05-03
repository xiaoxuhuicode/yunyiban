package com.xxh.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页公共返回对象
 * @author xxh
 * @since 2022/5/3 20:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespPageBean {
    private Long total;
    private List<?> data;
}
