package com.team5.projrental.board;


import com.team5.projrental.board.comment.BoardCommentMapper;
import com.team5.projrental.board.model.*;
import com.team5.projrental.common.Const;
import com.team5.projrental.common.exception.BadWordException;
import com.team5.projrental.common.exception.checked.FileNotContainsDotException;
import com.team5.projrental.common.exception.thrid.ClientException;
import com.team5.projrental.common.model.ResVo;
import com.team5.projrental.common.security.AuthenticationFacade;
import com.team5.projrental.common.utils.CommonUtils;
import com.team5.projrental.common.utils.MyFileUtils;
import com.team5.projrental.entities.Board;
import com.team5.projrental.entities.BoardPic;
import com.team5.projrental.entities.User;
import com.team5.projrental.entities.enums.BoardStatus;
import com.team5.projrental.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.team5.projrental.common.exception.ErrorCode.BAD_PIC_EX_MESSAGE;
import static com.team5.projrental.common.exception.ErrorCode.BAD_WORD_EX_MESSAGE;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardLikeRepository boardLikeRepository;
    private final AuthenticationFacade authenticationFacade;
    private final MyFileUtils myFileUtils;
    private final UserRepository userRepository;
    private final BoardMapper mapper;
    private final BoardCommentMapper commentMapper;

    @Transactional
    public ResVo postBoard(BoardInsDto dto) {
        CommonUtils.ifContainsBadWordThrow(BadWordException.class, BAD_WORD_EX_MESSAGE,
                dto.getTitle(), dto.getContents());
        /*int result = mapper.insBoard(dto);
        BoardPicInsDto pDto = new BoardPicInsDto();
        if (dto.getStoredPic() != null && !dto.getStoredPic().isEmpty()) {
            try {
                for (MultipartFile file : dto.getStoredPic()) {
                    String picName = myFileUtils.savePic(file, "board", String.valueOf(dto.getIboard()));
                    List<String> dd = new ArrayList();
                    dd.add(picName);
                    pDto.setStoredPic(dd);
                }
            } catch (FileNotContainsDotException e) {
                throw new ClientException(BAD_PIC_EX_MESSAGE);
            }
            int result2 = mapper.insBoardPics(pDto);
        }
        return new ResVo((long)dto.getIboard());*/

        User user = userRepository.getReferenceById(authenticationFacade.getLoginUserPk());
        Board board = Board.builder()
                .user(user)
                .title(dto.getTitle())
                .contents(dto.getContents())
                .status(BoardStatus.ACTIVATED)
                .build();
        boardRepository.save(board);
        board.setUser(user);
        board.setTitle(dto.getTitle());
        board.setContents(dto.getContents());

        String stringId= String.valueOf(board.getId());
        BoardPicInsDto boardPicInsDto = new BoardPicInsDto();
        boardPicInsDto.setIboard(board.getId().intValue());

        if(dto.getStoredPic() != null && !dto.getStoredPic().isEmpty()) {
            try {
                board.setBoardPicList(myFileUtils.savePic(dto.getStoredPic(), "board", stringId)
                        .stream()
                        .map(picName -> BoardPic.builder()
                                .board(board)
                                .storedPic(picName)
                                .build()).collect(Collectors.toList()));
            } catch (FileNotContainsDotException e) {
                throw new ClientException(BAD_PIC_EX_MESSAGE);
            }
        }
        return new ResVo((long)boardPicInsDto.getIboard());
    }

    public List<BoardListSelVo> getBoardList (BoardListSelDto dto){
        List<BoardListSelVo> list = mapper.selBoardList(dto);
        System.out.println(list);
        return list;
    }

    public BoardSelVo getBoard (int iboard){
        BoardSelVo vo = mapper.selBoard(iboard);
        List<String> boardPicList = mapper.selBoardPicList(iboard);
        List<String> boardCommentList = commentMapper.selCommentList(iboard);
        mapper.viewCount(iboard);

        vo.setPic(boardPicList);
        vo.setComments(boardCommentList);

        return vo;
    }

    @Transactional
    public ResVo delBoard (long iboard){
        Board board = boardRepository.getReferenceById(iboard);
        board.setStatus(BoardStatus.DELETED);
        //board.setStatus(BoardStatus.DELETED);
            /*long result = mapper.delBoard(iboard);
            return new ResVo(result);*/
        return new ResVo(Const.SUCCESS);
    }

    public ResVo toggleLike (long iboard) {
        User user = userRepository.getReferenceById(authenticationFacade.getLoginUserPk());
        return null;

            /*long loginIuser = authenticationFacade.getLoginUserPk();
            BoardToggleLikeDto likeDto = new BoardToggleLikeDto();
            likeDto.setIboard(iboard);
            likeDto.setLoginIuser(loginIuser);

            long affectedRow = mapper.delLike(likeDto);
            if (affectedRow == 0) {
                mapper.insLike(likeDto);
            }
            return new ResVo(affectedRow);*/
        //return null;
    }
}

