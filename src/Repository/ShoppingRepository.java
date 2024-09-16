package Repository;

import Domain.Propriedades.Propriedade;
import Tools.CSVShoppingReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ShoppingRepository {

    // Instanciar ArrayList de objectos do tipo Propriedade, onde vão estar todos os items do Shopping
    private ArrayList<Propriedade> listaProdutos;

    /**
     * Método construtor de ShoppingRepository
     *
     * @param filePath Caminho do ficheiro
     * @throws FileNotFoundException Lança excepção para ficheiro não encontrado
     */
    public ShoppingRepository(String filePath) throws FileNotFoundException {
        // Instanciar um novo objecto do tipo CSVShoppingReader com o nome csvShoppingReader, com o caminho do ficheiro como parâmetro
        CSVShoppingReader csvShoppingReader = new CSVShoppingReader(filePath);
        // Objecto criado vai invocar o método readCSVToRepository, e o return desse método fica gravado no ArrayList "listaProdutos"
        this.listaProdutos = csvShoppingReader.readCSVToRepository();
    }

    // ----- GETTERS ----- //
    public ArrayList<Propriedade> getListaProdutos() {
        return listaProdutos;
    }
}