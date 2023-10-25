package com.arifhoque.quizapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Result {
    @Id
    @GeneratedValue
    @Column(name = "result_id")
    private Integer resultId;
    @Column(name = "username")
    private String username;
    @Column(name = "total_correct")
    private Integer totalCorrect;
}
