import { Routes } from '@angular/router';
import {ClientDetailComponent} from './pages/client/detail/detail.component';
import {ClientSearchComponent} from './pages/client/search/search.component';

export const routes: Routes = [
  { path: '', redirectTo: 'client/search', pathMatch:'full' },
  { path: 'client/search', component: ClientSearchComponent },
  { path: 'client/detail', component: ClientDetailComponent }
];
