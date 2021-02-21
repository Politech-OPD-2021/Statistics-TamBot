import chat.tamtam.botapi.client.TamTamClient;
import chat.tamtam.botapi.client.TamTamSerializer;
import chat.tamtam.botapi.client.TamTamTransportClient;
import chat.tamtam.botapi.client.impl.JacksonSerializer;
import chat.tamtam.botapi.client.impl.OkHttpTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotContext {
    private final String accessToken = "";

    @Bean
    public TamTamTransportClient tamTamTransportClient() {
      return new OkHttpTransportClient();
    }

    @Bean
    public TamTamSerializer tamTamSerializer() {
        return new JacksonSerializer();
    }

    @Bean
    public TamTamClient tamTamClient(TamTamTransportClient tamTamTransportClient, TamTamSerializer tamTamSerializer) {
        return new TamTamClient(accessToken, tamTamTransportClient, tamTamSerializer);
    }
}
