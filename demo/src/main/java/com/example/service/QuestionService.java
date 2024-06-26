package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.repository.*;
import com.example.model.*;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import com.example.DataNotFoundException;



@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    
    public Question getQuestion(Integer id) {  
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}