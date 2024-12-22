package com.ofva.backend.models.requests;

import com.ofva.backend.models.enums.DocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClientGetRequest {
    @NotBlank(message = "Document type is required")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Document type must be a valid string")
    private String documentType;

    @NotBlank(message = "Document number is required")
    @Pattern(regexp = "^[0-9]+$", message = "Document number must be numeric")
    private String documentNumber;

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public Integer getDocumentNumber() {
        return Integer.parseInt(documentNumber);
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public DocumentType getDocumentTypeEnum() {
        return DocumentType.valueOf(documentType);
    }
}
