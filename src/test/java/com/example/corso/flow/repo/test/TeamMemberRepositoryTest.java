package com.example.corso.flow.repo.test;

import com.example.corso.flow.config.test.RepoTestConfig;
import com.example.corso.flow.entity.TeamMember;
import com.example.corso.flow.repo.TeamMemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RepoTestConfig.class)
public class TeamMemberRepositoryTest {
	@Autowired
	private TeamMemberRepository teamMemberRepository;

	@Test
	public void getOneTest() {
		assertNotNull(teamMemberRepository.getOne(1L));
	}

	@Test
	@Transactional
	public void structuredGetOneTest() {
		TeamMember teamMember = teamMemberRepository.getOne(1L);
		assertEquals("Achille", teamMember.getFirstName());
		assertEquals("Astolfi", teamMember.getLastName());
	}

	@Test
	public void findAllTest() {
		List<TeamMember> all = teamMemberRepository.findAll();
		assertEquals(14, all.size());
		TeamMember teamMember = all.get(10);
		if (teamMember.getFirstName().equals("Mattia")) {
			assertEquals("Mesco", teamMember.getLastName());
		}
	}

}
