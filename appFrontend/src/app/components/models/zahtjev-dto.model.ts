import UserRegistrationDTO from './user-registration-dto.model';
import AgentDTO from './agent-dto.model';
import { Vozilo } from '../dodajVozilo/vozilo';

export default interface ZahtjevDTO {
    id: number;
    agent: AgentDTO;
    bungle: boolean;
    datumKreiranja: Date;
    potvrdjen: boolean;
    userIzdao: UserRegistrationDTO;
    userPoslao: UserRegistrationDTO;
    zahtjevStatus: String;
    vozilo: Vozilo;
}