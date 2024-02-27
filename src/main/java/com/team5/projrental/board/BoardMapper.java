package com.team5.projrental.board;

import com.team5.projrental.board.model.*;
import com.team5.projrental.entities.BoardPic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardInsDto dto);
    int insBoardPics(BoardPicInsDto dto);

    List<BoardListSelVo> selBoardList (BoardListSelDto dto); //게시판 전체글 리스트
    BoardSelVo selBoard (int iboard); //특정 게시글 입장
    List<String> selBoardPicList(int iboard); //특정 게시판의 사진들
    int viewCount(int iboard); //조회수
    int putboard(BoardPutDto dto);

    int delBoard(long iboard);

    int delLike(BoardToggleLikeDto dto);

    int insLike(BoardToggleLikeDto dto);
}
