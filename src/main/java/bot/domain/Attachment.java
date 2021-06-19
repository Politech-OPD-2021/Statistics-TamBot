package bot.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Attachment {

    @Id
    private Long messageId;
    
    //TODO: + переменная для для хранения файлов


}
