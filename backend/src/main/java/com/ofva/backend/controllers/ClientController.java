package com.ofva.backend.controllers;

import jakarta.validation.Valid;
import com.ofva.backend.exceptions.CustomException;
import com.ofva.backend.models.requests.ClientGetRequest;
import com.ofva.backend.models.responses.ClientResponse;
import com.ofva.backend.models.responses.Response;
import com.ofva.backend.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/get")
    public ResponseEntity<Response<ClientResponse>> getClient(@Valid ClientGetRequest request) {

        Response<ClientResponse> response = new Response<>();

        try {
            ClientResponse client = clientService.getByDocument(request.getDocumentTypeEnum(), request.getDocumentNumber());
            response.setMessage("Success");
            response.setData(client);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (CustomException e) {
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, e.getStatus());
        } catch (IllegalArgumentException e) {
            response.setMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
