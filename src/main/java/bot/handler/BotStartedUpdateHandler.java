package bot.handler;

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
        new SendMessageQuery(client, NewMessageBodyBuilder.ofText("bot started").build()).userId(update.getUser().getUserId()).enqueue();
    }
}
