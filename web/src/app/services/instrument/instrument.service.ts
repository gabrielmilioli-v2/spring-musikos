import { EnumType } from '../../types/enum.type';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class InstrumentService {
  constructor(private http: HttpClient) {}

  findAll(): Observable<EnumType[]> {
    return this.http.get<EnumType[]>('instruments');
  }
}
