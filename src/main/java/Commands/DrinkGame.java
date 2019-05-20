package Commands;


import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DrinkGame  {

    List<User> members;
    List<String> drinkActions = Arrays.asList(" take a drink", " take a shot", " chug the rest of your drink");
    Random rand = new Random();
    String user,
           action;

    public DrinkGame(List<User> members) {
        this.members = members;
    }

    public void getRandomUser() {
        int n = rand.nextInt(members.size());
        String user = members.get(n).getAsMention();
        this.user = user;
    }

    public void getDrinkAction() {
        int m = rand.nextInt(drinkActions.size());
        String action = drinkActions.get(m);
        this.action = action;

    }

    public String drinkString() {
        getRandomUser();
        getDrinkAction();
        String drinkString = user + action;
        return drinkString;
    }


}
