import { AddressType, StateType } from '../../types/address.type';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AddressService {
  constructor(private http: HttpClient) {}

  findByPostcode(postcode: string): Observable<AddressType> {
    return this.http.get<AddressType>(`addresses/${postcode}`);
  }

  findAll(): Observable<StateType[]> {
    return this.http.get<StateType[]>('addresses');
  }
}
