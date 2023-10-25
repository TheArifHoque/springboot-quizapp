package com.arifhoque.quizapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Question {
    @Id
    @Column(name = "ques_id")
    private Integer quesId;
    @Column(name = "title")
    private String title;
    @Column(name = "option_a")
    private String optionA;
    @Column(name = "option_b")
    private String optionB;
    @Column(name = "option_c")
    private String optionC;
    @Column(name = "ans")
    private Integer ans; //Actual answer
    @Column(name = "chose")
    private Integer chose; //User answer
}
