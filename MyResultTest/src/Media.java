public class Media {
    protected String title;
    protected String mediaType;
    protected int availableCopies;
    protected int borrowDuration;

    public Media(String title, String mediaType, int availableCopies, int borrowDuration) {
        this.title = title;
        this.mediaType = mediaType;
        this.availableCopies = availableCopies;
        this.borrowDuration = borrowDuration;
    }

    // Empréstimo de mídia
    public boolean borrowMedia(User user) {
        if (availableCopies > 0 && user.canBorrow()) {
            availableCopies--;
            user.addLoan(this);
            System.out.println(user.name + " emprestou " + title);
            return true;
        }
        System.out.println("Empréstimo falhou: " + title + " não disponível ou limite atingido.");
        return false;
    }

    // Devolução de mídia
    public void returnMedia(User user) {
        availableCopies++;
        user.removeLoan(this);
        System.out.println(user.name + " devolveu " + title);
    }

    public int getBorrowDuration() {
        return borrowDuration;
    }
}
