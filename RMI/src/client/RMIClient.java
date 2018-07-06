package client;


import classescomplexas.Pessoa;
import interfaces.RMIInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class RMIClient {

    public static void main(String args[]) {
        try {
            // Começa a contar o tempo
            long start = System.currentTimeMillis();

            // Aqui vem o IP do Host do servidor
            String host = "192.168.1.109";

            // Porta na qual o host vai deixar o server 'escutando'
            int port = 1099;


            // Faz conexao com o HOST na porta indicada
            Registry registry = LocateRegistry.getRegistry(host, port);

            // Busca pelo server que esta bindado neste caminho 'server' dentro do host
            // e cria o stub
            RMIInterface stub = (RMIInterface) registry.lookup("server");


            // Todos os métodos usados para testar
            // O programa foi rodado cerca de 10 vezes para cada um dos testes individualmente



//            List<Pessoa> lista = new ArrayList<>();
//            lista.add(new Pessoa("Guilherme Coppini Pavani", 19, 1.73, 9862951));
//            lista.add(new Pessoa("Silvio Novaes de Lira Junior", 19, 1.74, 9778522));
//            lista.add(new Pessoa("Lucas Bordinhon Capalbo", 19, 1.78, 9877982));
//            Pessoa pessoaDaLista = stub.sendListaPessoa(lista);

            String oiDaPessoa = stub.oiDaPessoa(new Pessoa("Guilherme", 19, 1.73, 9862951));

//            Integer intResponse = stub.sendInteger(10);

//            Long longResponse = stub.sendLong(10L);

//            int stringSize = 2048;
//            String strResponse = stub.sendString(createString(stringSize)); // mudar tamanho da string

//            Long eightLongsResponse = stub.send8Longs(1L, 1L, 1L, 1L, 1L, 1L, 1L, 1L);

//            stub.voidFunction();

//            Double doubleResponse = stub.sendDouble(10.0);


            // Termina calculo do tempo
            long totalTime = System.currentTimeMillis() - start;

            System.out.println("Tempo discorrido: " + totalTime);
        } catch(Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
        }
    }

    // Metodo auxiliar para criar Strings grandes/pequenas de acordo com a necessidade para testar o string
    private static String createString(int size) {
        String result = "";
        for(int i = 0; i<size; i++){
            result += ".";
        }
        return result;
    }
}