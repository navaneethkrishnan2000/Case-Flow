package com.caseflow.design.entity;

import com.caseflow.design.enums.CaseStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id")
    private Long caseId;

    @Column(name = "case_name", nullable = false)
    private String caseName;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "case_description", length = 1000)
    private String caseDescription;

    @Column(name = "completion_deadline")
    private LocalDateTime completionDeadline;

    @OneToMany(mappedBy = "caseEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "final_draft_id")
    private Document finalDraft; // This is fine if only one final draft exists

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "case_assignments",
            joinColumns = @JoinColumn(name = "case_id"),
            inverseJoinColumns = @JoinColumn(name = "auth_id")
    )
    private Set<UserAuth> assignedUsers = new HashSet<>(); // multiple users can assign for a single case

    @Enumerated(EnumType.STRING)
    private CaseStatus caseStatus;

    @Column(name = "case_type")
    private String caseType; // VISA, IMMIGRATION, H1B ....

    @Column(name = "assigned_by")
    private Long assignedBy;

    @Column(name = "remarks_path")
    private String remarksPath; // Store file path instead of a File object

    // Getters and Setters

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public LocalDateTime getCompletionDeadline() {
        return completionDeadline;
    }

    public void setCompletionDeadline(LocalDateTime completionDeadline) {
        this.completionDeadline = completionDeadline;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Document getFinalDraft() {
        return finalDraft;
    }

    public void setFinalDraft(Document finalDraft) {
        this.finalDraft = finalDraft;
    }

    public Set<UserAuth> getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(Set<UserAuth> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    public CaseStatus getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatus caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public Long getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Long assignedBy) {
        this.assignedBy = assignedBy;
    }

    public String getRemarksPath() {
        return remarksPath;
    }

    public void setRemarksPath(String remarksPath) {
        this.remarksPath = remarksPath;
    }
}

