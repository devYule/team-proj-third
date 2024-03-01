package com.team5.projrental.aachat.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static com.team5.projrental.entities.QChatMsg.chatMsg;

@Slf4j
@RequiredArgsConstructor
public class ChatQdslRepositoryImpl implements ChatQdslRepository {
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Long selChatMsg(long ichat, long iuser) {
        // 2. ichat 과 iuser(로그인한) 로 chat_user 와 chat_msg 를 조인 걸어서 chat_msg 엔티티를 통채로 가져온다.


        return jpaQueryFactory.select(chatMsg.seq)
                .from(chatMsg)
                .join(chatMsg.chatUser).fetchJoin()
                .where(chatMsg.chatUser.id.eq(ichat).and(chatMsg.chatUser.user.id.eq(iuser)))
                .limit(1)
                .fetchOne();
    }


}