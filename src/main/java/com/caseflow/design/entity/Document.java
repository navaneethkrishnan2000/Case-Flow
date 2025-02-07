package com.caseflow.design.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    private String documentName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
    private List<File> files = new ArrayList<>();
    private String documentUrl;

}
