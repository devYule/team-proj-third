package com.team5.projrental.aachat.model;

import com.team5.projrental.entities.mappedsuper.CreatedAt;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ChatMsgSelVo {

    //제품 관련 정보
    private Long iproduct;
    private String title;
    private String productMainPic;
    private Long rentalPrice;


    // 내 프로필 정보
    private Long myIuser;
    private String myNick;
    private String myPic;

    //상대 프로필 정보
    private Long otherIuser;
    private String otherNick;
    private String otherPic;

    private List<Messages> messages;
    //



}
