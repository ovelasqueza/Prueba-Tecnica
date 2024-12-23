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
    name: 'Fernando',
    lastName: 'Velasquez',
  };

  constructor(private clientService: ClientService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.client = this.clientService.getClient(params['documentType'], params['documentNumber']);
    });


  }

  back() {
    window.history.back();
  }
}
