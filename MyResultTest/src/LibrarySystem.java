import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private List<Media> catalog = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    // Adicionar mídia ao catálogo
    public void addMedia(Media media) {
        catalog.add(media);
    }

    // Registrar um novo usuário
    public void addUser(User user) {
        users.add(user);
    }

    // Empréstimo de mídia para usuário
    public boolean loanMedia(String userName, String mediaTitle) {
        User user = findUser(userName);
        Media media = findMedia(mediaTitle);
        if (user != null && media != null) {
            return media.borrowMedia(user);
        }
        return false;
    }

    // Devolução de mídia pelo usuário
    public boolean returnMedia(String userName, String mediaTitle) {
        User user = findUser(userName);
        Media media = findMedia(mediaTitle);
        if (user != null && media != null) {
            media.returnMedia(user);
            return true;
        }
        return false;
    }

    // Renovação de mídia
    public boolean renewMedia(String userName, String mediaTitle) {
        User user = findUser(userName);
        Media media = findMedia(mediaTitle);
        if (user != null && media != null && user.canRenew()) {
            user.reduceRenewals();
            System.out.println(user.name + " renovou " + media.title + " com sucesso.");
            return true;
        } else {
            System.out.println("Renovação falhou: " + mediaTitle + " não pode ser renovado.");
        }
        return false;
    }


    // Encontrar um usuário pelo nome
    private User findUser(String userName) {
        for (User user : users) {
            if (user.name.equals(userName)) {
                return user;
            }
        }
        return null;
    }

    // Encontrar uma mídia pelo título
    private Media findMedia(String mediaTitle) {
        for (Media media : catalog) {
            if (media.title.equals(mediaTitle)) {
                return media;
            }
        }
        return null;
    }
}
