package com.team5.projrental.board.comment;

import com.team5.projrental.board.comment.model.BoardCommentDelDto;
import com.team5.projrental.board.comment.model.BoardCommentInsDto;
import com.team5.projrental.board.comment.model.BoardCommentPatchDto;
import com.team5.projrental.board.model.BoardCommentSelVo;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BoardCommentMapper {
    int insBoardComment(BoardCommentInsDto dto);

    List<BoardCommentSelVo> selCommentList(int iboard);

    int patchBoardComment(BoardCommentPatchDto dto);

    int delBoardComment(int iboardComment, long loginIuser);
}
