package bot;

import chat.tamtam.botapi.client.TamTamClient;
import chat.tamtam.botapi.client.TamTamSerializer;
import chat.tamtam.botapi.client.TamTamTransportClient;
import chat.tamtam.botapi.client.impl.JacksonSerializer;
import chat.tamtam.botapi.client.impl.OkHttpTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:bot.properties")
public class BotContext {
    @Value("${accessToken}")
    private String accessToken;

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
