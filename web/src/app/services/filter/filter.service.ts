import { EventEmitter, Injectable } from '@angular/core';

import { AddressFilter } from '../../types/address.type';

@Injectable()
export class FilterService {
  observer = new EventEmitter<AddressFilter>();
}
