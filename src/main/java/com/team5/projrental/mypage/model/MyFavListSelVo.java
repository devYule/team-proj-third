package com.team5.projrental.mypage.model;

import com.team5.projrental.product.model.Categories;
import lombok.Data;

@Data
public class MyFavListSelVo {
    private int iproduct; // 상품 PK
    private String title; // 상품 제목
    private String contents;
    private String pic; // 상품 대표사진
    private int rentalPrice; // 대여가격
    private int iuser; // 보증금
    private String storedPic; // 물건등록한 상대유저사진
    private String nick; // 물건등록한 상대유저 프로필사진

    private Categories icategory;
    private int mainCategory;
    private int subCategory;

}
