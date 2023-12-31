package controller;

import java.util.Scanner;
import model.Adm;
import model.Encarregado;
import model.ProdutoAdega;
import model.ProdutoBebida;
import model.ProdutoMercearia;
import model.ProdutoPadaria;
import repositorio.RepositorioAdega;
import repositorio.RepositorioBebida;
import repositorio.RepositorioMercearia;
import repositorio.RepositorioPadaria;
import view.AdegaView;
import view.AdmView;
import view.AppView;
import view.BebidaView;
import view.EncarregadoView;
import view.MerceariaView;
import view.PadariaView;

public class AppController {
    private final Scanner leitor;
    private AppView appview;
    private MerceariaView merceariaview;
    private BebidaView bebidaview;
    private AdegaView adegaview;
    private PadariaView padariaview;
    private AdmView admview;
    private EncarregadoView encarregadoview;
    private RepositorioMercearia repositoriomercearia;
    private RepositorioBebida repositoriobebida;
    private RepositorioAdega repositorioadega;
    private RepositorioPadaria repositoriopadaria;

    public AppController() {
        leitor = new Scanner(System.in);
        appview = new AppView();
        merceariaview = new MerceariaView();
        bebidaview = new BebidaView();
        adegaview = new AdegaView();
        padariaview = new PadariaView();
        admview = new AdmView();
        encarregadoview = new EncarregadoView();
        repositoriomercearia = new RepositorioMercearia();
        repositoriobebida = new RepositorioBebida();
        repositorioadega = new RepositorioAdega();
        repositoriopadaria = new RepositorioPadaria();
    }

    public void inicializar_menu() {
        int op;
        Adm a1 = new Adm();
        Encarregado supervisor = new Encarregado();

        op = appview.menu_inicial(leitor);

        switch (op) {
            case 1:
                if (encarregadoview.autenticar_acesso(supervisor, leitor, op)) {
                    adegaview.listagem_adega(repositorioadega.getLista_adega());

                    ProdutoAdega pa = adegaview.cadastro_adega(leitor);
                    repositorioadega.getLista_adega().add(pa);
                }

                inicializar_menu();
                break;
            case 2:
                if (encarregadoview.autenticar_acesso(supervisor, leitor, op)) {
                    bebidaview.listagem_bebida(repositoriobebida.getLista_bebidas());

                    ProdutoBebida pb = bebidaview.cadastro_bebida(leitor);
                    repositoriobebida.getLista_bebidas().add(pb);
                }

                inicializar_menu();
                break;
            case 3:
                if (encarregadoview.autenticar_acesso(supervisor, leitor, op)) {
                    merceariaview.listagem_mercearia(repositoriomercearia.getLista_mercearia());

                    ProdutoMercearia pm = merceariaview.cadastro_mercearia(leitor);
                    repositoriomercearia.getLista_mercearia().add(pm);
                }

                inicializar_menu();
                break;
            case 4:
                if (encarregadoview.autenticar_acesso(supervisor, leitor, op)) {
                    padariaview.listagem_padaria(repositoriopadaria.getLista_padaria());

                    ProdutoPadaria pd = padariaview.cadastro_padaria(leitor);
                    repositoriopadaria.getLista_padaria().add(pd);
                }

                inicializar_menu();
                break;
            case 5:
                if (admview.autenticar_adm(a1, leitor)) {
                    open_adm();
                } else {
                    inicializar_menu();
                }
                break;
            default:
                inicializar_menu();
                break;
        }
    }

    public void open_adm() {
        int op = admview.menu_adm(leitor);

        switch (op) {
            case 1:
                int selection_a = adegaview.adega_adm(leitor);

                if (selection_a == 1) {
                    adegaview.listagem_adega(repositorioadega.getLista_adega());
                } else if (selection_a == 2) {
                    ProdutoAdega pa = adegaview.cadastro_adega(leitor);
                    repositorioadega.getLista_adega().add(pa);

                    adegaview.listagem_adega(repositorioadega.getLista_adega());
                } else if (selection_a == 3) {
                    adegaview.listagem_adega(repositorioadega.getLista_adega());

                    ProdutoAdega a_remove = adegaview.remover_cadastro_adega(leitor, repositorioadega.getLista_adega());
                    repositorioadega.getLista_adega().remove(a_remove);

                    adegaview.listagem_adega(repositorioadega.getLista_adega());
                }
                open_adm();
                break;

            case 2:
                int selection_b = bebidaview.bebida_adm(leitor);

                if (selection_b == 1) {
                    bebidaview.listagem_bebida(repositoriobebida.getLista_bebidas());
                } else if (selection_b == 2) {
                    ProdutoBebida pb = bebidaview.cadastro_bebida(leitor);
                    repositoriobebida.getLista_bebidas().add(pb);

                    bebidaview.listagem_bebida(repositoriobebida.getLista_bebidas());

                } else if (selection_b == 3) {
                    bebidaview.listagem_bebida(repositoriobebida.getLista_bebidas());

                    ProdutoBebida b_remove = bebidaview.remover_cadastro_bebida(leitor,
                            repositoriobebida.getLista_bebidas());
                    repositoriobebida.getLista_bebidas().remove(b_remove);

                    bebidaview.listagem_bebida(repositoriobebida.getLista_bebidas());
                }
                open_adm();
                break;

            case 3:
                int selection_m = merceariaview.mercearia_adm(leitor);

                if (selection_m == 1) {
                    merceariaview.listagem_mercearia(repositoriomercearia.getLista_mercearia());
                } else if (selection_m == 2) {
                    ProdutoMercearia pm = merceariaview.cadastro_mercearia(leitor);
                    repositoriomercearia.getLista_mercearia().add(pm);

                    merceariaview.listagem_mercearia(repositoriomercearia.getLista_mercearia());

                } else if (selection_m == 3) {
                    merceariaview.listagem_mercearia(repositoriomercearia.getLista_mercearia());

                    ProdutoMercearia m_remove = merceariaview.remover_cadastro_mercearia(leitor,
                            repositoriomercearia.getLista_mercearia());
                    repositoriomercearia.getLista_mercearia().remove(m_remove);

                    merceariaview.listagem_mercearia(repositoriomercearia.getLista_mercearia());
                }
                open_adm();
                break;

            case 4:
                int selection_p = padariaview.padaria_adm(leitor);

                if (selection_p == 1) {
                    padariaview.listagem_padaria(repositoriopadaria.getLista_padaria());
                } else if (selection_p == 2) {
                    ProdutoPadaria pp = padariaview.cadastro_padaria(leitor);
                    repositoriopadaria.getLista_padaria().add(pp);

                    padariaview.listagem_padaria(repositoriopadaria.getLista_padaria());

                } else if (selection_p == 3) {
                    padariaview.listagem_padaria(repositoriopadaria.getLista_padaria());

                    ProdutoPadaria p_remove = padariaview.remover_cadastro_padaria(leitor,
                            repositoriopadaria.getLista_padaria());
                    repositoriopadaria.getLista_padaria().remove(p_remove);

                    padariaview.listagem_padaria(repositoriopadaria.getLista_padaria());
                }
                open_adm();
                break;

            case 5:
                Adm gestor1 = new Adm();
                admview.alterar_senha(gestor1, leitor);
                inicializar_menu();
                break;
        }
    }

    public void inicializar_repositorio() {
        ProdutoMercearia m1 = new ProdutoMercearia("Doritos Original", 7894512, "20/05/2025", 9.49, "90g",
                "Salgadinhos", 10);
        ProdutoMercearia m2 = new ProdutoMercearia("Cebola em conserva Carrefour", 7893256, "07/2026", 12.50, "180g",
                "Enlatados/Conservas", 7);
        ProdutoMercearia m3 = new ProdutoMercearia("Leite Condensado Nestlé", 7896521, "04/2024", 9.20, "200g",
                "Misturas para bolo/Derivados", 5);

        repositoriomercearia.getLista_mercearia().add(m1);
        repositoriomercearia.getLista_mercearia().add(m2);
        repositoriomercearia.getLista_mercearia().add(m3);

        ProdutoPadaria p1 = new ProdutoPadaria("Pão Francês", 205789, "02/05/2023", 7.25, 500, 14.50, "01/05/2023",
                "Padaria", 2105);
        ProdutoPadaria p2 = new ProdutoPadaria("Sonho de creme", 205752, "03/05/2023", 5.25, 120, 16.50, "01/05/2023",
                "Confeitaria", 2107);
        ProdutoPadaria p3 = new ProdutoPadaria("Peito de frango", 205719, "05/05/2023", 5.25, 50, 40.00, "01/05/2023",
                "Fiamberia", 2125);

        repositoriopadaria.getLista_padaria().add(p1);
        repositoriopadaria.getLista_padaria().add(p2);
        repositoriopadaria.getLista_padaria().add(p3);

        ProdutoBebida b1 = new ProdutoBebida("Pepsi Black", 7894170, "09/2025", 9.50, "Refrigerante", "1000ml", false,
                0);
        ProdutoBebida b2 = new ProdutoBebida("Coca-Cola", 78941200, "05/2025", 11.50, "Refrigerante", "1000ml", false,
                0);
        ProdutoBebida b3 = new ProdutoBebida("Heineken", 7894150, "07/2025", 6.50, "Cerveja", "480ml", true,
                5.0);

        repositoriobebida.getLista_bebidas().add(b1);
        repositoriobebida.getLista_bebidas().add(b2);
        repositoriobebida.getLista_bebidas().add(b3);

        ProdutoAdega a1 = new ProdutoAdega("Vinho Montes Claros", 7896032, "07/2027", 35.50, "Vinho tinto", "Brasil",
                2017, 5.0, "980ml");
        ProdutoAdega a2 = new ProdutoAdega("Salton Moscatel", 7896040, "07/2025", 29.00, "Espumante", "Brasil",
                2020, 4.0, "750ml");
        ProdutoAdega a3 = new ProdutoAdega("Portada", 7896022, "04/2027", 40.50, "Vinho rosé", "Portugal",
                2021, 3.0, "980ml");

        repositorioadega.getLista_adega().add(a1);
        repositorioadega.getLista_adega().add(a2);
        repositorioadega.getLista_adega().add(a3);
    }
}