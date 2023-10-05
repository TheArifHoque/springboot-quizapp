package com.arifhoque.quizapp.util;

import com.arifhoque.quizapp.model.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@Getter
public class QuestionBank {
    private List<Question> questionList;

    public void init() {
        questionList = new ArrayList<>();
        questionList.add(new Question(1,"What is the correct syntax to output \"Hello World\" in Java?","echo \"Hello World\"",
                "printf(\"Hello World\")","System.out.println(\"Hello World\")",3,-1));
        questionList.add(new Question(2,"What is the correct syntax to output \"Hello World\" in PHP?","echo \"Hello World\"",
                "printf(\"Hello World\")","System.out.println(\"Hello World\")",1,-1));
        questionList.add(new Question(3,"What is the correct syntax to output \"Hello World\" in C?","echo \"Hello World\"",
                "printf(\"Hello World\")","System.out.println(\"Hello World\")",2,-1));
    }
}
