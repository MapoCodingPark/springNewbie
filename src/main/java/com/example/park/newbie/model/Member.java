package com.example.park.newbie.model;

import com.example.park.model.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Members")
@Builder
@AllArgsConstructor // @Builder 를 위한 생성자
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNumber;

    @Column(nullable = false, length = 50)
    private String name;

    private int age;
}
