import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'poketype'
})
export class PoketypePipe implements PipeTransform {

  //the transform() function in a pipe is what formats the value we want to format
  transform(value:string): string {
    return " & " + value; 
  }

}
