import { EventEmitter, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  observer = new EventEmitter();

  constructor() {
    this.observer.subscribe((isLogged) => {
      if (isLogged) {
        this.setLogged();
        return;
      }

      this.logout();
    });
  }

  logout() {
    localStorage.removeItem('logged');
    localStorage.removeItem('id');
  }

  setId(id: string) {
    localStorage.setItem('id', id);
  }

  getId() {
    return localStorage.getItem('id');
  }

  setLogged() {
    localStorage.setItem('logged', 'true');
  }

  isLogged() {
    return localStorage.getItem('logged');
  }
}
