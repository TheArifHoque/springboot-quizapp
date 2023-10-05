package com.arifhoque.quizapp.controller;

import com.arifhoque.quizapp.model.QuestionForm;
import com.arifhoque.quizapp.model.Result;
import com.arifhoque.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class QuizController {
    @Autowired
    private QuizService quizService;
    @Autowired
    private Result result;

    Boolean isSubmitted;

    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @PostMapping("/quiz")
    public String quiz(@RequestParam String username, RedirectAttributes redirectAttributes, Model model) {
        if (username.isEmpty()) {
            redirectAttributes.addFlashAttribute("warning","Please enter your name");
            return "redirect:/";
        }
        isSubmitted = false;
        result.setUsername(username);
        QuestionForm qform = quizService.getRandomQuestions();
        model.addAttribute("qForm",qform);

        return "quiz.html";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute QuestionForm qForm, Model model) {
        if (!isSubmitted) {
            result.setTotalCorrect(quizService.getResult(qForm));
            quizService.saveScore(result);
            isSubmitted = true;
            model.addAttribute("result",result);
        }
        return "result.html";
    }

    @GetMapping("/score")
    public String score(Model model) {
        List<Result> sList = quizService.getTopScore();
        model.addAttribute("sList",sList);
        return "scoreboard.html";
    }
}
