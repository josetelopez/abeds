import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from './_service/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  /**Array de los roles. Ahora mismo el usuario solo puede tener un rol */
  private roles:string[];

  /** Booleano Esta logado */
  isLoggedIn  = false;

  /** Booleano para mostrar la parte Admin en la pantalla Home */
  showAdminBoard = false;
 /** Booleano para mostrar la parte Arbitro en la pantalla Home */
  showArbitroBoard = false;
   /** Booleano para mostrar la parte Jugador en la pantalla Home */
  showJugadorBoard = false;
   /** Booleano para mostrar la parte Rep Sede en la pantalla Home */
  showRepSedeBoard = false;
   /** Booleano para mostrar la parte Entrenador en la pantalla Home */
  showEntrenadoBoard = false;


  /** Nombre usuario logado */
  username: string;
  /** Titulo */
  title = 'abedsfrontendA';

  /**Constructor por parametro el service del token */
  constructor(private tokenStorageService: TokenStorageService) { }

  /**Metodo inicial */
  ngOnInit() {
    /**Recogemos el valor del token */
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    /** Comprobamos que si esta logado */
    if (this.isLoggedIn) {

      /**User */
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;

      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showArbitroBoard = this.roles.includes('ROLE_ARB');
      this.showArbitroBoard = this.roles.includes('ROLE_JUG');
      this.showArbitroBoard = this.roles.includes('ROLE_RESP_SEDE');      
      this.showArbitroBoard = this.roles.includes('ROLE_ENTR');
      this.username = user.username;
    }
  }

  /** Log out */
    logout() {
      this.tokenStorageService.signOut();
      window.location.reload();
    }
}
