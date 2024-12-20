package com.spring.mvcproject.board.dto.request;

import com.spring.mvcproject.board.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

// DTO에서는 클라이언트의 데이터를 객체 세팅하기 위해
// All생성자나 Setter를 반드시 구현해놔야 함.
// 실무적 측면 - Setter구현은 불변성을 해칠 수 있으므로 신중하게 선택
@ToString
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BoardSaveDto {

    private String title;
    private String content;


    // 이 DTO를 데이터베이스에 저장하기 위해 Entity로 변환하는 메서드
    public Board toEntity() {
        Board b = new Board();
        b.setTitle(this.title);
        b.setContent(this.content);
        b.setViewCount(0);
        b.setRegDateTime(LocalDateTime.now());
        return b;
    }

}
