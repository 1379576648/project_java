package com.trkj.project_java.config.dto.domain;

import lombok.Data;

@Data
public class Paging {
    private Integer currentPage;
    private Integer pageSize;
    private String search;
}
