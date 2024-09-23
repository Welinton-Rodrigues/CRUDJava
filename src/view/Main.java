package view;
import data.UsuarioData;
import model.UsuarioModel;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        UsuarioModel obj = new UsuarioModel();
        UsuarioData DAO = new UsuarioData();
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("-----------Menuzin-------------------");
                System.out.println("1 - Novo usuário");
                System.out.println("2 - Lista Usuarios");
                System.out.println("3 - Editar Usuário");
                System.out.println("4 - Deletar Usuario");
                System.out.println("5 - Pesquisar por ID");
                System.out.println("6 - Pesquisar por nome");
                System.out.println("9 - Sair");
                opcao = sc.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Novo Usuario:");
                        System.out.println("Digite o nome");
                        obj.setNome(sc.next());
                        System.out.println("Digite o email:");
                        obj.setEmail(sc.next());
                        System.out.println("Digite a Senha");
                        obj.setSenha(sc.next());
                        if (DAO.incluir(obj)) System.out.println("\n\nSalvoznzn");
                        else System.out.println("\n\nNão salvo\n\n");
                        break;
                    case 2:
                        System.out.println("Listar Usuarios:");
                        System.out.println("Digite o nome\n");
                        ArrayList<UsuarioModel> dados = DAO.pesquisar("%");
                        for (UsuarioModel x : dados) {
                            System.out.println("ID:" + x.getId() + "\nNome:" + x.getNome() + "\nEmail:" + x.getEmail() + "\n\n");
                        }
                        break;

                    case 3:
                        System.out.println("Editar Usuario:");
                        ArrayList<UsuarioModel> dados3 = DAO.pesquisar("%");
                        //mostrar tudo

                        System.out.println("Digite o Id do usuario a ser editado:");
                        int usuarioEditar = sc.nextInt();


                        System.out.println("Digite os novos dados:");
                        UsuarioModel objModel = new UsuarioModel();
                        objModel.setId(usuarioEditar);
                        System.out.println("Digite o Nome");
                        objModel.setNome(sc.next());
                        System.out.println("Digite o email");
                        objModel.setEmail(sc.next());
                        System.out.println("Digite a senha");
                        objModel.setSenha(sc.next());

                        if (DAO.editar(objModel)) System.out.println("\n\nAtualizado!\n\n");
                        else System.out.println("\n\n Nao atualizou");
                        break;

                    case 4:
                        System.out.println(" Deletar Usuario:");
                        System.out.println("-----------------------------------------------");
                        ArrayList<UsuarioModel> dados2 = DAO.pesquisar("%");

                        for (UsuarioModel x : dados2) {
                            System.out.println("ID: " + x.getId() + "\n" + "Nome: " + x.getNome() + "\n" + "E-mail: " + x.getEmail() + "\n");
                            System.out.println("Digite o ID: ");
                            int MudarUsuario = sc.nextInt();

                            if (MudarUsuario == x.getId()) {
                                DAO.excluir(x.getId());
                                System.out.println("Excluido");
                            }

                        }
                    case 5:
                        System.out.println("Pesquisa por ID:");
                        break;
                    case 6:
                        System.out.println("Pesquisa por nome."
                                + "---------------------------");
                        System.out.println("Digite o nome a ser Pesquisado");
                        String nomePesquisa = sc.next();

                        ArrayList<UsuarioModel> dados4 = DAO.pesquisar("%");
                        for (UsuarioModel x : dados4) {
                            if (x.getNome().equals(nomePesquisa)) {
                                System.out.println(x.toString());
                            } else {
                                System.out.println("usuario não encontrado");
                            }
                        }


                }


            } catch (Exception e) {
                System.out.println("Erro" + e.getMessage());
            }

        } while (opcao != 9);
    }
}