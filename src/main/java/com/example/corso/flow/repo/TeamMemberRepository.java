package com.example.corso.flow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.corso.flow.entity.TeamMember;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {
    // funziona che io aggiungo la firma di un metodo - posso chiamarlo cavallo,
    // ma se uso un nome parlante è meglio, per esempio findSupervisorAll
    // Poi devo capire se la mia inquiry estrae un unico elemento oppure un elenco
    // NOTA BENE: so che estrarrò un unico elemento solamente se la tabella definisce
    // un indice di tipo UNIQUE e io uso esattamente quell'indice per la mia inquiry.
    // Se estrae un unico elemento allora il metodo deve restituire TeamMember
    // Se estrae un elenco allora ... List<TeamMember>
    // Il metodo non è sufficiente, devo specificare la SQL; per specificarla
    // uso l'annotation @Query
    // Piccola postilla: il linguaggio di inquiry ufficiale di JPA non è SQL
    // ma è JPQL (conosciuto anche come HQL) Java Persistence Query Language
    // Hibernate Query Language; se uso SQL standard, devo aggiungere l'attributo
    // nativeQuery con valore true
    @Query(value = "SELECT * FROM TEAMMEMBERS WHERE ROLE='Supervisor'", nativeQuery = true)
    List<TeamMember> findSupervisorAll();

    @Query(value = "SELECT * FROM TEAMMEMBERS WHERE ROLE='Developer'", nativeQuery = true)
    List<TeamMember> findDeveloperAll();

    // il metodo può chiamarsi findTeamMemberByLastName
    @Query(value="SELECT * FROM TEAMMEMBERS WHERE LASTNAME=?",nativeQuery=true)
    List<TeamMember> findByLastName(String lastName);

    // questo è un caso in cui non restituisco né TeamMember né List<TeamMember>
    @Query(value = "SELECT MAX(PK) FROM TEAMMEMBERS", nativeQuery = true)
    long findMaxPk();

}
