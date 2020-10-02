package com.example.corso.flow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corso.flow.entity.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

}
