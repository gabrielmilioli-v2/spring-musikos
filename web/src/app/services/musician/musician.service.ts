import {
  PageRequestDefault,
  PageRequestType,
} from '../../types/pageRequest.type';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MusicianService {
  constructor(private http: HttpClient) {}

  findAll(pageRequest: PageRequestType = PageRequestDefault): Observable<any> {
    return this.http.get<any>('musicians', {
      params: pageRequest,
    });
  }
}
