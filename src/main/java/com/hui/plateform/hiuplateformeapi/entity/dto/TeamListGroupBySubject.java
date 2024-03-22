package com.hui.plateform.hiuplateformeapi.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamListGroupBySubject {
    private String idSubject;
    private String idTeam;
}
