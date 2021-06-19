package bot.command;

import chat.tamtam.bot.builders.NewMessageBodyBuilder;
import chat.tamtam.bot.commands.CommandLine;
import chat.tamtam.botapi.client.TamTamClient;
import chat.tamtam.botapi.exceptions.ClientException;
import chat.tamtam.botapi.model.Message;
import chat.tamtam.botapi.queries.SendMessageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatisticsCommand implements BotCommand {
    private final TamTamClient tamTamClient;

    @Autowired
    public StatisticsCommand(TamTamClient tamTamClient) {
        this.tamTamClient = tamTamClient;
    }

    @Override
    public String getKey() {
        return "statistics";
    }

    @Override
    public void execute(Message message, CommandLine commandLine) {
        long userId = message.getSender().getUserId();
        String text = message.getBody().getText();
        try {
            new SendMessageQuery(tamTamClient, NewMessageBodyBuilder.ofText("select").build()).userId(userId).enqueue();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }
}
