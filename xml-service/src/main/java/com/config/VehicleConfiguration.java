package com.config;

import com.client.VehicleClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class VehicleConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.generated");
        return marshaller;
    }

    @Bean
    public VehicleClient vehicleClient(Jaxb2Marshaller marshaller) {
        VehicleClient vehicleClient = new VehicleClient();
        vehicleClient.setDefaultUri("http://localhost:8089/vehicle-soap");
        vehicleClient.setMarshaller(marshaller);
        vehicleClient.setUnmarshaller(marshaller);
        return vehicleClient;
    }
}
