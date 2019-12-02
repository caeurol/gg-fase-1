package com.br.desafio.dois;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Service {
	
	public static String pegarConteudo(String url) throws IOException, InterruptedException {

		HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	    		.uri(URI.create("https://www.reddit.com/r/programming/"))
	    		.build();
	    
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    
	    return response.body();
		
	}

}
