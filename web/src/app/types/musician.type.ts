import { AddressType } from './address.type';
import { EnumType } from './enum.type';

export type MusicianType = {
  firstName: string;
  lastName: string;
  email: string;
  description?: string;
  instruments: MusicianInstrumentType[];
  address?: AddressType;
};

export type MusicianInstrumentType = {
  instrument: EnumType;
  main: boolean;
};
