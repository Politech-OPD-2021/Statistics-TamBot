package bot.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    private String messageId;

    private Long chatId;
    private Long userId;
    private Long timestamp;
    private String text;

    public Message(String messageId, Long chatId, Long userId, Long timestamp, String text) {
        this.messageId = messageId;
        this.chatId = chatId;
        this.userId = userId;
        this.timestamp = timestamp;
        this.text = text;
    }

    public Message() {

    }

    public String getMessageId() {
        return messageId;
    }

    public Long getChatId() {
        return chatId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
