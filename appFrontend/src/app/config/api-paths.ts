const BASE_URL = 'http://localhost:8089';

// Auth
export const LOGIN_URL = `${BASE_URL}/auth/login`;

// Users
export const USERS_URL = `${BASE_URL}/api/users`;
export const REGISTER_URL = `${USERS_URL}/public/register`;
export const VERIFY_ACC_URL = `${USERS_URL}/public/verify-account`;
export const PAY_FOR_RENT_A_CAR_REQUEST_URL = `${USERS_URL}/payForRent`;

//Admin
export const ADMIN_ALL_USERS_URL = `${BASE_URL}/api/users/user/all`;
export const ADMIN_ALL_KORISNIKE_URL = `${BASE_URL}/api/users/user/allKorisnike`;
export const ADMIN_DELETE_KORISNIKA_URL = `${BASE_URL}/api/users`;
export const ADMIN_ACTIVATE_KORISNIKA_URL = `${BASE_URL}/api/users/activate`;
export const ADMIN_ALL_COMMENTS_URL = `${BASE_URL}/api/users/allComments`;
export const ADMIN_ACTIVATE_COMMENT_KORISNIKA_URL = `${BASE_URL}/api/users/activateComment`;

//agent
export const ZAHTJEVI_ZA_VOZILA_URL = `${BASE_URL}/api/zahtjev/allZahtjeve/kaca`;
export const VEHICLE_STATUS_TO_RESERVED_URL = `${BASE_URL}/api/zahtjev/toReserved`;
export const VEHICLE_STATUS_TO_RESERVED_BUNDLE_URL = `${BASE_URL}/api/zahtjev/toReservedBundle`;
export const VEHICLE_STATUS_TO_CANCELED_URL = `${BASE_URL}/api/zahtjev/toCanceled`;
export const FIND_VEHICLE_BY_ID_URL = `${BASE_URL}/api/zahtjev/findVehicleById`;
export const AGENT_ALL_TERMINI_URL = `${BASE_URL}/api/vozilo/user/agent/allTermineIznajmljivanja`;
export const AGENT_ADD_KM_VEHICLE_URL = `${BASE_URL}/api/vozilo/user/agent/dodajKM`;


//Oglasi
export const USER_ALL_ADS_URL = `${BASE_URL}/oglasi/allAds`;
export const USER_ALL_VEHICLES_URL = `${BASE_URL}/api/vozilo/allVozila/kaca`;
export const VEHICLE_TO_CART_URL = `${BASE_URL}/korpa/addVehicleToCart`;
export const ALL_VEHICLEs_IN_CART_URL = `${BASE_URL}/korpa/allVozila`;
export const RENT_A_CAR_REQUEST_URL = `${BASE_URL}/korpa/rentACarRequest`;
export const RENT_A_CAR_BUNDLE_REQUEST_URL = `${BASE_URL}/korpa/rentACarRequestBundle`;
export const USER_RATE_COMMENT_URL = `${BASE_URL}/api/zahtjev/allZahtjeveRateComment`;
export const USER_RATE_VEHICLE_URL = `${BASE_URL}/api/zahtjev/rateVehicle`;
export const USER_COMMENT_VEHICLE_URL = `${BASE_URL}/api/zahtjev/commentVehicle`;

//zauzece
export const GET_ALL_VOZILO_AGENT = `${BASE_URL}/api/vozilo/getVozilaAgent`;


//poruke
export const PORUKE_HOME_PAGE = `${BASE_URL}/api/poruke`;

