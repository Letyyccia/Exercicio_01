import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class TelaDeCadastroDeLivro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do livro:");
        String nome = scanner.nextLine();

        System.out.println("Digite a editora do livro:");
        String editora = scanner.nextLine();

        System.out.println("Digite o número de paginas do livro:");
        Integer paginas = Integer.valueOf(scanner.nextLine());

        System.out.println("Digite o ano do livro:");
        Integer ano = Integer.valueOf(scanner.nextLine());

        System.out.println("Digite a edição do livro:");
        Integer edicao = Integer.valueOf(scanner.nextLine());


        Livro livro = new Livro(null, nome,  editora, paginas, ano, edicao);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicativo");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(livro);
            em.getTransaction().commit();

            System.out.println("Livro cadastrado com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro ao tentar cadastrar o livro.");
        }
        finally {
            em.close();
            emf.close();
        }



    }
}
