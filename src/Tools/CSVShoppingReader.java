package Tools;

import Domain.Propriedades.AcessorioModa;
import Domain.Propriedades.Imovel;
import Domain.Propriedades.Propriedade;
import Domain.Propriedades.Veiculo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVShoppingReader {

    private String filePath;

    /**
     * Método construtor de CSVShoppingReader
     *
     * @param filePath Caminho do ficheiro
     */
    public CSVShoppingReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Método para ler um ficheiro e devolver ArrayList preenchido
     *
     * @return ArrayList com todos os produtos do Shopping
     * @throws FileNotFoundException Lança excepção para ficheiro não encontrado
     */
    public ArrayList<Propriedade> readCSVToRepository() throws FileNotFoundException {
        File file = new File(this.filePath); // Novo File com nome file, com o caminho do ficheiro passado como parâmetro
        Scanner scanCSV = new Scanner(file);  // Instanciar novo Scanner com "file" (o ficheiro acima) como parâmetro
        String linha;  // Instanciar variável que vai gravar o conteúdo de uma linha do ficheiro acima
        ArrayList<Propriedade> listaProdutos = new ArrayList<>(); // Instanciar (vazio) um ArrayList to tipo Propriedade, com nome listaProdutos
        scanCSV.nextLine(); // Avançar primeira linha (cabeçalho) do ficheiro
        // Ciclo para preencher o ArrayList com todos os produtos do Shopping
        while (scanCSV.hasNextLine()) {  // Ciclo while que corre enquanto o scanner detectar uma nova linha no ficheiro
            linha = scanCSV.nextLine(); // Gravar em "linha" o conteúdo da linha actual
            String[] linhaDividida = linha.split(";"); // Dividir a linha pelo separador ";"
            // Gravar em diferentes variáveis os valores nas diferentes posições
            String tipo = linhaDividida[0]; // Tipo (imóvel, veículo, acessório de moda)
            String produto = linhaDividida[1]; // Nome do produto
            double custo = Double.parseDouble(linhaDividida[2]); // Preço do produto
            int estatuto = Integer.parseInt(linhaDividida[3]); // Estatuto que o produto confere ao comprador
            int lotacao = Integer.parseInt(linhaDividida[4]); // Lotação (no caso de ser Imóvel)
            String marca = linhaDividida[5]; // Marca (no caso de ser Veículo ou Acessório de Moda
            String modelo = linhaDividida[6]; // Modelo (no caso de ser Veículo)
            boolean formal = Boolean.parseBoolean(linhaDividida[7]); // Formal (no caso de ser Acessório de Moda)
            if (tipo.equalsIgnoreCase("Imovel")) { // Se o tipo for Imovel
                // Instanciar novo objecto da classe Imovel com os atributos corrrespondentes passados como parâmetro
                Imovel produtoActual = new Imovel(produto, custo, estatuto, lotacao);
                listaProdutos.add(produtoActual); // Adicionar o produto instanciado ao ArrayList de listaProdutos
            }
            if (tipo.equalsIgnoreCase("Veiculo")) { // Se o tipo for Veiculo
                // Instanciar novo objecto da classe Veiculo com os atributos corrrespondentes passados como parâmetro
                Veiculo produtoActual = new Veiculo(produto, custo, estatuto, marca, modelo);
                listaProdutos.add(produtoActual); // Adicionar o produto instanciado ao ArrayList de listaProdutos
            }
            if (tipo.equalsIgnoreCase("AcessorioModa")) { // Se o tipo for AcessorioModa
                // Instanciar novo objecto da classe AcessorioModa com os atributos corrrespondentes passados como parâmetro
                AcessorioModa produtoActual = new AcessorioModa(produto, custo, estatuto, marca, formal);
                listaProdutos.add(produtoActual); // Adicionar o produto instanciado ao ArrayList de listaProdutos
            }
        }
        return listaProdutos; // Devolver ArrayList "listaProdutos", preenchido com todos os produtos no ficheiro
    }
}