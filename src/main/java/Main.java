import Commands.DrinkGame;
import Commands.Mentions;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Main extends ListenerAdapter {
    List<User> members;

    public static void main(String[] args) throws LoginException {
        String phrase;
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NTc5Nzc4NTYzMjkzNzA4Mjk3.XOHHNw.Le22hrsAOhGpTIi8bvZ1MmJJJtQ";
        builder.setToken(token);
        builder.addEventListeners(new Main());
        builder.build();
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        String userInput = event.getMessage().getContentDisplay();              // Get user input from discord client
        String[] inputArray = userInput.split(" ", 2);              // Split the input to get the command
        String command = inputArray[0];                                         // Set command

        switch(command) {                                                       // See what command the user wants to use
            case "!test":
                System.out.println("In test command");
                break;
            case "!drink":
                Mentions mentions = new Mentions(event);
                members = mentions.getAllMentionedUsers();
                DrinkGame drinkGame = new DrinkGame(members);
                String drinkString = drinkGame.drinkString();
                event.getChannel().sendMessage(drinkString).queue();
                break;
            case "!joindate":
                Member member = event.getMessage().getMember();
                DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM);
                String joinDate = member.getTimeJoined().format(formatter);
                event.getChannel().sendMessage(joinDate).queue();
                break;
        }
    }
}

