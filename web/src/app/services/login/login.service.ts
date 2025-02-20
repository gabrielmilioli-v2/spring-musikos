import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  observer = new EventEmitter();

  constructor() {
    this.observer.subscribe(() => this.setLogged());
  }

  logout() {
    localStorage.removeItem('logged');
  }

  setLogged() {
    localStorage.setItem('logged', 'true');
  }

  isLogged() {
    return localStorage.getItem('logged');
  }
}
