package com.ofva.backend.controllers;

import com.ofva.backend.exceptions.CustomException;
import com.ofva.backend.models.enums.DocumentType;
import com.ofva.backend.models.responses.ClientResponse;
import com.ofva.backend.models.responses.Response;
import com.ofva.backend.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/get")
    public ResponseEntity<Response<ClientResponse>> client(
            @RequestParam("documentType") String documentType,
            @RequestParam("documentNumber") String documentNumber) {

        Response<ClientResponse> response = new Response<>();

        DocumentType type;
        try {
            type = DocumentType.valueOf(documentType);
        } catch (IllegalArgumentException e) {
            response.setMessage("Invalid document type");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (documentNumber == null || documentNumber.trim().isEmpty()) {
            response.setMessage("Document number is required");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        int documentNumberInt;
        try {
            documentNumberInt = Integer.parseInt(documentNumber);
        } catch (NumberFormatException e) {
            response.setMessage("Document number must be numeric");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            ClientResponse client = clientService.getByDocument(type, documentNumberInt);
            response.setMessage("Success");
            response.setData(client);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomException e) {
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        }
    }
}
