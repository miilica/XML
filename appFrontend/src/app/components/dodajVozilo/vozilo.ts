import { MarkaAutomobila } from '../dodajMarkaAutomobila/markaAutomobila';
import { KlasaAutomobila } from '../dodajKlasaAutomobila/klasaAutomobila';
import { TipMjenjaca } from '../tipMjenjaca/tipMjenjaca';
import { TipGoriva } from '../tipGoriva/tipGoriva';
import { Slika } from './Slika';

export class Vozilo {
    constructor(
        public id: number,
        public  cijena: number,
        public  kilometraza: number,
        public  mozePreciKM: number,
        public  brSjedistaZaDjecu: number,
        public  markaAutomobila: MarkaAutomobila,
        public  tipGoriva: TipGoriva,
        public  tipMjenjaca: TipMjenjaca,
        public  klasaAutomobila: KlasaAutomobila,
        public  imaAndroid: boolean,
        public  coliisionDamageWavier: boolean,
        public  ocjena: number,
        public  slike: Slika[]
    ){}
}