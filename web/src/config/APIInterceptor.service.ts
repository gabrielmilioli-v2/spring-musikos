import { HttpInterceptorFn } from '@angular/common/http';

export const APIInterceptor: HttpInterceptorFn = (req, next) => {
  const authReq = req.clone({
    url: `http://localhost:8080/api/${req.url}`,
  });
  return next(authReq);
};
