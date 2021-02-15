package com.keb.board.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")

public class Board extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long bno;
    private String title;
    private String content;

    @ManyToOne(fetch=FetchType.LAZY)
    private Member writer; //보드입장에서 한 명이 여러 보드 쓸 수 있으니까 매니투원
}
 //이메일을 포린 키로 참고하는 구조