import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardUserComponent } from './board-user.component';

describe('BoardUserComponent', () => {
  let component: BoardUserComponent;
  let fixture: ComponentFixture<BoardUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BoardUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  $('#myModal').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
  })

});
