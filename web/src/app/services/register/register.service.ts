import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MusicianType } from '../../types/musician.type';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RegisterService {
  constructor(private http: HttpClient) {}

  create(body: MusicianType): Observable<any> {
    return this.http.post<any>('musicians', body);
  }
}
