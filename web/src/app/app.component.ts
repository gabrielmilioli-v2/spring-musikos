import { Router, RouterOutlet } from '@angular/router';

import { Component } from '@angular/core';
import { LoginService } from './services/login/login.service';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, MatToolbarModule, MatButtonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'musikos';
  isLogged = false;

  constructor(private router: Router, private loginService: LoginService) {
    this.loginService.observer.subscribe((value) => (this.isLogged = value));
  }

  logout() {
    this.loginService.observer.emit(false);
    this.goToLogin();
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }
}
