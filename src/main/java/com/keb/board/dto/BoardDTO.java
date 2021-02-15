package com.keb.board.dto;


import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;
    private String writerEmail;
    private String writerName;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
    private int replyCount; //게시글에 딸린 댓글 수

}
