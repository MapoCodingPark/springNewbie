package com.example.park.newbie.controller;

import com.example.park.newbie.dto.MemberDto;
import com.example.park.newbie.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.getHello();
    }

    @GetMapping("/members/{id}")
    public MemberDto.FindMemberResponse getMemberById(@PathVariable long id) {
        return new MemberDto.FindMemberResponse(helloService.findMember(id));
    }

    @PostMapping("/members")
    public void createMember(@RequestBody MemberDto.CreateMemberRequest member) {
        helloService.saveMember(member.name(), member.age());
    }

    @GetMapping("/members/list")
    public List<MemberDto.FindMemberResponse> getMemberList() {
//        return helloService.findAllMembers().stream()
//                .map(member -> new MemberDto.FindMemberResponse(member.getMemberNumber(), member.getName(), member.getAge()))
//                .collect(Collectors.toList());
//        return helloService.findAllMembers().stream()
//                .map(member -> new MemberDto.FindMemberResponse(member))
//                .collect(Collectors.toList());
        return helloService.findAllMembers().stream()
                .map(MemberDto.FindMemberResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/members/count")
    public long getMemberCount() {
        return helloService.countMembers();
    }

    @PostMapping("/members/delete")
    public void deleteMember(@RequestParam long id) {
        helloService.deleteMemberById(id);
    }

    @GetMapping("/members/paging")
    public Page<MemberDto.FindMemberResponse> getMemberPaging(Pageable pageable) {
        return helloService.findMembersPaging(pageable).map(MemberDto.FindMemberResponse::new);
    }

    @GetMapping("/members/search")
    public List<MemberDto.FindMemberResponse> searchMembersByNameAndAge(@RequestParam String name, @RequestParam Integer age) {
        return helloService.findMemberByNameContainingAndAgeGreaterThan(name, age)
                .stream()
                .map(MemberDto.FindMemberResponse::new)
                .collect(Collectors.toList());
    }
}
