package com.example.park.newbie.dto;

public class TaskDto {

    public record CreateTaskRequest(
            Long memberId,
            String contents
    ){}
}
