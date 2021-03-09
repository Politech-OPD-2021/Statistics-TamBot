package bot.service;

import bot.domain.Message;
import bot.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotService {
    private final MessageRepository messageRepository;

    @Autowired
    public BotService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message saveMassage(Message message) {
        return messageRepository.save(message);
    }
}
