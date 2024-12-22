package com.ofva.backend.api;

import com.ofva.backend.exceptions.CustomException;
import com.ofva.backend.models.enums.DocumentType;
import com.ofva.backend.models.responses.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/client")
    public ResponseEntity<UserResponse> client(
            @RequestParam("documentType") String documentType,
            @RequestParam("documentNumber") String documentNumber) {

        DocumentType type;
        try {
            type = DocumentType.valueOf(documentType);
        } catch (IllegalArgumentException e) {
            throw new CustomException("Invalid document type", HttpStatus.BAD_REQUEST);
        }

        if (documentNumber == null || documentNumber.trim().isEmpty()) {
            throw new CustomException("Document number is required", HttpStatus.BAD_REQUEST);
        }

        int documentNumberInt;
        try {
            documentNumberInt = Integer.parseInt(documentNumber);
        } catch (NumberFormatException e) {
            throw new CustomException("Document number must be numeric", HttpStatus.BAD_REQUEST);
        }

        if (documentNumberInt == 0) {
            throw new CustomException("Document number cannot be zero", HttpStatus.BAD_REQUEST);
        }
        if (type == DocumentType.C && documentNumberInt == 23445322) {
            UserResponse response = new UserResponse(
                "Olmer",
                "Fernando",
                "Velasquez", 
                "Andrade", 
                "123-456-7890", 
                "casa 1", 
                "Pasto - Nariño"
            );
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new CustomException("Client not found", HttpStatus.NOT_FOUND);
        }
    }
}
