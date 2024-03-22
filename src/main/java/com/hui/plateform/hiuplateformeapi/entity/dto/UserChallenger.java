package com.hui.plateform.hiuplateformeapi.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserChallenger {
    private String email;
    private String username;
    private String profilePicture;
    private String idTeam;
}
