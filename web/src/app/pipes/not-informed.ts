import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'notInformed',
})
export class NotInformedPipe implements PipeTransform {
  transform(value: string | undefined): string {
    return value ?? 'Not informed';
  }
}
