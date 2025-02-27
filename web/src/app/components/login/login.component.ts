import { Component, inject } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { LoginService } from '../../services/login/login.service';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatButtonModule,
    MatInputModule,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  private _snackBar = inject(MatSnackBar);
  form = new FormGroup({
    email: new FormControl<string>('', [Validators.required, Validators.email]),
    password: new FormControl<string>('', Validators.required),
  });

  constructor(private router: Router, private loginService: LoginService) {
    if (loginService.getId()) {
      this.router.navigate(['/home']);
    }
  }

  onSubmit() {
    this.loginService
      .login(
        this.form.value.email as string,
        this.form.value.password as string
      )
      .subscribe({
        next: (value) => {
          this.loginService.setId(value);
          this.router.navigate(['/home']);
        },
        error: (err) => {
          this._snackBar.open('Invalid credentials.', undefined, {
            duration: 3000,
          });
        },
      });
  }

  goToRegister() {
    this.router.navigate(['/register']);
  }
}
