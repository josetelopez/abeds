import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../_service/usuario.service';

@Component({
  selector: 'app-board-admin',
  templateUrl: './board-admin.component.html',
  styleUrls: ['./board-admin.component.css']
})
export class BoardAdminComponent implements OnInit {

  content= '';

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.usuarioService.getAdminBoard().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

}
