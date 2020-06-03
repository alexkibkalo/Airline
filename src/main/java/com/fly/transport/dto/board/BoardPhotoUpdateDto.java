package com.fly.transport.dto.board;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BoardPhotoUpdateDto {

    @NotNull
    private String photo;
}
