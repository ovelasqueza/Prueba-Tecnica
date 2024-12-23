import { CommonModule, ɵnormalizeQueryParams } from '@angular/common';
import {Component} from '@angular/core';
import { FormsModule } from '@angular/forms';
import {Router, RouterOutlet} from '@angular/router';

@Component({
  selector: 'client-search',
  imports: [RouterOutlet, FormsModule, CommonModule],
  templateUrl: './search.component.html',
  standalone: true,
  styleUrl: './search.component.scss'
})
export class ClientSearchComponent {
  name = 'Client Search';
  documentType: string = '';
  documentNumber: string = '';

  constructor(private router: Router) {
  }
  get isButtonDisabled(): boolean {
    return !this.documentType || !this.documentNumber || this.documentNumber.length < 8 || this.documentNumber.length > 11;
  }

   formatNumber(event: any) {
    const input = event.target.value.replace(/\D/g, '');
    const formatted = input.replace(/\B(?=(\d{3})+(?!\d))/g, '.');
    event.target.value = formatted;
    this.documentNumber = input;
  }

  search() {
      console.log('this.documentType', this.documentType);
    this.router.navigate(['client/detail'], {
      queryParams: {
        documentType: this.documentType,
        documentNumber: this.documentNumber
      }
    });
  }
}
