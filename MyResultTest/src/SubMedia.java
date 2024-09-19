class Book extends Media {
    public Book(String title, int availableCopies) {
        super(title, "Livro", availableCopies, 14);  // 14 dias de empréstimo
    }
}

class DVD extends Media {
    public DVD(String title, int availableCopies) {
        super(title, "DVD", availableCopies, 7);  // 7 dias de empréstimo
    }
}

class Ebook extends Media {
    public Ebook(String title, int availableCopies) {
        super(title, "Ebook", availableCopies, 21);  // 21 dias de empréstimo
    }
}
