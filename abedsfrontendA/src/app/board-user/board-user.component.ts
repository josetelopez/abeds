import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario';
import { UsuarioService } from '../_service/usuario.service';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {

  listaUsuarios:Observable<Usuario>;

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit() {
    //Controlar el rol:

    this.usuarioService.getPublicContent().subscribe(
      data => {
        this.listaUsuarios = data;
      },
      err => { 
        this.listaUsuarios = JSON.parse(err.error).message;
      }
    );
    }

}
