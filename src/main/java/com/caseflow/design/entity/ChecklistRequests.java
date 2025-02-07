package com.caseflow.design.entity;

import com.caseflow.design.enums.ChecklistStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "checklist_requests")
public class ChecklistRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checklistId;

    private String remarks;

    @Lob
    private byte[] checklistFile; // Use @Lob for binary storage

    @Enumerated(EnumType.STRING)
    private ChecklistStatus checklistStatus;

    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private Case caseEntity;

    @OneToMany(mappedBy = "checklistRequest", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChecklistResponse> checklistResponses = new ArrayList<>();
}

