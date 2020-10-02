package com.example.corso.flow.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "PUBLIC", name = "TeamMembers")
public class TeamMember {

    @Id
    @Column(name = "PK")
    private long teamMemberPk;

    @Column(name = "FirstName")
    @Basic(optional = false)
    private String firstName;

    @Column(name = "LastName")
    @Basic(optional = false)
    private String lastName;

    @Column(name = "EmailAddress")
    @Basic(optional = false)
    private String emailAddress;

    @Column(name = "PhoneNumber")
    @Basic(optional = false)
    private String phoneNumber;

    @Column(name = "Role")
    @Basic(optional = false)
    private String role;

    public long getTeamMemberPk() {
        return teamMemberPk;
    }

    public void setTeamMemberPk(long memberId) {
        this.teamMemberPk = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
