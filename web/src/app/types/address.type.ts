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