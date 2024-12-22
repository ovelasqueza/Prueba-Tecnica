import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';

@Component({
  selector: 'client-detail',
  imports: [RouterOutlet],
  templateUrl: './detail.component.html',
  standalone: true,
  styleUrl: './detail.component.scss'
})
export class ClientDetailComponent {
  client = {
    name: 'Fernando',
    lastName: 'Velasquez',
  };
}
