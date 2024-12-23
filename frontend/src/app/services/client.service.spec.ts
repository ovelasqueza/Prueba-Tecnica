import { TestBed } from '@angular/core/testing';
import { ClientService } from './client.service';
import { Client } from '../models/client';

describe('ClientService', () => {
  let service: ClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return a client when documentType and documentNumber match', () => {
    const documentType = 'C';
    const documentNumber = '1039454860';
    const expectedClient: Client = {
      name: 'Jhenny',
      lastName: 'Pérez'
    };

    const client = service.getClient(documentType, documentNumber);
    expect(client).toEqual(expectedClient);
  });

  it('should return an empty client when documentType and documentNumber do not match', () => {
    const documentType = 'X';
    const documentNumber = '00000000';
    const expectedClient: Client = {
      name: '',
      lastName: ''
    };

    const client = service.getClient(documentType, documentNumber);
    expect(client).toEqual(expectedClient);
  });
});
