package com.example.park.newbie.controller;


import com.example.park.newbie.dto.MemberDto;
import com.example.park.newbie.dto.TaskDto;
import com.example.park.newbie.model.Member;
import com.example.park.newbie.service.TaskService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Void> createTask(@RequestBody TaskDto.CreateTaskRequest request) {
        try {
            taskService.createTask(request.memberId(), request.contents());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/member")
    public ResponseEntity<MemberDto.FindMemberResponse> getTask(@PathVariable Long id) {
        Member member = taskService.findTaskMember(id);
        return ResponseEntity.ok().body(new MemberDto.FindMemberResponse(member));
    }

}
