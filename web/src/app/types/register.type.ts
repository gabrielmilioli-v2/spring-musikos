import { EnumType } from "./enum.type";

export type RegisterType = {
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  instrument: EnumType;
};
