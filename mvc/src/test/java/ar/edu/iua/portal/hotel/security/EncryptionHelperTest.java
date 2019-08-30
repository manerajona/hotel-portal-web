package ar.edu.iua.portal.hotel.security;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class EncryptionHelperTest {

    @Test
    public void shouldBeSHA256Equals() throws NoSuchAlgorithmException {
        // Given
        final String PASSWORD = "dollar60";
        final String SHA256 = "93e366ff2a4d4ca483e78f08c429dfc5704d75ec9d063dac604a632fc570b7b1";
        // When
        String sha1 = EncryptionHelper.toSHA256(PASSWORD);
        String sha2 = EncryptionHelper.toSHA256(PASSWORD);
        // Then
        assertEquals(SHA256, sha1, sha2);
    }

}