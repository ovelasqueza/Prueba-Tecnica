package com.ofva.backend.services;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import com.ofva.backend.models.enums.DocumentType;
import com.ofva.backend.exceptions.CustomException;
import com.ofva.backend.models.responses.ClientResponse;

@Service
public class ClientService {
    public ClientResponse getByDocument(DocumentType documentType, Integer documentNumber) {
        if (documentType.equals(DocumentType.C) && documentNumber.equals(23445322)) {
            return new ClientResponse(
                    "Olmer",
                    "Fernando",
                    "Velasquez",
                    "Andrade",
                    "123-456-7890",
                    "casa 1",
                    "Pasto - Nariño"
            );
        }

        throw new CustomException("Client not found", HttpStatus.NOT_FOUND);
    }
}
