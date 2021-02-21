import chat.tamtam.bot.webhook.WebhookBot;
import chat.tamtam.bot.webhook.WebhookBotOptions;
import chat.tamtam.botapi.client.TamTamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsBot extends WebhookBot {

    @Autowired
    public StatisticsBot(TamTamClient client) {
        super(client, WebhookBotOptions.DEFAULT);
    }
}
