package com.example.apiTienda.services.user.implTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.apiTienda.service.user.impl.JwtServiceImpl;

class JwtServiceImplTest {


    @Mock
    private UserDetails userDetails;

    @InjectMocks
    private JwtServiceImpl jwtService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        jwtService.initializeSigningKey("your_test_signing_key_here");
    }
    @Test
    void testExtractUserName() {
        String token = "your_test_token_here";
        // Mock the behavior of extractClaim method
        when(jwtService.extractClaim(token, claims -> claims.getSubject())).thenReturn("testUsername");

        String extractedUsername = jwtService.extractUserName(token);

        assertEquals("testUsername", extractedUsername);
    }

    @Test
    void testGenerateToken() {
        // Mock UserDetails
        when(userDetails.getUsername()).thenReturn("testUsername");

        // Mock the behavior of generateToken method
        when(jwtService.generateToken(any(), eq(userDetails))).thenReturn("your_generated_token_here");

        String generatedToken = jwtService.generateToken(userDetails);

        assertNotNull(generatedToken);
    }

    @Test
    void testIsTokenValid() {
        String token = "your_test_token_here";
        // Mock UserDetails
        when(userDetails.getUsername()).thenReturn("testUsername");

        // Mock the behavior of extractUserName and isTokenExpired methods
        when(jwtService.extractUserName(token)).thenReturn("testUsername");
        when(jwtService.isTokenExpired(token)).thenReturn(false);

        boolean isValid = jwtService.isTokenValid(token, userDetails);

        assertTrue(isValid);
    }

    @Test
    void testIsTokenInvalid() {
        String token = "your_expired_token_here";
        // Mock UserDetails
        when(userDetails.getUsername()).thenReturn("testUsername");

        // Mock the behavior of extractUserName and isTokenExpired methods
        when(jwtService.extractUserName(token)).thenReturn("testUsername");
        when(jwtService.isTokenExpired(token)).thenReturn(true);

        boolean isValid = jwtService.isTokenValid(token, userDetails);

        assertFalse(isValid);
    }

    // Add more test cases for other methods as needed
}
