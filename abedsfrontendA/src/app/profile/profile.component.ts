import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from '../_service/token-storage.service';
import { UsuarioService } from '../_service/usuario.service';
import { faSignOutAlt } from '@fortawesome/free-solid-svg-icons';
import { Usuario } from '../models/usuario';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  
  currentUser: any;
  usuario: Usuario;

  constructor(private token: TokenStorageService,private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.currentUser = this.token.getUser();
    this.usuarioService.getUsuarioByNombreUsuario(this.currentUser.username).subscribe(
      data => {
        this.usuario = data;      }
  );
  }

}
