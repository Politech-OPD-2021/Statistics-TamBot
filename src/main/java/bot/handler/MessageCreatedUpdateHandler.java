package bot.handler;

import bot.domain.Message;
import bot.service.BotService;
import chat.tamtam.bot.annotations.UpdateHandler;
import chat.tamtam.bot.chat.ChatBot;
import chat.tamtam.botapi.client.TamTamClient;
import chat.tamtam.botapi.exceptions.ClientException;
import chat.tamtam.botapi.model.ChatType;
import chat.tamtam.botapi.model.MessageCreatedUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MessageCreatedUpdateHandler {
    private final TamTamClient client;
    private final BotService botService;
    private final ChatBot chatBot;

    @Autowired
    public MessageCreatedUpdateHandler(TamTamClient client,
                                       BotService botService, ChatBot chatBot) {
        this.client = client;
        this.botService = botService;
        this.chatBot = chatBot;
    }

    @UpdateHandler
    public void handle(MessageCreatedUpdate update) throws ClientException {
        chatBot.replyOn(update.getMessage());
        ChatType chatType = update.getMessage().getRecipient().getChatType();
        if (chatType.equals(ChatType.DIALOG)) {
            handleDialog(update);
            return;
        }
        handleChatOrChannel(update);
    }

    private void handleDialog(MessageCreatedUpdate update) {
        // настройка бота
    }

    @Transactional
    protected void handleChatOrChannel(MessageCreatedUpdate update) {
        // сообщения сохраняются в базу
        chat.tamtam.botapi.model.Message message = update.getMessage();
        String mid = message.getBody().getMid();
        Long chatID = message.getRecipient().getChatId();
        Long userID = message.getSender().getUserId();
        Long timeStamp = message.getTimestamp();
        String text = message.getBody().getText();
        Message daoMessage = new Message(mid, chatID, userID, timeStamp, text);
        Message saved = botService.saveMassage(daoMessage);
    }
}
