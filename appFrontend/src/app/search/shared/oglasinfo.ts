import { Vozilo } from 'src/app/components/dodajVozilo/vozilo';
import { Cjenovnik } from './cjenovnik';

export interface OglasInfo {
    id: number,
    naziv: string,
    pages: number,
    mjestoPreuzimanja: string,
    od: Date,
    doo: Date,
    dozvoljenaKilometraza: number,
    vozilo: Vozilo,
    cjenovnik: Cjenovnik
}
