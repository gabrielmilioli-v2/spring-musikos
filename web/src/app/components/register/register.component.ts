import {
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { AddressService } from '../../services/address/address.service';
import { Component } from '@angular/core';
import { EnumType } from '../../types/enum.type';
import { InstrumentService } from '../../services/instrument/instrument.service';
import { LoginService } from '../../services/login/login.service';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { RegisterService } from '../../services/register/register.service';
import { RegisterType } from '../../types/register.type';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
    MatSelectModule,
    MatCheckboxModule,
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  loadingAddress = false;
  addressTimeout: number = 0;
  instruments: EnumType[] = [];
  form = new FormGroup({
    firstName: new FormControl<string>('', Validators.required),
    lastName: new FormControl<string>('', Validators.required),
    email: new FormControl<string>('', Validators.required),
    password: new FormControl<string>('', Validators.required),
    instrument: new FormControl<EnumType | undefined>(
      undefined,
      Validators.required
    ),
    address: new FormGroup({
      state: new FormControl<string>(''),
      city: new FormControl<string>(''),
      neighborhood: new FormControl<string>(''),
      street: new FormControl<string>(''),
      postcode: new FormControl<string>(''),
    }),
  });

  constructor(
    private router: Router,
    private loginService: LoginService,
    private instrumentService: InstrumentService,
    private registerService: RegisterService,
    private addressService: AddressService
  ) {
    this.instrumentService.findAll().subscribe((instruments) => {
      this.instruments = instruments;
    });
    if (loginService.isLogged()) {
      this.router.navigate(['/home']);
    }
  }

  onSubmit() {
    this.registerService
      .create(this.form.value as RegisterType)
      .subscribe((created) => {
        this.loginService.observer.emit(true);
        this.router.navigate(['/home']);
      });
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  handleKeyUpPostcode() {
    if (this.addressTimeout) {
      clearTimeout(this.addressTimeout);
    }

    this.addressTimeout = setTimeout(() => {
      this.getAddressByPostcode();
    }, 2000);
  }

  getAddressByPostcode() {
    this.form.controls.address.controls.postcode.disable();
    this.loadingAddress = true;
    this.addressService
      .findByPostcode(this.form.value.address?.postcode || '')
      .subscribe({
        next: (address) => {
          this.form.controls.address.setValue(address as any, {
            onlySelf: true,
            emitEvent: false,
          });
        },
        error: () => {
          this.loadingAddress = false;
          this.form.controls.address.controls.postcode.enable();
        },
        complete: () => {
          this.loadingAddress = false;
          this.form.controls.address.controls.postcode.enable();
        },
      });
  }
}
