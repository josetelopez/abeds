import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TipoUsuario}from '../models/tipoUsuario';


const API_URL = 'http://localhost:8081/tipoUsuario/';

@Injectable({
  providedIn: 'root'
})
export class TipoUsuarioService {

  constructor(private http: HttpClient) { }

  getAllTipoUsuarioVisibles(): Observable<any> {
    return this.http.get(API_URL + 'allTipoUsuario', { responseType: 'json' });
  }

  findTipoUsuariosAlta(): Observable<any>{
    return this.http.get(API_URL + 'findTipoUsuarioAlta', { responseType: 'json' });
  }

}
