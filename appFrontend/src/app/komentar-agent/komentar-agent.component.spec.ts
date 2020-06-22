import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { KomentarAgentComponent } from './komentar-agent.component';

describe('KomentarAgentComponent', () => {
  let component: KomentarAgentComponent;
  let fixture: ComponentFixture<KomentarAgentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ KomentarAgentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(KomentarAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
