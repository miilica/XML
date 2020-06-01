const BASE_URL = 'http://localhost:8080';

// Auth
export const LOGIN_URL = `${BASE_URL}/auth/login`;

// Users
export const USERS_URL = `${BASE_URL}/api/users`;
export const REGISTER_URL = `${USERS_URL}/public/register`;
export const VERIFY_ACC_URL = `${USERS_URL}/public/verify-account`;

//Admin
export const ADMIN_ALL_USERS_URL = `${BASE_URL}/api/users/user/all`;
export const ADMIN_ALL_KORISNIKE_URL = `${BASE_URL}/api/users/user/allKorisnike`;
export const ADMIN_DELETE_KORISNIKA_URL = `${BASE_URL}/api/users`;
export const ADMIN_ACTIVATE_KORISNIKA_URL = `${BASE_URL}/api/users/activate`;