


/**
 * @author Magdalene
 *
 */
import java.util.*;

public class UserCollection {
    private ArrayList<User> users = new ArrayList<>();

    private int capacity;
    
    private UserServlet repo;

    public UserCollection() {
        /*users.add(new User(1000, "mag", "password", "mag@gmail.com", "99988271"));
        users.add(new User(1001, "mag1", "password1", "mag1@gmail.com", "99988271"));
        users.add(new User(1002, "mag2", "password2", "mag2@gmail.com", "99988271"));
        users.add(new User(1003, "mag3", "password3", "mag3@gmail.com", "99988271")); */

        this.capacity = 20;
    }

    public UserCollection(int capacity) {
        this.capacity = capacity;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        if (users.size() != capacity) {
            users.add(user);
        }
    }

    public User findUserById(int id) {
        for (User u : users) {
            if (u.getId() == (id))
                return u;
        }
        return null;
    }

    public void updateUser(int id) {
     
    }
    public void deleteUser(int id) {
       
        
    }
}