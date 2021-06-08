package gr.aueb.recipeapp.domain;

/**
 * @author Ioannis Kakatsos
 * @author Lampros-Stauros Koutsioukis
 * @author Efthymios Papageorgiou
 */
public class Admin extends User {
    /**
     * constructor of Admin class
     * @param username
     * @param password
     */
    public Admin(String username, String password) {
        super(username, password);
    }
}
