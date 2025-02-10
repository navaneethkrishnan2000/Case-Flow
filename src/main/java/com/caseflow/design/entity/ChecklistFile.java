package com.caseflow.design.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "checklist_files")
public class ChecklistFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cheklist_file_id")
    private Long checklistFileId;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_type", nullable = false)
    private String fileType;

    @Column(name = "file_url")
    private String fileUrl;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    @ManyToOne
    @JoinColumn(name = "checklist_request_id", nullable = false)
    private ChecklistRequest checklistRequest;

    // Getters and Setters

    public Long getChecklistFileId() {
        return checklistFileId;
    }

    public void setChecklistFileId(Long checklistFileId) {
        this.checklistFileId = checklistFileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public ChecklistRequest getChecklistRequest() {
        return checklistRequest;
    }

    public void setChecklistRequest(ChecklistRequest checklistRequest) {
        this.checklistRequest = checklistRequest;
    }
}
