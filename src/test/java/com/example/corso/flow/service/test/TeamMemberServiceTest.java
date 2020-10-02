package com.example.corso.flow.service.test;

import com.example.corso.flow.config.test.ServiceTestConfig;
import com.example.corso.flow.entity.TeamMember;
import com.example.corso.flow.service.TeamMemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceTestConfig.class)
public class TeamMemberServiceTest {
    @Autowired
    private TeamMemberService teamMemberService;

    @Test
    public void findMemberAllTest() {
        List<TeamMember> all = teamMemberService.findTeamMemberAll();
        assertFalse(all.isEmpty());
        TeamMember teamMember = all.get(0);
        assertNotNull(teamMember.getEmailAddress());
    }

    @Test
    public void findSupervisorAllTest() {
        List<TeamMember> supervisor = teamMemberService.findSupervisorAll();
        assertEquals(4, supervisor.size());
        TeamMember teamMember = supervisor.get(3);
        assertNotNull(teamMember.getPhoneNumber());
    }

    @Test
    public void findDeveloperAllTest() {
        List<TeamMember> developer = teamMemberService.findDeveloperAll();
        assertEquals(10, developer.size());
        TeamMember teamMember = developer.get(3);
        assertNotNull(teamMember.getPhoneNumber());
    }

    @Test
    public void findTeamMemberByLastNameOk() {
        List<TeamMember> teamMembers = teamMemberService.findTeamMemberByLastName("Guastafierro");
        assertFalse(teamMembers.isEmpty());

        List<TeamMember> notFound = teamMemberService.findTeamMemberByLastName("Marenco");
        assertTrue(notFound.isEmpty());
    }

    @Test
    public void findTeamMemberByLastNameKo() {
        List<TeamMember> teamMembers = teamMemberService.findTeamMemberByLastName(null);
        assertTrue(teamMembers.isEmpty());
    }

    @Test
    public void updateEmailAddressByTeamMemberPkTestOk() {
        TeamMember teamMember = teamMemberService.updateEmailAddressByTeamMemberPk(12, "a.C@b");
        assertEquals("a.C@b", teamMember.getEmailAddress());
    }

    @Test
    public void updateEmailAddressByTeamMemberPkTestKo() {
        TeamMember teamMember = teamMemberService.updateEmailAddressByTeamMemberPk(12, "");
        assertNull(teamMember);
    }

    @Test
    public void updatePhoneNumberByTeamMemberPkTestOk() {
        TeamMember teamMember = teamMemberService.updatePhoneNumberByTeamMemberPk(12, "+3456");
        assertEquals("+3456", teamMember.getPhoneNumber());
    }

    @Test
    public void updatePhoneNumberByTeamMemberPkTestKo() {
        TeamMember teamMember = teamMemberService.updatePhoneNumberByTeamMemberPk(12, "");
        assertNull(teamMember);
    }

    @Test
    public void createSupervisorTestOk() {
        TeamMember teamMember = teamMemberService.createSupervisor("Piero", "Angela",
                "+333444555", "p.angela@example.com");
        assertEquals("Angela", teamMember.getLastName());
    }

    @Test
    public void createSupervisorTestKo() {
        TeamMember teamMember = teamMemberService.createSupervisor("Piero", "Angela",
                "+333444555", null);
        assertNull(teamMember);
    }

}
