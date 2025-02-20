import { EventEmitter, Injectable } from '@angular/core';

import { AddressType } from '../../types/address.type';

@Injectable()
export class FilterService {
  observer = new EventEmitter<AddressType>();
}
