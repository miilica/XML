import { Vozilo } from 'src/app/components/dodajVozilo/vozilo';

export interface Cjenovnik {
    id: number,
    cijenaPoDanu: number,
    cijenaPoKM: number,
    cijenaCDW: number,
    popust: number,
    userUsername: string
}
