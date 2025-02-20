export type StateType = {
  state: string;
  cities: CityType[];
};
export type CityType = {
  city: string;
  neighborhoods: NeighborhoodType[];
};
export type NeighborhoodType = {
  neighborhood: string;
  streets: string[];
};
export type AddressType = {
  state?: string;
  city?: string;
  neighborhood?: string;
  street?: string;
  postcode?: string;
};
