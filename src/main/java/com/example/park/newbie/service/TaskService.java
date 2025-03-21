package com.example.park.newbie.service;

import com.example.park.newbie.model.Member;
import com.example.park.newbie.model.Task;
import com.example.park.newbie.repository.MemberRepository;
import com.example.park.newbie.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createTask(Long memberNo, String contents) {
        Optional<Member> member = memberRepository.findById(memberNo);

        if (member.isEmpty()) {
            throw new EntityNotFoundException();
        }

        taskRepository.save(Task.builder()
                .member(member.get())
                .contents(contents)
                .build()
        );
    }

    public Member findTaskMember(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.get().getMember();
    }


}
