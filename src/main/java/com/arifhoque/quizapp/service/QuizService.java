package com.arifhoque.quizapp.service;

import com.arifhoque.quizapp.model.Question;
import com.arifhoque.quizapp.model.QuestionForm;
import com.arifhoque.quizapp.model.Result;
import com.arifhoque.quizapp.util.QuestionBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {
    @Autowired
    private QuestionBank questionBank;

    private List<Result> resultList = new ArrayList<>();

    public QuestionForm getRandomQuestions() {
        questionBank.init();
        List<Question> questionList = questionBank.getQuestionList();
        List<Question> qList = new ArrayList<>();

        Random random = new Random();

        for (int i=0;i<2;i++) {
            int index = random.nextInt(questionList.size());
            qList.add(questionList.get(index));
            questionList.remove(index);
        }
        return new QuestionForm(qList);
    }

    public Integer getResult(QuestionForm questionForm) {
        Integer correct = 0;

        for (Question q: questionForm.getQuestions()) {
            if (Objects.equals(q.getAns(), q.getChose()))
                correct++;
        }
        return correct;
    }

    public void saveScore(Result result) {
        resultList.add(result);
    }

    public List<Result> getTopScore() {
        //Using comparator to sort in reverse order by totalCorrect
        Comparator<Result> comparator = (c1,c2) -> c2.getTotalCorrect()-c1.getTotalCorrect();
        resultList.sort(comparator);
        return resultList;
    }
}
