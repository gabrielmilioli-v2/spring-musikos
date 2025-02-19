import { Component, OnInit } from '@angular/core';

import { FilterService } from '../../services/filter/filter.service';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';

@Component({
  selector: 'app-musician-list',
  imports: [MatListModule, MatIconModule, MatButtonModule],
  templateUrl: './musician-list.component.html',
  styleUrl: './musician-list.component.css',
})
export class MusicianListComponent implements OnInit {
  messages = [
    {
      from: 'asdasd',
      subject: 'asdasd',
      content: 'sadasd'
    }
  ];

  constructor(private filterService: FilterService) {}

  ngOnInit(): void {
    this.filterService.observer.subscribe((value) => {
      console.log(value);
    });
  }
}
