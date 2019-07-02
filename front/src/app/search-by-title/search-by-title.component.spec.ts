import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchByTitleComponent } from './search-by-title.component';

describe('SearchByTitleComponent', () => {
  let component: SearchByTitleComponent;
  let fixture: ComponentFixture<SearchByTitleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchByTitleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchByTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
