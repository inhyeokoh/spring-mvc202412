package com.spring.mvcproject.board.dto.response;

public class BoardListDto {

    private int bno; // 원본 게시물 번호
    private String shortTitle; // 5글자 이상 줄임 처리된 제목
    private String shortContent; // 15자 이상 줄임 처리된 글 내용
    private String date; // 포맷팅된 날짜문자열 (2024/12/20)
    private int view; // 조회 수
    private boolean newArticle; // 새 게시물(1시간 이내)인가?
}
