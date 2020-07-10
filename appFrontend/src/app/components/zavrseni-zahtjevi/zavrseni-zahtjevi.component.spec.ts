import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZavrseniZahtjeviComponent } from './zavrseni-zahtjevi.component';

describe('ZavrseniZahtjeviComponent', () => {
  let component: ZavrseniZahtjeviComponent;
  let fixture: ComponentFixture<ZavrseniZahtjeviComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZavrseniZahtjeviComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZavrseniZahtjeviComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
