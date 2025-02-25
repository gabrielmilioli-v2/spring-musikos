import { Component } from '@angular/core';
import { LoginService } from '../../services/login/login.service';
import { MatButtonModule } from '@angular/material/button';
import { MatDividerModule } from '@angular/material/divider';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatMenuModule,
    MatDividerModule,
  ],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css',
})
export class HeaderComponent {
  isLogged = false;

  constructor(private router: Router, private loginService: LoginService) {
    this.isLogged = !!this.loginService.isLogged();
    this.checkLogged();
    this.loginService.observer.subscribe((value) => {
      this.isLogged = value;
      this.checkLogged();
    });
  }

  checkLogged() {
    if (!this.isLogged) {
      this.logout();
    }
  }

  logout() {
    this.loginService.observer.emit(false);
    this.goToLogin();
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }

  goToProfile() {
    this.router.navigate(['/profile']);
  }
}
