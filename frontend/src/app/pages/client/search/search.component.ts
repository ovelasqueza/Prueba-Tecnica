import {Component} from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';

@Component({
  selector: 'client-search',
  imports: [RouterOutlet],
  templateUrl: './search.component.html',
  standalone: true,
  styleUrl: './search.component.scss'
})
export class ClientSearchComponent {
  name = 'Client Search';

  constructor(private router: Router) {
  }

  search() {
    this.router.navigate(['client/detail']);
  }
}
