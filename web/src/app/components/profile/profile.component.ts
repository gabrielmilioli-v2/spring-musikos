import { Component, Input, OnInit, inject } from '@angular/core';

import { LoginService } from '../../services/login/login.service';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';
import { MusicianService } from '../../services/musician/musician.service';
import { MusicianType } from '../../types/musician.type';
import { NotInformedPipe } from '../../pipes/not-informed';

@Component({
  selector: 'app-profile',
  imports: [NotInformedPipe, MatChipsModule, MatIconModule],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css',
})
export class ProfileComponent implements OnInit {
  idMusician: string | undefined;
  isMine: boolean = false;
  musician: MusicianType | undefined;

  @Input()
  set id(idMusician: string) {
    this.idMusician = idMusician;
  }

  private readonly loginService = inject(LoginService);
  private readonly musicianService = inject(MusicianService);

  ngOnInit(): void {
    if (!this.idMusician) {
      this.idMusician = this.loginService.getId();
      this.isMine = true;
    }

    this.musicianService.findById(this.idMusician).subscribe({
      next: (value) => {
        value.instruments = value.instruments.sort(function (a: any, b: any) {
          return a.favorite === b.favorite ? 0 : a.favorite ? -1 : 1;
        });
        this.musician = value;
      },
    });
  }
}
