import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { Component, WritableSignal, computed, signal } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { MatChipInputEvent, MatChipsModule } from '@angular/material/chips';
import { MatSelectChange, MatSelectModule } from '@angular/material/select';
import {
  MusicianInstrumentType,
  MusicianType,
} from '../../types/musician.type';

import { AddressService } from '../../services/address/address.service';
import { EnumType } from '../../types/enum.type';
import { InstrumentService } from '../../services/instrument/instrument.service';
import { LoginService } from '../../services/login/login.service';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { RegisterService } from '../../services/register/register.service';
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
    MatChipsModule,
    MatIconModule,
    MatListModule,
  ],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {
  loadingAddress = false;
  addressTimeout: number = 0;
  instruments: WritableSignal<EnumType[]> = signal([]);
  currentInstrument: WritableSignal<string> = signal('');
  form = new FormGroup({
    firstName: new FormControl<string>('', Validators.required),
    lastName: new FormControl<string>('', Validators.required),
    email: new FormControl<string>('', Validators.required),
    password: new FormControl<string>('', Validators.required),
    instruments: new FormBuilder().array<MusicianInstrumentType>([]),
    address: new FormGroup({
      state: new FormControl<string>(''),
      city: new FormControl<string>(''),
      neighborhood: new FormControl<string>(''),
      street: new FormControl<string>(''),
      postcode: new FormControl<string>(''),
    }),
  });
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  readonly filteredInstruments = computed(() => {
    console.log(this.currentInstrument);

    const currentInstrument = this.currentInstrument().toLowerCase();

    return currentInstrument
      ? this.instruments().filter((instrument) =>
          instrument.description.includes(currentInstrument)
        )
      : this.instruments().filter(
          (instrument) =>
            !this.form.value.instruments
              ?.map((i) => i?.instrument?.id)
              .includes(instrument.id)
        );
  });

  constructor(
    private router: Router,
    private loginService: LoginService,
    private instrumentService: InstrumentService,
    private registerService: RegisterService,
    private addressService: AddressService
  ) {
    this.instrumentService.findAll().subscribe((instruments) => {
      this.instruments.set(instruments);
      this.filteredInstruments;
    });
    if (loginService.getId()) {
      this.router.navigate(['/home']);
    }
  }

  onSubmit() {
    this.registerService
      .create(this.form.value as MusicianType)
      .subscribe((created) => {
        this.loginService.idLoggedObserver.emit(created?.id);
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

  teste(e: any) {
    console.log(e);
  }

  add(event: MatChipInputEvent): void {
    const value = (event.value || '').trim();
    console.log(value);

    // Add our fruit
    if (value) {
      // this.form.controls.instruments.push(value);
    }

    // Clear the input value
    this.currentInstrument.set('');
  }

  remove(instrument: EnumType): void {
    /* this.form.controls.instruments.fin (instruments => {
      const index = instruments.indexOf(fruit);
      if (index < 0) {
        return instruments;
      }

      instruments.splice(index, 1);
      this.announcer.announce(`Removed ${fruit}`);
      return [...instruments];
    }); */
  }

  selected(event: MatSelectChange): void {
    console.log(event);

    const value = event.value as EnumType;
    this.form.controls.instruments.push(
      new FormGroup({
        id: new FormControl<string>(''),
        instrument: new FormControl<EnumType | undefined>(
          value,
          Validators.required
        ),
        main: new FormControl<boolean>(false),
      }) as any
    );

    this.currentInstrument.set('');
  }
}
