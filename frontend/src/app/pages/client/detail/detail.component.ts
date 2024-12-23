import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { ClientService } from '../../../services/client.service';
import { Client } from '../../../models/client';

@Component({
  selector: 'client-detail',
  imports: [RouterOutlet],
  templateUrl: './detail.component.html',
  standalone: true,
  styleUrl: './detail.component.scss'
})
export class ClientDetailComponent {
  client: Client = {
    name: '',
    lastName: '',
  };

  constructor(private clientService: ClientService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      if (params['remote']=='true') {
        this.clientService.getClientRemoteApi(params['documentType'], params['documentNumber']).subscribe((clientResponse) => {
          const clientDTO = clientResponse.data;
          this.client = {
            name: clientDTO.firstName,
            lastName: clientDTO.lastName
          };
          console.log("respuesta remota", clientResponse);
        });

      } else {
        this.client = this.clientService.getClient(params['documentType'], params['documentNumber']);
      }
    });


  }

  back() {
    window.history.back();
  }
}
