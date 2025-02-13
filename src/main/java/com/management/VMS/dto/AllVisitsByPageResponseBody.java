package com.management.VMS.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AllVisitsByPageResponseBody {
    private List<VisitDto> visits;

    private Long totalRow;

    private Integer totalPage;

}
