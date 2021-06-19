package bot.service;

import bot.domain.Chat;
import bot.domain.Message;
import bot.repository.AttachmentRepository;
import bot.repository.ChatRepository;
import bot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotService {
    private final MessageRepository messageRepository;
    private final AttachmentRepository attachmentRepository;
    private final ChatRepository chatRepository;

    @Autowired
    public BotService(MessageRepository messageRepository,
                      AttachmentRepository attachmentRepository,
                      ChatRepository chatRepository) {
        this.messageRepository = messageRepository;
        this.attachmentRepository = attachmentRepository;
        this.chatRepository = chatRepository;
    }

    public Message saveMassage(Message message) {
        return messageRepository.save(message);
    }

    public Chat saveChat(Chat chat) {
        return chatRepository.save(chat);
    }
}
