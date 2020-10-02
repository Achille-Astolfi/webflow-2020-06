package com.example.corso.flow.serviceimpl;

import com.example.corso.flow.entity.TeamMember;
import com.example.corso.flow.repo.TeamMemberRepository;
import com.example.corso.flow.service.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamMemberServiceImpl implements TeamMemberService {
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Override
    public List<TeamMember> findTeamMemberAll() {
        return teamMemberRepository.findAll();
    }

    @Override
    public List<TeamMember> findSupervisorAll() {
        return teamMemberRepository.findSupervisorAll();
    }

    @Override
    public List<TeamMember> findDeveloperAll() {
        return teamMemberRepository.findDeveloperAll();
    }

    @Override
    public List<TeamMember> findTeamMemberByLastName(String lastName) {
        // validazione input
        if (!StringUtils.hasText(lastName)) {
            return new ArrayList<>();
        }
        // algoritmo con variante: uso trim()
        return teamMemberRepository.findByLastName(lastName.trim());
    }

    @Override
    @Transactional
    public TeamMember updatePhoneNumberByTeamMemberPk(long teamMemberPk, String newPhoneNumber) {
        // verifica formale dell'input:
        // se teamMemberPk <= 0 oppure newPhoneNumber "è blank" (!hasText) restituisco direttamente null
        if (teamMemberPk <= 0 || !StringUtils.hasText(newPhoneNumber)) {
            return null;
        }
        // invoco getOne per avere TeamMember
        TeamMember teamMember = teamMemberRepository.getOne(teamMemberPk);
        // imposto il nuovo valore
        teamMember.setPhoneNumber(newPhoneNumber);
        // invoco il metodo save; il metodo save restituisce TeamMember, proprio quello di cui
        // ho bisogno
        return teamMemberRepository.save(teamMember);
    }

    @Override
    @Transactional
    public TeamMember updateEmailAddressByTeamMemberPk(long teamMemberPk, String newEmailAddress) {
        if (teamMemberPk <= 0 || !StringUtils.hasText(newEmailAddress)) {
            return null;
        }
        TeamMember teamMember = teamMemberRepository.getOne(teamMemberPk);
        teamMember.setEmailAddress(newEmailAddress);
        return teamMember;
    }

    @Override
    @Transactional
    public TeamMember createSupervisor(String firstName, String lastName, String phoneNumber, String emailAddress) {
        // validazione
        if (!StringUtils.hasText(firstName) || !StringUtils.hasText(lastName) || !StringUtils.hasText(phoneNumber) || !StringUtils.hasText(emailAddress)) {
            return null;
        }
        // creo un oggetto TeamMember
        TeamMember teamMember = new TeamMember();
        // popolo con tutti gli elementi che mi servono
        teamMember.setFirstName(firstName);
        teamMember.setLastName(lastName);
        teamMember.setPhoneNumber(phoneNumber);
        teamMember.setEmailAddress(emailAddress);
        teamMember.setRole("Supervisor");
        teamMember.setTeamMemberPk(teamMemberRepository.findMaxPk() + 1L);
        // invoco il metodo save, lo stesso che uso per update
        return teamMemberRepository.save(teamMember);
    }
}
