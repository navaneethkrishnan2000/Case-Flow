package com.caseflow.design.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long documentId;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "document_url", nullable = false)
    private String documentUrl; // Store the file/folder URL (Cloud/local storage)

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private List<File> files = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private Case caseEntity;

    @Column(name = "is_final_draft")
    private Boolean isFinalDraft = false;  // If this document is a final draft

    @ManyToOne
    @JoinColumn(name = "checklist_response_id", nullable = false)
    private ChecklistResponse checklistResponse;

    // Getters and Setters

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Case getCaseEntity() {
        return caseEntity;
    }

    public void setCaseEntity(Case caseEntity) {
        this.caseEntity = caseEntity;
    }

    public Boolean getFinalDraft() {
        return isFinalDraft;
    }

    public void setFinalDraft(Boolean finalDraft) {
        isFinalDraft = finalDraft;
    }

    public ChecklistResponse getChecklistResponse() {
        return checklistResponse;
    }

    public void setChecklistResponse(ChecklistResponse checklistResponse) {
        this.checklistResponse = checklistResponse;
    }
}
