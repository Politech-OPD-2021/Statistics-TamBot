import chat.tamtam.bot.builders.NewMessageBodyBuilder;
import chat.tamtam.bot.longpolling.LongPollingBot;
import chat.tamtam.botapi.exceptions.ClientException;
import chat.tamtam.botapi.model.MessageCreatedUpdate;
import chat.tamtam.botapi.model.Update;
import chat.tamtam.botapi.queries.SendMessageQuery;
import org.jetbrains.annotations.Nullable;

public class PingPongBot extends LongPollingBot {

    public PingPongBot(String token) {
        super(token);
    }

    @Nullable
    @Override
    public Object onUpdate(Update update) {
        if (!(update instanceof MessageCreatedUpdate)) {
            return null;
        }
        MessageCreatedUpdate messageCreatedUpdate = (MessageCreatedUpdate) update;
        String message = messageCreatedUpdate.getMessage().getBody().getText();
        if (message.equalsIgnoreCase("ping")) {
            sendMessage("pong", messageCreatedUpdate);
            return null;
        }

        if (message.equalsIgnoreCase("pong")) {
            sendMessage("ping", messageCreatedUpdate);
            return null;
        }

        sendMessage("Game over", messageCreatedUpdate);
        return null;
    }

    private void sendMessage(String text, MessageCreatedUpdate messageCreatedUpdate) {
        try {
            new SendMessageQuery(getClient(), NewMessageBodyBuilder.ofText(text).build()).userId(messageCreatedUpdate.getMessage().getSender().getUserId()).enqueue();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}

