import {Component} from '@angular/core';
import {Router, RouterOutlet} from '@angular/router';
import {ClientSearchComponent} from './pages/client/search/search.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ClientSearchComponent],
  templateUrl: './app.component.html',
  standalone: true,
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'frontend';

  constructor(private router: Router) {
  }
}
