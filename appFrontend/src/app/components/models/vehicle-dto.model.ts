import { MarkaAutomobila } from '../dodajMarkaAutomobila/markaAutomobila';
import { KlasaAutomobila } from '../dodajKlasaAutomobila/klasaAutomobila';

export default interface VehicleDTO {
    id: number;
    cijena: String;
    kilometraza: String;
    mozePreciKM: String;
    brSjedistaZaDjecu: String;
    ocjena: String;
    markaAutomobila: MarkaAutomobila;
    klasaAutomobila: KlasaAutomobila;
    imaAndroid: boolean;
    coliisionDamageWavier: boolean;
    bundle: boolean;
}