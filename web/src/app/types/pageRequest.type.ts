export type PageRequestType = {
  sort: string;
  page: number;
  size: number;
};

export const PageRequestDefault = {
  sort: '',
  page: 0,
  size: 10,
} as PageRequestType;
