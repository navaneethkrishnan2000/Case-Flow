package com.caseflow.design.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    private String fileName;

    private String fileDescription;

    @Lob
    private byte[] file;

    private String fileUrl;

    private Long uploadedBy;
    private LocalDateTime uploadedAt;
    private Long updatedBy;
    private LocalDateTime updatedAt;



}
