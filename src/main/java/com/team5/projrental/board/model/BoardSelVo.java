package com.team5.projrental.board.model;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardSelVo {
    private String nick;
    private String userPic;

    private int isLiked; // 0: 안누름 , 1: 좋아요

    private int iboard;
    private String title;
    private String contents;
    private int view;
    private String createdAt;

    private List<String> pic;

    private List<String> comments;


}
