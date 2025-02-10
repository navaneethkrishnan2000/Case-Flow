package com.caseflow.design.entity;

import com.caseflow.design.enums.ChecklistResponseStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "checklist_responses")
public class ChecklistResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_response_id")
    private Long checklistResponseId;

    @Column(name = "remarks")
    private String remarks;

    @Enumerated(EnumType.STRING)
    @Column(name = "checklist_response_status")
    private ChecklistResponseStatus checklistResponseStatus;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "checklist_request_id", nullable = false)
    private ChecklistRequest checklistRequest;

    @OneToMany(mappedBy = "checklistResponse", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Document> responseDocuments = new ArrayList<>();
}
