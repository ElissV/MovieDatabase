package com.example.demo.domain.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ReviewFormModel {

    @NotNull
    private Long filmId;

    @NotNull
    private Long reviewTypeId;

    @NotNull
    private String text;

}
