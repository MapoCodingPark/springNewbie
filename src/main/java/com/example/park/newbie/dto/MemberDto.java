package com.example.park.newbie.dto;

import com.example.park.newbie.model.Member;

public class MemberDto {

    public record FindMemberResponse(
            Long id,
            String name,
            int age
    ) {
        public FindMemberResponse(Member member) {
            this(member.getMemberNumber(), member.getName(), member.getAge());
        }
    }

    public record CreateMemberRequest(
            String name,
            int age
    ) {}


}
