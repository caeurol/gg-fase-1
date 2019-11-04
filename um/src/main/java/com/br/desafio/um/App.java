package com.br.desafio.um;

import java.io.File;
import java.util.Scanner;

public class App {
	
    public static void main( String[] args ) {
        System.out.println("Qual o caminho da pasta?");
        String caminho = scan().nextLine();
        
        File pasta = new File(caminho);
        verificarPasta(pasta);
    }
    
    // SCAN
    public static Scanner scan() {
    	Scanner scan = new Scanner(System.in);
    	return scan;
    }
    
    // ENTRAR NAS PASTAS
    public static void verificarPasta(File caminho) {
    	try {
    		if(caminho != null) {
    			for (File arquivo : caminho.listFiles()) {
    				mostrarArquivos(arquivo);
    			}
    		} else {
    			throw new Exception("Esse não é um repositório válido");
    		}
    	} catch (Exception e) {
    		System.out.println("Erro:" + e.getMessage());
    	}
    }
    
    // EXIBIR ARQUIVOS
    public static void mostrarArquivos(File caminho) {
    	if(caminho.isFile()) {
    		System.out.println("Arquivo encontrado: " + caminho.getName());
    	} else {
    		System.out.println("Pasta encontrada: " + caminho.getName());
    		for (File file : caminho.listFiles()) {
    			mostrarArquivos(file);
    		}
    	}
    }
    
}
