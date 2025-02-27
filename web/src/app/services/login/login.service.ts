import { EventEmitter, Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  idLoggedObserver = new EventEmitter();

  constructor(private http: HttpClient) {
    this.idLoggedObserver.subscribe((id) => {
      if (id) {
        this.setId(id);
        return;
      }

      this.logout();
    });
  }

  login(email: string, password: string): Observable<string> {
    return this.http.post<string>(`login?email=${email}&password=${password}`, {
      email,
      password,
    });
  }

  logout() {
    localStorage.removeItem('id');
  }

  setId(id: string) {
    localStorage.setItem('id', id);
  }

  getId(): string {
    return localStorage.getItem('id') as string;
  }
}
