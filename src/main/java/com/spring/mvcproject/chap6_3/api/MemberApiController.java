package com.spring.mvcproject.chap6_3.api;

import com.spring.mvcproject.chap6_3.entity.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v6/members")
public class MemberApiController {

    private Map<String, Member> memberStore = new HashMap<>();

    public MemberApiController() {
        Member m1 = Member.builder()
                .account("abc1234")
                .password("12345678")
                .nickname("호돌이")
                .build();

        Member m2 = Member.builder()
                .account("def9876")
                .password("12345678")
                .nickname("핑돌이")
                .build();

        memberStore.put(m1.getAccount(), m1);
        memberStore.put(m2.getAccount(), m2);
    }

    // 회원 단일 조회
    @GetMapping("/{account}")
    public ResponseEntity<?> findOne(@PathVariable String account) {

        if (account.length() > 10) {
            throw new IllegalStateException("계정명은 10글자 이내여야 합니다.");
        }

        Member member = memberStore.get(account);

        if (member == null) {
            throw new IllegalStateException("회원 계정명을 다시 확인하세요!");
        }

        return ResponseEntity.ok().body(member);
    }

}
