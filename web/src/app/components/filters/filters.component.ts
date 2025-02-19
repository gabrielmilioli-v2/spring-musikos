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

import { FilterService } from '../../services/filter/filter.service';
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

  form = new FormGroup({
    state: new FormControl<StateType | null>(null, Validators.required),
    city: new FormControl<CityType | null>(null),
    neighborhood: new FormControl<NeighborhoodType | null>(null),
  });

  constructor(private filterService: FilterService) {}

  ngOnInit(): void {
    this.form.controls.city.disable();
    this.form.controls.neighborhood.disable();
    this.form.controls.state.valueChanges.subscribe((state) => {
      this.form.controls.city.setValue(null);
      if (state) {
        this.form.controls.city.enable();
      }
    });
    this.form.controls.city.valueChanges.subscribe((city) => {
      this.form.controls.neighborhood.setValue(null);
      if (city) {
        this.form.controls.neighborhood.enable();
      }
    });
  }

  onSubmit() {
    this.filterService.observer.emit({
      state: this.form.value.state?.state,
      city: this.form.value.city?.city,
      neighborhood: this.form.value.neighborhood?.neighborhood,
    });
    // console.warn(this.form.value);
  }
}
