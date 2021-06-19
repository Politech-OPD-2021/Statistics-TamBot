package bot.repository;

import bot.domain.Chat;
import bot.domain.ChatPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, ChatPK> {

}
