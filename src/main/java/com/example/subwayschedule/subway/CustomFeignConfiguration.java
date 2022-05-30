package com.example.subwayschedule.subway;

import feign.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@Configuration
public class CustomFeignConfiguration {

    @Bean
    public feign.Client client() throws NoSuchAlgorithmException, KeyManagementException {
        return new Client.Default(sslContextFactory(), (hostname, session) -> true);
    }

    private SSLSocketFactory sslContextFactory() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslCtx = SSLContext.getInstance("TLS");
        TrustManager[] certs = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{};
                    }
                }
        };
        sslCtx.init(null, certs, new SecureRandom());
        return sslCtx.getSocketFactory();
    }
}
