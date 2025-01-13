package com.jonathandiz.screen_match.totp;

import com.warrenstrange.googleauth.GoogleAuthenticator; 
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

public class MfaService {
    private GoogleAuthenticator gAuth = new GoogleAuthenticator();

    public String geberateSecretKey() {
      final GoogleAuthenticatorKey key = gAuth.createCredentials();
      return key.getKey();
    }

    public boolean verifyCode(String secretKey, int verificationCode) {
      return gAuth.authorize(secretKey, verificationCode);
    }
}
