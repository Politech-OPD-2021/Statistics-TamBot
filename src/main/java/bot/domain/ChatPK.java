package bot.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChatPK implements Serializable {
    private long adminId;
    private long chatId;

    public ChatPK(long adminId, long chatId) {
        this.adminId = adminId;
        this.chatId = chatId;
    }

    public ChatPK() {

    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
}
