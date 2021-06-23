import { Injectable } from '@angular/core';


const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';

@Injectable({
  providedIn: 'root'
})

export class TokenStorageService {

  constructor() { }

  /** Metodo para cerrar session */
  signOut() {
    window.sessionStorage.clear();
  }

  /** Metodo para salvar el token en la session */
  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  /** Metodo para mostrar el token_key */
  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }

  /** Metodo para salvar el user */
  public saveUser(user) {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }

  /** Metodo para mostrar el usuario */
  public getUser() {
    return JSON.parse(sessionStorage.getItem(USER_KEY));
  }
}
