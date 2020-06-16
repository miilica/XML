const BASE_URL = 'http://localhost:8080';

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

//agent
export const ZAHTJEVI_ZA_VOZILA_URL = `${BASE_URL}/api/zahtjev/allZahtjeve`;
export const VEHICLE_STATUS_TO_RESERVED_URL = `${BASE_URL}/api/zahtjev/toReserved`;
export const VEHICLE_STATUS_TO_CANCELED_URL = `${BASE_URL}/api/zahtjev/toCanceled`;
export const FIND_VEHICLE_BY_ID_URL = `${BASE_URL}/api/zahtjev/findVehicleById`;

//Oglasi
export const USER_ALL_ADS_URL = `${BASE_URL}/oglasi/allAds`;
export const USER_ALL_VEHICLES_URL = `${BASE_URL}/api/vozilo/allVozila`;
export const VEHICLE_TO_CART_URL = `${BASE_URL}/korpa/addVehicleToCart`;
export const ALL_VEHICLEs_IN_CART_URL = `${BASE_URL}/korpa/allVozila`;
export const RENT_A_CAR_REQUEST_URL = `${BASE_URL}/korpa/rentACarRequest`;
export const RENT_A_CAR_BUNDLE_REQUEST_URL = `${BASE_URL}/korpa/rentACarRequestBundle`;

