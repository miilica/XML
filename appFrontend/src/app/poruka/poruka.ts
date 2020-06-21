export class Poruka{
    constructor(
        public id : number,

        public sadrzaj : string,

        public datum : Date,

        public posiljalacId : number,

        public primalacId : number,

        public oglasId : number
    ){}
}