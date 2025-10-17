package com.mysite.sbb.board.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.board.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;
    
    @OneToMany(mappedBy = "question",cascade = CascadeType.REMOVE) //1:N 관계라 명시해줘야 함
    //정확히는,, Answer 객체들 중에서,, 이 @Question이랑 매핑되는 애들을 리스트로 보여줘라..라는 의미
    private List<Answer> answerList;
}

