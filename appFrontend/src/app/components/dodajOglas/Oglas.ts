
import { User } from 'src/app/services/user';
import { Vozilo } from '../dodajVozilo/vozilo';

export class Oglas {
    constructor(
        public id: number,
        public dostupan: Boolean,
        public vozilo: Vozilo,
        public mestoPreuzimanja: String,
        public fromDate : Date,
        public toDate : Date,
        public userId : number,
        private cjenovnikID : number

    ){}
}