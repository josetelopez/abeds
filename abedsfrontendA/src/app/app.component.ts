import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './_service/token-storage.service';
import { UsuarioService } from './_service/usuario.service';
import { faSignOutAlt } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  private roles:string[];
  isLoggedIn  = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;
  title = 'abedsfrontendA';

  faSignOutAlt = faSignOutAlt;


  constructor(private tokenStorageService: TokenStorageService,private usuarioService: UsuarioService) { }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      
      //Nombre completo 
      this.usuarioService.getUsuarioByNombreUsuario(user.username).subscribe(
          data => {
            this.username = data.nombre + ' ' + data.apellido1  + ' ' + data.apellido2;
          }
      );

    }
  }

    logout() {
      this.tokenStorageService.signOut();
      window.location.reload();
    }
}
