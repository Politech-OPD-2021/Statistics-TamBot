package bot.payload;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ChooseChatPayload implements StatisticsBotPayload {
    private final long chatId;

    @JsonCreator
    public ChooseChatPayload(long chatId) {
        this.chatId = chatId;
    }

    public long getChatId() {

        return chatId;
    }
}
