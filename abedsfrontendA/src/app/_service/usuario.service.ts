import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario';

const API_URL = 'http://localhost:8081/usuario/';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'allUsuario', { responseType: 'json' });
  }

  getUsuarioByNombreUsuario(nombreUsuario:string) :  Observable<any>{
    return this.http.get(API_URL + 'findUserByNombreUsuario/' + nombreUsuario, { responseType: 'json' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'json' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'json' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'json' });
  }

 
}
