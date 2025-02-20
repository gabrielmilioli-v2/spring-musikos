import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RegisterType } from '../../types/register.type';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  constructor(private http: HttpClient) {}

  create(body: RegisterType): Observable<any> {
    return this.http.post<any>('musicians', body);
  }
}
