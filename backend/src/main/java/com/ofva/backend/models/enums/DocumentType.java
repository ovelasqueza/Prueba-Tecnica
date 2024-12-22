package com.ofva.backend.models.enums;

public enum DocumentType {
    C("Cédula de ciudadanía", "Cédula es requerida"),
    P("Pasaporte", "Pasaporte es requerido");

    public final String description;
    public final String error;

    DocumentType(String description, String error) {
        this.description = description;
        this.error = error;
    }
}