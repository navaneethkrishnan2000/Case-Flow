package com.caseflow.design.entity;

import com.caseflow.design.enums.ChecklistResponseStatus;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "checklist_responses")
public class ChecklistResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checklistResponseId;
    private String remarks;

    @OneToMany
    private List<File> checklistResponseFiles;
    private ChecklistResponseStatus checklistStatus;
    private String comments;
}
