package com.oukelaile.vebAdmin.utils.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class List<T> {

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
    private java.util.List<T> list;

}
