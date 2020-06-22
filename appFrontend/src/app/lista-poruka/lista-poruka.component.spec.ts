import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaPorukaComponent } from './lista-poruka.component';

describe('ListaPorukaComponent', () => {
  let component: ListaPorukaComponent;
  let fixture: ComponentFixture<ListaPorukaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaPorukaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaPorukaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
