package model;

public class ProdutoPadaria extends Produto {
    private double peso_kg;
    private String data_embalado;
    private String categoria;
    private int codigo_pesagem;

    public ProdutoPadaria(String nome_produto, long codigo_produto, String data_validade, double valor_unitario,
            double peso_kg, String data_embalado, String categoria, int codigo_pesagem) {
        super(nome_produto, codigo_produto, data_validade, valor_unitario);
        this.peso_kg = peso_kg;
        this.data_embalado = data_embalado;
        this.categoria = categoria;
        this.codigo_pesagem = codigo_pesagem;
    }

    public double getPeso_kg() {
        return peso_kg;
    }

    public void setPeso_kg(double peso_kg) {
        this.peso_kg = peso_kg;
    }

    public String getData_embalado() {
        return data_embalado;
    }

    public void setData_embalado(String data_embalado) {
        this.data_embalado = data_embalado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCodigo_pesagem() {
        return codigo_pesagem;
    }

    public void setCodigo_pesagem(int codigo_pesagem) {
        this.codigo_pesagem = codigo_pesagem;
    }
}