package com.client;

import com.generated.PostOglasRequest;
import com.generated.PostOglasResponse;
import com.generated.TOglas;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class OglasClient extends WebServiceGatewaySupport {

    public PostOglasResponse postOglas(TOglas tOglas) {
        PostOglasRequest request = new PostOglasRequest();
        request.setOglasRequest(tOglas);

        PostOglasResponse response = (PostOglasResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8086/oglas-soap/oglas", request,
                        new SoapActionCallback("https://ftn.uns.ac.rs/oglas/PostOglasRequest"));

        return response;
    }
}
