import { Injectable } from '@angular/core';
import { Client } from '../models/client';
import db from './db.json';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClientResponse } from '../models/client.response';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  
  private apiUrl = 'http://api-backend-rest-client.us-east-2.elasticbeanstalk.com:8090/clients/get';

  constructor(private http: HttpClient) { }

  getClient(documentType: string, documentNumber: string): Client {
    const clientEncntrado = db.find((c) => {
      return c.documentType === documentType && c.documentNumber === documentNumber;
    });

    return {
      name: clientEncntrado ? clientEncntrado.firstName : '',
      lastName: clientEncntrado ? clientEncntrado.lastName : '',
    };
  }
  

  getClientRemoteApi(documentType: string, documentNumber: string): Observable<ClientResponse> {
    const url = `${this.apiUrl}?documentType=${documentType}&documentNumber=${documentNumber}`;
    return this.http.get<ClientResponse>(url);
  }


}
