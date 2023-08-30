package com.bdjpa.db_jpa.functions;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.bdjpa.db_jpa.REST_testes.objetos.ViaCepResponse;
//import com.bdjpa.db_jpa.REST_testes.objetos.noti_cep_objeto;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ceprequest {

    public ViaCepResponse cep(String cep) {
        String viaCepUrl = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(viaCepUrl))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();

            ObjectMapper objectMapper = new ObjectMapper();
            ViaCepResponse viaCepResponse = objectMapper.readValue(responseBody, ViaCepResponse.class);
            return viaCepResponse;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            
            ViaCepResponse cepNull = new ViaCepResponse();
            cepNull.setCep(cep);
            cepNull.setLogradouro(null);
            cepNull.setComplemento(null);
            cepNull.setBairro(null);
            cepNull.setLocalidade(null);
            cepNull.setUf(null);
            cepNull.setIbge(null);
            cepNull.setGia(null);
            cepNull.setDdd(null);
            cepNull.setSiafi(null);
            
            return cepNull;
        }
    }
}

