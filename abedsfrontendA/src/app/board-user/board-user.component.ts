import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario';
import { UsuarioService } from '../_service/usuario.service';
import { TipoUsuarioService } from '../_service/tipo-usuario.service';
import { TipoUsuario } from '../models/tipoUsuario';

@Component({
  selector: 'app-board-user',
  templateUrl: './board-user.component.html',
  styleUrls: ['./board-user.component.css']
})
export class BoardUserComponent implements OnInit {

  listaUsuarios:Observable<Usuario>;
  listaTipoUsuarios:Observable<TipoUsuario>;

  constructor(private usuarioService: UsuarioService, private tipoUsuarioService: TipoUsuarioService) { }

  ngOnInit() {
    //Controlar el rol:

    //Cargamos los datos en la lista de usuarios
    this.usuarioService.getPublicContent().subscribe(
      data => {
        this.listaUsuarios = data;
      },
      err => { 
        this.listaUsuarios = JSON.parse(err.error).message;
      }
    );

    //Cargamos los datos en la lista de tipos de usuarios 
    this.tipoUsuarioService.findTipoUsuariosAlta().subscribe(
      dataTpUsuario => {
        this.listaTipoUsuarios = dataTpUsuario;
      },
      err => { 
        this.listaTipoUsuarios = JSON.parse(err.error).message;
      }
    );
    

    }

    

}
