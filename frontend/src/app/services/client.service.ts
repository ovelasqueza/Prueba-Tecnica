import { Injectable } from '@angular/core';
import { Client } from '../models/client';
import db from './db.json';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  constructor() { }

  getClient(documentType: string, documentNumber: string): Client {
    const clientEncntrado = db.find((c) => {
      return c.documentType === documentType && c.documentNumber === documentNumber;
    });

    return {
      name: clientEncntrado ? clientEncntrado.firstName : '',
      lastName: clientEncntrado ? clientEncntrado.lastName : '',
    };
  }

}
