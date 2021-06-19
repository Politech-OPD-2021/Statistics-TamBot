package bot.handler;

import bot.Constants;
import bot.domain.Chat;
import bot.service.BotService;
import chat.tamtam.bot.annotations.UpdateHandler;
import chat.tamtam.bot.builders.NewMessageBodyBuilder;
import chat.tamtam.botapi.client.TamTamClient;
import chat.tamtam.botapi.exceptions.APIException;
import chat.tamtam.botapi.exceptions.ClientException;
import chat.tamtam.botapi.model.BotAddedToChatUpdate;
import chat.tamtam.botapi.model.ChatMembersList;
import chat.tamtam.botapi.model.User;
import chat.tamtam.botapi.queries.GetAdminsQuery;
import chat.tamtam.botapi.queries.LeaveChatQuery;
import chat.tamtam.botapi.queries.SendMessageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BotAddedToChatUpdateHandler {
    private final TamTamClient tamTamClient;
    private final BotService botService;

    @Autowired
    public BotAddedToChatUpdateHandler(TamTamClient tamTamClient, BotService botService) {
        this.tamTamClient = tamTamClient;
        this.botService = botService;
    }


    @UpdateHandler
    public void handle(BotAddedToChatUpdate update) throws ClientException {
        long chatId = update.getChatId();
        ChatMembersList chatMembersList;
        try {
            chatMembersList = new GetAdminsQuery(tamTamClient, chatId).execute();
        } catch (APIException | ClientException e) {
            e.printStackTrace();
            // TODO: log error
            return;
        }

        List<Long> adminIds = chatMembersList.getMembers().stream().map(User::getUserId).collect(Collectors.toList());
        long userId = update.getUser().getUserId();
        if (!adminIds.contains(userId)) {
            new LeaveChatQuery(tamTamClient, chatId).enqueue();
            new SendMessageQuery(tamTamClient, NewMessageBodyBuilder.ofText(Constants.ONLY_ADMIN).build()).userId(userId).enqueue();
            return;
        }

        for (long adminId : adminIds) {
            botService.saveChat(new Chat(adminId, chatId));
        }

        // TODO: maybe we should have admin status to get statistics? not sure

    }
}
