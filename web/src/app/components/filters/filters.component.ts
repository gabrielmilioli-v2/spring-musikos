import {
  CityType,
  NeighborhoodType,
  StateType,
} from '../../types/address.type';
import { Component, OnInit } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';

@Component({
  selector: 'app-filters',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatButtonModule,
    MatIconModule,
    MatGridListModule,
  ],
  templateUrl: './filters.component.html',
  styleUrl: './filters.component.css',
})
export class FiltersComponent implements OnInit {
  states: StateType[] = [
    {
      state: 'SP',
      cities: [
        {
          city: 'São Paulo',
          neighborhoods: [
            {
              neighborhood: 'Paulista',
              streets: ['Paulista'],
            },
          ],
        },
      ],
    },
  ];

  filtersForm = new FormGroup({
    state: new FormControl<StateType | null>(null, Validators.required),
    city: new FormControl<CityType | null>(null),
    neighborhood: new FormControl<NeighborhoodType | null>(null),
  });

  ngOnInit(): void {
    this.filtersForm.controls.city.disable();
    this.filtersForm.controls.neighborhood.disable();
    this.filtersForm.controls.state.valueChanges.subscribe((state) => {
      this.filtersForm.controls.city.setValue(null);
      if (state) {
        this.filtersForm.controls.city.enable();
      }
    });
    this.filtersForm.controls.city.valueChanges.subscribe((city) => {
      this.filtersForm.controls.neighborhood.setValue(null);
      if (city) {
        this.filtersForm.controls.neighborhood.enable();
      }
    });
  }

  onSubmit() {
    console.warn(this.filtersForm.value);
  }
}
