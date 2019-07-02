import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchByCategorieComponent } from './search-by-categorie.component';

describe('SearchByCategorieComponent', () => {
  let component: SearchByCategorieComponent;
  let fixture: ComponentFixture<SearchByCategorieComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchByCategorieComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchByCategorieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
