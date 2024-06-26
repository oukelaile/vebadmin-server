package com.oukelaile.vebAdmin.query.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageQuery implements Serializable {

    private Integer currentPage = 1;

    private Integer pageSize = 10;

}