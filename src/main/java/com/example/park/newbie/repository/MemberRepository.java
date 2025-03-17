package com.example.park.newbie.repository;

import com.example.park.newbie.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findMemberByNameContainingAndAgeGreaterThan(String name, Integer age);
}
