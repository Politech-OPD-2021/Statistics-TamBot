package bot.handler;

import bot.Constants;
import chat.tamtam.bot.annotations.UpdateHandler;
import chat.tamtam.bot.builders.NewMessageBodyBuilder;
import chat.tamtam.botapi.client.TamTamClient;
import chat.tamtam.botapi.exceptions.ClientException;
import chat.tamtam.botapi.model.BotStartedUpdate;
import chat.tamtam.botapi.queries.SendMessageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BotStartedUpdateHandler {
    private final TamTamClient client;

    @Autowired
    public BotStartedUpdateHandler(TamTamClient client) {
        this.client = client;
    }

    @UpdateHandler
    public void handle(BotStartedUpdate update) throws ClientException {
        new SendMessageQuery(client, NewMessageBodyBuilder.ofText(Constants.HELLO_MSG).build()).userId(update.getUser().getUserId()).enqueue();

        // TODO: check if user already has statistics of some chats
    }
}
