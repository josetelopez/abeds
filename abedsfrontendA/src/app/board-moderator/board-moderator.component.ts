import { Component, OnInit } from '@angular/core';
import { Usuario } from '../models/usuario';
import { UsuarioService } from '../_service/usuario.service';

@Component({
  selector: 'app-board-moderator',
  templateUrl: './board-moderator.component.html',
  styleUrls: ['./board-moderator.component.css']
})
export class BoardModeratorComponent implements OnInit {

  usuarios:Usuario[];

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    //Controlar el rol:

    this.usuarioService.getPublicContent().subscribe(
      data => {
        this.usuarios = data;
      },
      err => {
        this.usuarios = JSON.parse(err.error).message;
      }
    );
  }

}

