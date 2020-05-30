import { MarkaAutomobila } from './markaAutomobila';
import { KlasaAutomobila } from './klasaAutomobila';

export class Vozilo {
    constructor(
        public id: number,
        public  cijena: number,
        public  kilometraza: number,
        public  mozePreci: number,
        public  brSjedista: number,
        public  markaAutomobila: MarkaAutomobila,
        public  vrstaGoriva: string,
        public  tipMjenjaca: string,
        public  klasaAutomobila: KlasaAutomobila,
        public  imaAndroid: boolean,
        public  cdw: boolean
    ){}
}