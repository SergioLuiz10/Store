package application;

import model.dao.fabricaDao;
import model.dao.vendedorDao;
import model.entities.departamento;
import model.entities.vendedor;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class programaVendedor {
    public static void main(String[] args) {
       Scanner ler = new Scanner(System.in);
        vendedorDao vendedordao = fabricaDao.criarVendedorDao();
        System.out.println("=== Testando : vendedor achando pelo id");
        vendedor vd = vendedordao.achandoPeloId(3);
        System.out.println(vd);
        System.out.println("Testando: vendedor achar pelo departamento");
       departamento dp = new departamento(3,null);
        List<vendedor> list = vendedordao.achandoPeloDepartamento(dp);
       for (vendedor vendedorDiferente : list){
          System.out.println(vendedorDiferente);
       }
        System.out.println("Testando: vendedor achartodos ");

        list = vendedordao.achandoTodos();
        for (vendedor vendedorDiferente : list){
            System.out.println(vendedorDiferente);
        }
        vendedor novoVd = new vendedor(null, "Sergio", "sergio@gmail.com", new Date(), 500.00, dp);
        vendedordao.inserindo(novoVd);
        System.out.println("novo vendedor="+ novoVd.getId());


        System.out.println("Testando : vendedor mudando ");
        vendedor alterado = new vendedor(12,"talita","talita@gmail.com",new Date(),600,dp);
       vendedordao.mudando(alterado);
      System.out.println("Alterado :"+alterado);


        System.out.println("Testado : deletar do vendedor:");
        vendedordao.deletandoPeloId(14);
        vendedordao.deletandoPeloId(15);



    }
}
