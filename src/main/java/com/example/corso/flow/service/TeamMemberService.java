package com.example.corso.flow.service;

import com.example.corso.flow.entity.TeamMember;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeamMemberService {
    List<TeamMember> findTeamMemberAll();

    List<TeamMember> findSupervisorAll();

    List<TeamMember> findDeveloperAll();

    List<TeamMember> findTeamMemberByLastName(String lastName);

    @Transactional
    TeamMember updatePhoneNumberByTeamMemberPk(long teamMemberPk, String newPhoneNumber);

    @Transactional
    TeamMember updateEmailAddressByTeamMemberPk(long teamMemberPk, String newEmailAddress);

    TeamMember createSupervisor(String firstName, String lastName, String phoneNumber, String emailAddress);
}
