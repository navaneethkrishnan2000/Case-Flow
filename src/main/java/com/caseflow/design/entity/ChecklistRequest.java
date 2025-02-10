package com.caseflow.design.entity;

import com.caseflow.design.enums.ChecklistStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "checklist_requests")
public class ChecklistRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_id")
    private Long checklistId;

    @Column(name = "remarks")
    private String remarks;

    @Enumerated(EnumType.STRING)
    @Column(name = "checklist_status")
    private ChecklistStatus checklistStatus;

    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private Case caseEntity;

    @OneToMany(mappedBy = "checklistRequest", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ChecklistFile> checklistFiles = new ArrayList<>();
}

