package Commands;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import javax.annotation.Nonnull;
import java.util.List;


public class Mentions {

    MessageReceivedEvent event;
    List<User> members;

    public Mentions(@Nonnull MessageReceivedEvent event) {
        this.event = event;
    }

    public List<User> getAllMentionedUsers() {
        members = event.getMessage().getMentionedUsers();
        return members;
    }
}
