package com.spring.mvcproject.score.dto.request;

import com.spring.mvcproject.score.entity.Score;
import lombok.*;

// 클라이언트가 성적정보를 등록할 때
// 필요한 정보만을 컴팩트하게 담고, 입력값을 검증하는 객체
@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ScoreCreateDto {
    private String studentName;
    private int korean;
    private int english;
    private int math;

}
