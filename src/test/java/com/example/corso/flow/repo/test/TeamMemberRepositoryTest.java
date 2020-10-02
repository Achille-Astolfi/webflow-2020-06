package com.example.corso.flow.repo.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.corso.flow.config.test.RepoTestConfig;
import com.example.corso.flow.repo.TeamMemberRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RepoTestConfig.class)
public class TeamMemberRepositoryTest {
	@Autowired
	private TeamMemberRepository teamMemberRepository;

	@Test
	public void test() {
		assertNotNull(teamMemberRepository.getOne(1L));
	}
}
