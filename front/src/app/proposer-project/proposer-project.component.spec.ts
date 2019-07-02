import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProposerProjectComponent } from './proposer-project.component';

describe('ProposerProjectComponent', () => {
  let component: ProposerProjectComponent;
  let fixture: ComponentFixture<ProposerProjectComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProposerProjectComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProposerProjectComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
