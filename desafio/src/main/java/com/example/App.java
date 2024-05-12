package com.example;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Connection conexao = AnimalDAO.estabelecerConexao();
        AnimalDAO.createTableBovino(conexao);
        List<Bovino> bovinos = new ArrayList<>();
        List<Suino> suinos = new ArrayList<>();
        List<Equino> equinos = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        float totalVendasBovinos = 0;
        float totalVendasSuinos = 0;
        float totalVendasEquinos = 0;
        int totalPerdasBovinos = 0;
        int totalPerdasSuinos = 0;
        int totalPerdasEquinos = 0;
        boolean programa = true;
        while (programa) {
            menu();
            int opcao;
            int idBovino;
            int idSuino;
            int idEquino;
            int numero = input.nextInt();
            switch (numero) {
                case 1:
                    System.out.println();
                    System.out.println("1. Incluir bovino");
                    System.out.println("2. Incluir suino");
                    System.out.println("3. Incluir equino");
                    opcao = input.nextInt();
                    if (opcao == 1){
                        incluirBovino(bovinos, input);
                    }
                    else if (opcao == 2){
                        incluirSuino(suinos, input);
                    }
                    else if (opcao == 3){
                        incluirEquino(equinos, input);
                    }
                    else{
                        System.out.println("Por favor, digite uma das 3 opções! ");
                    }
                    break;
            
                case 2:
                    System.out.println("");
                    System.out.println("1. Consultar bovino");
                    System.out.println("2. Consultar suino");
                    System.out.println("3. Consultar equino");
                    opcao = input.nextInt();
                    if (opcao == 1){
                        System.out.println("Id do bovino: ");
                        idBovino = input.nextInt();
                        consultarBovino(bovinos, idBovino); 
                    }
                    else if (opcao == 2){
                        System.out.println("Id do suíno: ");
                        idSuino = input.nextInt();
                        consultarSuino(suinos, idSuino);
                    }
                    else if (opcao == 3){
                        System.out.println("Id do equino: ");
                        idEquino = input.nextInt();
                        consultarEquino(equinos, idEquino);
                    }
                    else{
                        System.out.println("Por favor, digite uma das 3 opções! ");
                    }
                    break;
            
                case 3:
                    System.out.println("");
                    System.out.println("1. Avaliar bovino");
                    System.out.println("2. Avaliar suino");
                    System.out.println("3. Avaliar equino");
                    opcao = input.nextInt();
                    if (opcao == 1){
                        relatorioBovinos(bovinos);
                        System.out.println();
                        System.out.println("Id do bovino: ");
                        idBovino = input.nextInt();
                        avaliarBovino(bovinos, idBovino, input); 
                    }
                    else if (opcao == 2){
                        relatorioSuinos(suinos);
                        System.out.println();
                        System.out.println("Id do suíno: ");
                        idSuino = input.nextInt();
                        avaliarSuino(suinos, idSuino, input);
                    }
                    else if (opcao == 3){
                        relatorioEquinos(equinos);
                        System.out.println();
                        System.out.println("Id do equino: ");
                        idEquino = input.nextInt();
                        avaliarEquino(equinos, idEquino, input);
                    }
                    else{
                        System.out.println("Por favor, digite uma das 3 opções! ");
                    }
                    break;
            
                case 4:
                    System.out.println("");
                    System.out.println("1. Registrar venda de bovino");
                    System.out.println("2. Registrar venda de suino");
                    System.out.println("3. Registrar venda de equino");
                    opcao = input.nextInt();
                    if (opcao == 1){
                        relatorioBovinos(bovinos);
                        System.out.println("");
                        System.out.println("Id do bovino: ");
                        idBovino = input.nextInt();
                        totalVendasBovinos = registrarVendaBovino(bovinos, idBovino, input, totalVendasBovinos); 
                    }
                    else if (opcao == 2){
                        relatorioSuinos(suinos);
                        System.out.println("");
                        System.out.println("Id do suino: ");
                        idSuino = input.nextInt();
                        totalVendasSuinos = registrarVendaSuino(suinos, idSuino, input, totalVendasSuinos); 
                    }
                    else if (opcao == 3){
                        relatorioEquinos(equinos);
                        System.out.println("");
                        System.out.println("Id do equino: ");
                        idEquino = input.nextInt();
                        totalVendasEquinos = registrarVendaEquino(equinos, idEquino, input, totalVendasEquinos); 
                    }
                    else{
                        System.out.println("Por favor, digite uma das 3 opções! ");
                    }
                    break;
            
                case 5:
                    System.out.println("");
                    System.out.println("1. Registrar perda de bovino");
                    System.out.println("2. Registrar perda de suino");
                    System.out.println("3. Registrar perda de equino");
                    opcao = input.nextInt();
                    if (opcao == 1){
                        relatorioBovinos(bovinos);
                        System.out.println("");
                        System.out.println("Id do bovino: ");
                        idBovino = input.nextInt();
                        totalPerdasBovinos = registrarPerdaBovino(bovinos, idBovino, totalPerdasBovinos); 
                    }
                    else if (opcao == 2){
                        relatorioSuinos(suinos);
                        System.out.println("");
                        System.out.println("Id do suino: ");
                        idSuino = input.nextInt();
                        totalPerdasSuinos = registrarPerdaSuino(suinos, idSuino, totalPerdasSuinos); 
                    }
                    else if (opcao == 3){
                        relatorioEquinos(equinos);
                        System.out.println("");
                        System.out.println("Id do equino: ");
                        idEquino = input.nextInt();
                        totalPerdasEquinos = registrarPerdaEquino(equinos, idEquino, totalPerdasEquinos); 
                    }
                    else{
                        System.out.println("Por favor, digite uma das 3 opções! ");
                    }
                    break;
            
                case 6:
                    System.out.println("");
                    System.out.println("1. Relatório de bovinos");
                    System.out.println("2. Relatório de suinos");
                    System.out.println("3. Relatório de equinos");
                    opcao = input.nextInt();
                    if (opcao == 1){
                        relatorioBovinos(bovinos);
                    }
                    else if (opcao == 2){
                        relatorioSuinos(suinos);
                    }
                    else if (opcao == 3){
                        relatorioEquinos(equinos);
                    }
                    else{
                        System.out.println("Por favor, digite uma das 3 opções! ");
                    }
                    break;
            
                case 7:
                    System.out.println("");
                    System.out.println("1. Relatório de vendas de bovinos");
                    System.out.println("2. Relatório de vendas de suinos");
                    System.out.println("3. Relatório de vendas de equinos");
                    opcao = input.nextInt();
                    if (opcao == 1){
                        relatorioVendasBovino(bovinos, totalVendasBovinos);
                    }
                    else if (opcao == 2){
                        relatorioVendasSuino(suinos, totalVendasSuinos);
                    }
                    else if (opcao == 3){
                        relatorioVendasEquino(equinos, totalVendasEquinos);
                    }
                    else{
                        System.out.println("Por favor, digite uma das 3 opções! ");
                    }
                    break;
            
                case 8:
                    System.out.println("");
                    System.out.println("1. Relatório de perdas d1e bovinos");
                    System.out.println("2. Relatório de perdas de suinos");
                    System.out.println("3. Relatório de perdas de equinos");
                    opcao = input.nextInt();
                    if (opcao == 1){
                        relatorioPerdasBovino(bovinos, totalPerdasBovinos);
                    }
                    else if (opcao == 2){
                        relatorioPerdasSuino(suinos, totalPerdasSuinos);
                    }
                    else if (opcao == 3){
                        relatorioPerdasEquino(equinos, totalPerdasEquinos);
                    }
                    else{
                        System.out.println("Por favor, digite uma das 3 opções! ");
                    }
                        break;
            
                case 9:
                    programa = false;
                    System.out.println("Você saiu do programa! ");
                    break;
            
                default:
                    System.out.println("Digite uma opção correta! ");
                    break;
            }
        }
    }

    public static void menu(){
        System.out.println();
        System.out.println("***************************Programa controle dos animais ***************************");
        System.out.println("1. Incluir animal");
        System.out.println("2. Consultar animal");
        System.out.println("3. Avaliar animal");
        System.out.println("4. Registrar venda");
        System.out.println("5. Registrar perda");
        System.out.println("6. Relatório animais por tipo");
        System.out.println("7. Relatório vendas");
        System.out.println("8. Relatório perdas");
        System.out.println("9. Sair");
    }

    public static void incluirBovino(List<Bovino> bovinos, Scanner input){
        System.out.println("Quantos bovinos você deseja adicionar? ");
        int adicionar = input.nextInt();
        System.out.println("");
        for(int i = 0; i < adicionar; i++){
            System.out.println("Bovino " + (i+1));
            System.out.println("Altura: ");
            float altura = input.nextFloat();
            System.out.println("Comprimento: ");
            float comprimento = input.nextFloat();
            System.out.println("Largura: ");
            float largura = input.nextFloat();
            System.out.println("Peso: ");
            float peso = input.nextFloat();
            System.out.println();
            Bovino bovino = new Bovino(altura, comprimento, largura, peso);
            bovinos.add(bovino);
        }
        
    }

    public static void incluirSuino(List<Suino> suinos, Scanner input){
        System.out.println("Quantos suínos você deseja adicionar? ");
        int adicionar = input.nextInt();
        System.out.println("");
        for(int i = 0; i < adicionar; i++){
            System.out.println("Suíno " + (i+1));
            System.out.println("Altura: ");
            float altura = input.nextFloat();
            System.out.println("Comprimento: ");
            float comprimento = input.nextFloat();
            System.out.println("Largura: ");
            float largura = input.nextFloat();
            System.out.println("Peso: ");
            float peso = input.nextFloat();
            System.out.println();
            Suino suino = new Suino(altura, comprimento, largura, peso);
            suinos.add(suino);
        }

    }

    public static void incluirEquino(List<Equino> equinos, Scanner input){
        System.out.println("Quantos equinos você deseja adicionar? ");
        int adicionar = input.nextInt();
        System.out.println("");
        for(int i = 0; i < adicionar; i++){
            System.out.println("Equino " + (i+1));
            System.out.println("Altura: ");
            float altura = input.nextFloat();
            System.out.println("Comprimento: ");
            float comprimento = input.nextFloat();
            System.out.println("Largura: ");
            float largura = input.nextFloat();
            System.out.println("Peso: ");
            float peso = input.nextFloat();
            System.out.println();
            Equino equino = new Equino(altura, comprimento, largura, peso);
            equinos.add(equino);
        }

    }

    public static void relatorioBovinos(List<Bovino> bovinos){
        System.out.println("Relatório dos Bovinos");
        for (Bovino bovino : bovinos){ // For que itera sobre cada bovino na lista de bovinos
            if(bovino.getStatus().equals("Ativo")){
                System.out.println("ID: " + bovino.getId() + ", Altura: " + bovino.getAltura() + "m" + ", Comprimento: " + bovino.getComprimento() + "m" + ", Largura: " + bovino.getLargura() + "m" + ", Peso: " + bovino.getPeso() + "Kg" + ", Status: " + bovino.getStatus());
            }
        }
    }

    public static void relatorioSuinos(List<Suino> suinos){
        System.out.println("Relatório dos Suínos");
        for (Suino suino : suinos){ // For que itera sobre cada suíno na lista de suínos
            if(suino.getStatus().equals("Ativo")){
                System.out.println("ID: " + suino.getId() + ", Altura: " + suino.getAltura() + "m" + ", Comprimento: " + suino.getComprimento() + "m" + ", Largura: " + suino.getLargura() + "m" + ", Peso: " + suino.getPeso() + "Kg" + ", Status: " + suino.getStatus());
            }
        }
    }

    public static void relatorioEquinos(List<Equino> equinos){
        System.out.println("Relatório dos Equinos");
        for (Equino equino : equinos){ // For que itera sobre cada Equino na lista de Equinos
            if(equino.getStatus().equals("Ativo")){
                System.out.println("ID: " + equino.getId() + ", Altura: " + equino.getAltura() + "m" + ", Comprimento: " + equino.getComprimento() + "m" + ", Largura: " + equino.getLargura() + "m" + ", Peso: " + equino.getPeso() + "Kg" + ", Status: " + equino.getStatus());
            }
        }
    }

    public static void consultarBovino(List<Bovino> bovinos, int id){
        for (Bovino bovino : bovinos) {
            if (bovino.getId() == id) {
                System.out.println("ID: " + bovino.getId() + ", Altura: " + bovino.getAltura() + "m" + ", Comprimento: " + bovino.getComprimento() + "m" + ", Largura: " + bovino.getLargura() + "m" + ", Peso: " + bovino.getPeso() + "Kg" + ", Status: " + bovino.getStatus());    
            }
            else {
                System.out.println("Por favor, informe um id válido! ");
            }
        }
    }

    public static void consultarSuino(List<Suino> suinos, int id){
        for (Suino suino : suinos) {
            if (suino.getId() == id) {
                System.out.println("ID: " + suino.getId() + ", Altura: " + suino.getAltura() + "m" + ", Comprimento: " + suino.getComprimento() + "m" + ", Largura: " + suino.getLargura() + "m" + ", Peso: " + suino.getPeso() + "Kg" + ", Status: " + suino.getStatus());   
            }
            else {
                System.out.println("Por favor, informe um id válido! ");
            }
        }
    }

    public static void consultarEquino(List<Equino> equinos, int id){
        for (Equino equino : equinos) {
            if (equino.getId() == id) {
                System.out.println("ID: " + equino.getId() + ", Altura: " + equino.getAltura() + "m" + ", Comprimento: " + equino.getComprimento() + "m" + ", Largura: " + equino.getLargura() + "m" + ", Peso: " + equino.getPeso() + "Kg" + ", Status: " + equino.getStatus());    
            }
            else {
                System.out.println("Por favor, informe um id válido! ");
            }
        }
    }

    public static void avaliarBovino(List<Bovino> bovinos, int id, Scanner input){
        System.out.println();
        System.out.println("Nova altura: ");
        float novaAltura = input.nextFloat();
        System.out.println("Novo comprimento: ");
        float novoComprimento = input.nextFloat();
        System.out.println("Nova largura: ");
        float novaLargura = input.nextFloat();
        System.out.println("Novo peso: ");
        float novoPeso = input.nextFloat();
        for (Bovino bovino : bovinos) {
            if (bovino.getId() == id) {
                bovino.avaliar(novaAltura, novoComprimento, novaLargura, novoPeso);
            }
        }
    }

    public static void avaliarSuino(List<Suino> suinos, int id, Scanner input){
        System.out.println();
        System.out.println("Nova altura: ");
        float novaAltura = input.nextFloat();
        System.out.println("Novo comprimento: ");
        float novoComprimento = input.nextFloat();
        System.out.println("Nova largura: ");
        float novaLargura = input.nextFloat();
        System.out.println("Novo peso: ");
        float novoPeso = input.nextFloat();
        for (Suino suino : suinos) {
            if (suino.getId() == id) {
                suino.avaliar(novaAltura, novoComprimento, novaLargura, novoPeso);
            }
        }
    }

    public static void avaliarEquino(List<Equino> equinos, int id, Scanner input){
        System.out.println();
        System.out.println("Nova altura: ");
        float novaAltura = input.nextFloat();
        System.out.println("Novo comprimento: ");
        float novoComprimento = input.nextFloat();
        System.out.println("Nova largura: ");
        float novaLargura = input.nextFloat();
        System.out.println("Novo peso: ");
        float novoPeso = input.nextFloat();
        for (Equino equino : equinos) {
            if (equino.getId() == id) {
                equino.avaliar(novaAltura, novoComprimento, novaLargura, novoPeso);
            }
        }
    }

    public static float registrarVendaBovino(List<Bovino> bovinos, int id, Scanner input, float totalVendasBovinos){
        System.out.println();
        for (Bovino bovino : bovinos) {
            if (bovino.getId() == id) {
                if(bovino != null && bovino.getStatus().equals("Ativo")){
                    bovino.setStatus("Vendido");
                    System.out.println("Valor da venda: ");
                    float precoVenda = input.nextFloat();
                    bovino.setPrecoVenda(precoVenda);
                    totalVendasBovinos += precoVenda;
                    return totalVendasBovinos;
                }
                else {
                    System.out.println("Erro: animal não encontrado ou não está ativo.");
                    return totalVendasBovinos;
                }   
            }
        }
        return totalVendasBovinos;
    }

    public static float registrarVendaSuino(List<Suino> suinos, int id, Scanner input, float totalVendasSuinos){
        System.out.println();
        for (Suino suino : suinos) {
            if (suino.getId() == id) {
                if(suino != null && suino.getStatus().equals("Ativo")){
                    suino.setStatus("Vendido");
                    System.out.println("Valor da venda: ");
                    float precoVenda = input.nextFloat();
                    suino.setPrecoVenda(precoVenda);
                    totalVendasSuinos += precoVenda;
                    return totalVendasSuinos;
                }
                else {
                    System.out.println("Erro: animal não encontrado ou não está ativo.");
                    return totalVendasSuinos;
                }   
            }
        }
        return totalVendasSuinos;
    }

    public static float registrarVendaEquino(List<Equino> equinos, int id, Scanner input, float totalVendasEquinos){
        System.out.println();
        for (Equino equino : equinos) {
            if (equino.getId() == id) {
                if(equino != null && equino.getStatus().equals("Ativo")){
                    equino.setStatus("Vendido");
                    System.out.println("Valor da venda: ");
                    float precoVenda = input.nextFloat();
                    equino.setPrecoVenda(precoVenda);
                    totalVendasEquinos += precoVenda;
                    return totalVendasEquinos;
                }
                else {
                    System.out.println("Erro: animal não encontrado ou não está ativo.");
                    return totalVendasEquinos;
                }   
            }
        }
        return totalVendasEquinos;
    }

    public static int registrarPerdaBovino(List<Bovino> bovinos, int id, int totalPerdasBovinos){
        System.out.println();
        for (Bovino bovino : bovinos) {
            if (bovino.getId() == id) {
                if(bovino != null && bovino.getStatus().equals("Ativo")){
                    bovino.setStatus("Perdido");
                    totalPerdasBovinos += 1;
                    return totalPerdasBovinos;
                }
                else {
                    System.out.println("Erro: animal não encontrado ou não está ativo.");
                    return totalPerdasBovinos;
                }   
            }
        }
        return totalPerdasBovinos;
    }

    public static int registrarPerdaSuino(List<Suino> suinos, int id, int totalPerdasSuinos){
        System.out.println();
        for (Suino suino : suinos) {
            if (suino.getId() == id) {
                if(suino != null && suino.getStatus().equals("Ativo")){
                    suino.setStatus("Perdido");
                    totalPerdasSuinos += 1;
                    return totalPerdasSuinos;
                }
                else {
                    System.out.println("Erro: animal não encontrado ou não está ativo.");
                    return totalPerdasSuinos;
                }   
            }
        }
        return totalPerdasSuinos;
    }

    public static int registrarPerdaEquino(List<Equino> equinos, int id, int totalPerdasEquinos){
        System.out.println();
        for (Equino equino : equinos) {
            if (equino.getId() == id) {
                if(equino != null && equino.getStatus().equals("Ativo")){
                    equino.setStatus("Perdido");
                    totalPerdasEquinos += 1;
                    return totalPerdasEquinos;
                }
                else {
                    System.out.println("Erro: animal não encontrado ou não está ativo.");
                    return totalPerdasEquinos;
                }   
            }
        }
        return totalPerdasEquinos;
    }

    public static void relatorioVendasBovino(List<Bovino> bovinos, float totalVendasBovinos){
        System.out.println();
        for (Bovino bovino : bovinos) {
            if(bovino != null && bovino.getStatus().equals("Vendido")){
                System.out.println("ID: " + bovino.getId() + ", Altura: " + bovino.getAltura() + "m" + ", Comprimento: " + bovino.getComprimento() + "m" + ", Largura: " + bovino.getLargura() + "m" + ", Peso: " + bovino.getPeso() + "Kg" + ", Status: " + bovino.getStatus());
            }
        }
        System.out.println("Total vendas bovinos: R$" + totalVendasBovinos);
    }

    public static void relatorioVendasSuino(List<Suino> suinos, float totalVendasSuinos){
        System.out.println();
        for (Suino suino : suinos) {
            if(suino != null && suino.getStatus().equals("Vendido")){
                System.out.println("ID: " + suino.getId() + ", Altura: " + suino.getAltura() + "m" + ", Comprimento: " + suino.getComprimento() + "m" + ", Largura: " + suino.getLargura() + "m" + ", Peso: " + suino.getPeso() + "Kg" + ", Status: " + suino.getStatus());
            }
        }
        System.out.println("Total vendas suinos: R$" + totalVendasSuinos);
    }

    public static void relatorioVendasEquino(List<Equino> equinos, float totalVendasEquinos){
        System.out.println();
        for (Equino equino : equinos) {
            if(equino != null && equino.getStatus().equals("Vendido")){
                System.out.println("ID: " + equino.getId() + ", Altura: " + equino.getAltura() + "m" + ", Comprimento: " + equino.getComprimento() + "m" + ", Largura: " + equino.getLargura() + "m" + ", Peso: " + equino.getPeso() + "Kg" + ", Status: " + equino.getStatus());
            }
        }
        System.out.println("Total vendas equinos: R$" + totalVendasEquinos);
    }

    public static void relatorioPerdasBovino(List<Bovino> bovinos, int totalPerdasBovinos){
        System.out.println();
        for (Bovino bovino : bovinos) {
            if(bovino != null && bovino.getStatus().equals("Perdido")){
                System.out.println("ID: " + bovino.getId() + ", Altura: " + bovino.getAltura() + "m" + ", Comprimento: " + bovino.getComprimento() + "m" + ", Largura: " + bovino.getLargura() + "m" + ", Peso: " + bovino.getPeso() + "Kg" + ", Status: " + bovino.getStatus());
            }
        }
        System.out.println("Total perdas bovinos: " + totalPerdasBovinos);
    }

    public static void relatorioPerdasSuino(List<Suino> suinos, int totalPerdasSuinos){
        System.out.println();
        for (Suino suino : suinos) {
            if(suino != null && suino.getStatus().equals("Perdido")){
                System.out.println("ID: " + suino.getId() + ", Altura: " + suino.getAltura() + "m" + ", Comprimento: " + suino.getComprimento() + "m" + ", Largura: " + suino.getLargura() + "m" + ", Peso: " + suino.getPeso() + "Kg" + ", Status: " + suino.getStatus());
            }
        }
        System.out.println("Total perdas suinos: " + totalPerdasSuinos);
    }

    public static void relatorioPerdasEquino(List<Equino> equinos, int totalPerdasEquinos){
        System.out.println();
        for (Equino equino : equinos) {
            if(equino != null && equino.getStatus().equals("Perdido")){
                System.out.println("ID: " + equino.getId() + ", Altura: " + equino.getAltura() + "m" + ", Comprimento: " + equino.getComprimento() + "m" + ", Largura: " + equino.getLargura() + "m" + ", Peso: " + equino.getPeso() + "Kg" + ", Status: " + equino.getStatus());
            }
        }
        System.out.println("Total perdas equinos: " + totalPerdasEquinos);
    }
}
