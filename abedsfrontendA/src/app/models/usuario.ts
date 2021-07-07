
import { TipoUsuario } from '../models/tipoUsuario';
import { Direccion } from './direccion';

export class Usuario{

    idUsuario: number;
    tipoUsuario:TipoUsuario;
    nombreUsuario:string;
    contrasenna:string;
    nombre:string;
    apellido1:string;
    apellido2:string;
    nif:string;
    idDireccion:Direccion;
    activo:string;
    telefono1:string;
    telefono2:string;
    email:string;

}