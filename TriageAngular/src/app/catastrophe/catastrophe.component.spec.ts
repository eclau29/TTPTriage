import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CatastropheComponent } from './catastrophe.component';

describe('CatastropheComponent', () => {
  let component: CatastropheComponent;
  let fixture: ComponentFixture<CatastropheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CatastropheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CatastropheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
