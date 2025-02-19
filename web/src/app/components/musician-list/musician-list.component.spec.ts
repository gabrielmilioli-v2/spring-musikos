import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicianListComponent } from './musician-list.component';

describe('MusicianListComponent', () => {
  let component: MusicianListComponent;
  let fixture: ComponentFixture<MusicianListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MusicianListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MusicianListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
