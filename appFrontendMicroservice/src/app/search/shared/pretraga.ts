import { Marka } from './marka';
import { Gorivo } from './gorivo';
import { Mjenjac } from './mjenjac';
import { Klasa } from './klasa';

export interface Pretraga {
    mjestoPreuzimanja: string;
    od: Date;
    doo: Date;
    marka: Marka;
    gorivo: Gorivo;
    mjenjac: Mjenjac;
    klasa: Klasa;
    cijenaOd: number;
    cijenaDo: number;
    kilometrazaOd: number;
    kilometrazaDo: number;
    kilometrazaDozvoljena: number;
    cdw: boolean;
    brojDjecijihMjesta: number;
}
