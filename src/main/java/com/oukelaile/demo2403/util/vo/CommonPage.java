package com.oukelaile.demo2403.util.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonPage<T> {

    /**
     * 当前页码
     */
    private Long current;

    /**
     * 每页显示的记录数
     */
    private Long pageSize;
    /**
     * 总页数
     */
    private Long totalPage;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 分页数据列表
     */
    private List<T> list;

}
