package bot.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Chat {
    @EmbeddedId
    private ChatPK chatPK;

    public Chat(long userId, long chatId) {
        this.chatPK = new ChatPK(userId, chatId);
    }

    public Chat(ChatPK chatPK) {
        this.chatPK = chatPK;
    }

    public Chat() {

    }

    public ChatPK getChatPK() {
        return chatPK;
    }

    public void setChatPK(ChatPK chatPK) {
        this.chatPK = chatPK;
    }
}
