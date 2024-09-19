public class Main {
    public static void main(String[] args) {
        // Inicializar sistema da biblioteca
        LibrarySystem librarySystem = new LibrarySystem();

        // Adicionar mídias ao catálogo
        librarySystem.addMedia(new Book("O Senhor dos Anéis", 3));
        librarySystem.addMedia(new DVD("Matrix", 2));
        librarySystem.addMedia(new Ebook("Clean Code", Integer.MAX_VALUE));

        // Criar usuários
        User student = new User("João", "Aluno", 3, 3);
        User teacher = new User("Dr. Silva", "Professor", 5, 5);
        librarySystem.addUser(student);
        librarySystem.addUser(teacher);

        // Aluno empresta um livro
        librarySystem.loanMedia("João", "O Senhor dos Anéis");

        // Professor empresta um ebook
        librarySystem.loanMedia("Dr. Silva", "Clean Code");

        // Aluno devolve o livro
        librarySystem.returnMedia("João", "O Senhor dos Anéis");

        // Professor renova o ebook
        librarySystem.renewMedia("Dr. Silva", "Clean Code");
    }
}
