package com.example.xmlserviceoglas.endpoints;

import com.example.xmlserviceoglas.generated.PostOglasRequest;
import com.example.xmlserviceoglas.generated.PostOglasResponse;
import com.example.xmlserviceoglas.services.OglasService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Slf4j
public class OglasEndpoint {
    private static final String NAMESPACE_URI = "https://ftn.uns.ac.rs/oglas";

    private OglasService oglasService;

    @Autowired
    public OglasEndpoint(OglasService oglasService) {
        this.oglasService = oglasService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PostOglasRequest")
    @ResponsePayload
    public PostOglasResponse newAd(@RequestPayload PostOglasRequest oglasRequest) {
        PostOglasResponse oglasResponse = new PostOglasResponse();
        oglasResponse.setOglasResponse(this.oglasService.noviOglas(oglasRequest));
        return oglasResponse;
    }
}
