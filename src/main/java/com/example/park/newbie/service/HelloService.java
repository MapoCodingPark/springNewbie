package com.example.park.newbie.service;

import com.example.park.newbie.model.Member;
import com.example.park.newbie.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class HelloService {

    private final MemberRepository memberRepository;

    public String getHello() {
        return "hello im woong good perfect";
    }

    public void saveMember(String memberName, int memberAge) {
//        Member member = new Member();
//        member.setName(memberName);
//        member.setAge(memberAge);
//        memberRepository.save(member);
        memberRepository.save(Member.builder()
                .name(memberName)
                .age(memberAge)
                .build());
    }

    public Member findMember(long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public long countMembers() {
        return memberRepository.count();
    }

    public void deleteMemberById(long id) {
        memberRepository.deleteById(id);
    }

    public Page<Member> findMembersPaging(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    public List<Member> findMemberByNameContainingAndAgeGreaterThan(String name, Integer age) {
        return memberRepository.findMemberByNameContainingAndAgeGreaterThan(name, age);
    }

}
