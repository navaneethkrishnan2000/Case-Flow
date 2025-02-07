package com.caseflow.design.entity;

import com.caseflow.design.enums.CaseStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cases")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    private String caseName;
    private String nameOfLawFirm;
    private String caseDescription;
    private Integer daysToComplete;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY ,  orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "fully_drafted_document_id")
    private Document fullyDraftedDocument;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,  orphanRemoval = true)
    private Set<UserAuthEntity> users = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private CaseStatus caseStatus;

    private String caseType; // VISA, IMMIGRATION, H1B ....

    private Long assignedBy;

    private String remarksPath; // Store file path instead of File object

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ChecklistRequests> checklist = new ArrayList<>();
}

