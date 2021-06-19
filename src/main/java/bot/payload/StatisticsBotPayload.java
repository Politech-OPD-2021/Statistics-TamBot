package bot.payload;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ChooseChatPayload.class, name = StatisticsBotPayload.CHOOSE_CHAT_PAYLOAD)
})
public interface StatisticsBotPayload {
    String CHOOSE_CHAT_PAYLOAD = "pChooseChat";
}
