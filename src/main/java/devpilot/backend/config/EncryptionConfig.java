package devpilot.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;

@Configuration
public class EncryptionConfig {

    @SuppressWarnings("deprecation")
    @Bean
    public TextEncryptor textEncryptor(
            @Value("${app.encryption.password}") String password,
            @Value("${app.encryption.salt}") String salt) {

        return Encryptors.delux(password, salt);
    }
}