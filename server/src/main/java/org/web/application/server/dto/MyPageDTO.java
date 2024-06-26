package org.web.application.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyPageDTO {
    private String name;
    private String connectedAt;
    private Integer age;
    private String gender;
    private String ninckname;
    private String mbti;
    private String kakaoId;
    private String location;
    //이름 생성날짜 나이 성별 mbti
}
