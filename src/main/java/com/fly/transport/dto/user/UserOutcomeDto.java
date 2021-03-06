package com.fly.transport.dto.user;

import com.fly.transport.dto.general.IdCreatedUpdatedDeletedDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserOutcomeDto extends IdCreatedUpdatedDeletedDto {

    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phone;
}
