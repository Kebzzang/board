package com.keb.board;

import com.keb.board.entity.Member;
import com.keb.board.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMembers(){

        IntStream.rangeClosed(1, 100).forEach(i->{
            Member member=Member.builder()
                .email("user"+i+"@keb.com")
                .password("1111")
                    .name("USER"+i)
                    .build();
            memberRepository.save(member);
        });

    }


}
