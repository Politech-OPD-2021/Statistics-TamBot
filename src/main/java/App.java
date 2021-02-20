import chat.tamtam.bot.exceptions.TamTamBotException;

public class App {
    public static void main(String args[]) throws TamTamBotException {
        PingPongBot bot = new PingPongBot("G4oEQblmg6m0Y7Ov-zfCXdyL3jqWJrxE8XHOVmVUJZ8");
        bot.start();
    }
}
