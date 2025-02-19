import { Component } from '@angular/core';
import { FiltersComponent } from '../filters/filters.component';
import { MusicianListComponent } from '../musician-list/musician-list.component';

@Component({
  selector: 'app-home',
  imports: [FiltersComponent, MusicianListComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent {}
