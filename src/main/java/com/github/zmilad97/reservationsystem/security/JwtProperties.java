package com.github.zmilad97.reservationsystem.security;

public class JwtProperties {
    public static final String SECRET = "Reservation-System";
    public static final int EXPIRATION_TIME = 86400000;//10days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";


}
