import { AddressType } from './address.type';
import { EnumType } from './enum.type';

export type MusicianType = {
  firstName: string;
  lastName: string;
  email: string;
  about?: string;
  phone?: string;
  instagram?: string;
  instruments: MusicianInstrumentType[];
  address?: AddressType;
};

export type MusicianInstrumentType = {
  instrument: EnumType;
  favorite: boolean;
};
