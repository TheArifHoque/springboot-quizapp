package com.arifhoque.quizapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {
    private Integer quesId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private Integer ans; //Actual answer
    private Integer chose; //User answer
}
