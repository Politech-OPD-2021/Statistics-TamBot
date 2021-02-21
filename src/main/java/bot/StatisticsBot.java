package bot;

import chat.tamtam.bot.exceptions.TamTamBotException;
import chat.tamtam.bot.longpolling.LongPollingBot;
import chat.tamtam.bot.longpolling.LongPollingBotOptions;
import chat.tamtam.botapi.client.TamTamClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;

@Component
public class StatisticsBot extends LongPollingBot {
    private static final Log LOG = LogFactory.getLog(MethodHandles.lookup().lookupClass());

    @Autowired
    public StatisticsBot(TamTamClient client) {
        super(client, LongPollingBotOptions.DEFAULT);
        LOG.info("StatisticsBot created");
    }

    @PostConstruct
    public void init() {
        try {
            start();
        } catch (TamTamBotException e) {
            LOG.error("Failed to start bot", e);
        }
    }
}
