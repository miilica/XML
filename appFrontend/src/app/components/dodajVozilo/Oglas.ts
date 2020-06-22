import { Vozilo } from './vozilo';

export class Oglas {
    constructor(
        public id: number,
        public dostupan: String,
        public vozilo: Vozilo,
        public mestoPreuzimanja: String
    ){}
}