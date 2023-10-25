package com.arifhoque.quizapp.repository;

import com.arifhoque.quizapp.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result,Integer> {
}
