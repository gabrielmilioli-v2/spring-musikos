import { Component, OnInit } from '@angular/core';

import { FilterService } from '../../services/filter/filter.service';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MusicianService } from '../../services/musician/musician.service';
import { MusicianType } from '../../types/musician.type';

@Component({
  selector: 'app-musician-list',
  imports: [MatCardModule, MatIconModule, MatButtonModule, MatChipsModule],
  templateUrl: './musician-list.component.html',
  styleUrl: './musician-list.component.css',
})
export class MusicianListComponent implements OnInit {
  musicians: MusicianType[] = [];

  constructor(
    private filterService: FilterService,
    private musicianService: MusicianService
  ) {}

  ngOnInit(): void {
    this.filterService.observer.subscribe((value) => {
      console.log(value);
    });
    this.findAll();
  }

  findAll() {
    this.musicianService.findAll().subscribe({
      next: (value) => {
        this.musicians = value?.content as MusicianType[];
      },
    });
  }
}
