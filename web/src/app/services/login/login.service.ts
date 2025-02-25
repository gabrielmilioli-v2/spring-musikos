import { EventEmitter, Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  observer = new EventEmitter();

  constructor(private http: HttpClient) {
    this.observer.subscribe((isLogged) => {
      if (isLogged) {
        this.setLogged();
        return;
      }

      this.logout();
    });
  }

  checkPassword(email: string, password: string): Observable<void> {
    return this.http.post<void>(
      `login/check-password?email=${email}&password=${password}`,
      { email, password }
    );
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
