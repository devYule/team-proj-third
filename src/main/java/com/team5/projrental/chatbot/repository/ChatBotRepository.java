package com.team5.projrental.chatbot.repository;

import com.team5.projrental.chatbot.model.ChatBotVo;
import com.team5.projrental.entities.ChatBot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatBotRepository extends JpaRepository<ChatBot, Long>,ChatBotQueryRepository{

    @Query("select cb from ChatBot cb where cb.depth = 1")
    List<ChatBot> findByDepthInit();

    @Query("select cb from ChatBot cb where cb.grp = :grp and cb.depth = :depth")
    List<ChatBot> findByGrpAndDepth(Integer grp, Integer depth);
}