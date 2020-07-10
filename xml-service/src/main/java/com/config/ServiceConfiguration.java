package com.config;

import com.client.OglasClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ServiceConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.generated");
        return marshaller;
    }

    @Bean
    public OglasClient oglasClient(Jaxb2Marshaller marshaller) {
        OglasClient oglasClient = new OglasClient();
        oglasClient.setDefaultUri("http://localhost:8086/oglas-soap");
        oglasClient.setMarshaller(marshaller);
        oglasClient.setUnmarshaller(marshaller);
        return oglasClient;
    }
}
