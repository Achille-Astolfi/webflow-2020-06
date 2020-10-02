package com.example.corso.flow.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "PUBLIC", name = "Holidays")
public class Holiday {

    @Id
    @Column(name = "PK")
    private long holidayPk;

    @Column(name = "DayOfAbsence")
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date dayOfAbsence;

    @JoinColumn(name = "TeamMember")
    @ManyToOne
    private TeamMember teamMember;


    public long getHolidayPk() {
        return holidayPk;
    }

    public void setHolidayPk(long holidaysPk) {
        this.holidayPk = holidaysPk;
    }

    public Date getDayOfAbsence() {
        return dayOfAbsence;
    }

    public void setDayOfAbsence(Date dayOfAbsence) {
        this.dayOfAbsence = dayOfAbsence;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }
}
