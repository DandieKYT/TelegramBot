package bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Random;

import static java.lang.Thread.sleep;


public class Bot extends TelegramLongPollingBot {

    public String getBotUsername() {
        return "";
    }

    public String getBotToken() {
        return "";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            try {
                String messageText = update.getMessage().getText().toLowerCase();
                String chatId = update.getMessage().getChatId().toString();

                if (messageText.contains("забив")) {
                    sendImage(chatId);
                }

            } catch (TelegramApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getUrl() {
        String[] myStrings = {
                "https://downloader.disk.yandex.ru/preview/2a795409225aef459f49c4de51164fe4a17b4b00f4e338d58a5bbd3048a7c073/671974bb/bukRuEiHjFBO5qPJFy2nV1mXsz8qHih6dnOxKw239beRgOudCO0chSABUm5kSVoddbYPW513lmRCi3NqLuXXdQ%3D%3D?uid=0&filename=1.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=2543x1262",
                "https://downloader.disk.yandex.ru/preview/79fc2731d81071337cc134220554df606dd13a2ae0c72314f845f623730a3f33/671974bb/M_NgDktted5czGaq6l3Wa_1n464vkxkNtGcmFZkYbHyriPakE0IAJhDWGXen4YVeaYdZuQuJFQSyiEEjDLCavg%3D%3D?uid=0&filename=2.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/5d7e146ee567300428f8a0fe0a7218c4a66b74d1d3d61878c964bfb2131116b1/671974bb/7m7md198Oq53OcCIMBRfXm3XjKhSkBoC5aMy3jXEMLfYGa_klbl0SVlHEpL--BWYFUdQim1_vZGkfMV4sdHqZg%3D%3D?uid=0&filename=3.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/cd2b949c8f81bf6f73ad9a8da1eeeec006d9b335300f6fa06403b640d89954ca/671974bb/d0rFfr4nyO3llNIvtQrkGt_IkzJdzhmDC5_82d76mj9TfzguIj3oOptK5Fim3hJFk9Sv5LtqXXNdS50Bil33CQ%3D%3D?uid=0&filename=4.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/da237e64abc7e1d398f390b55ddc76bc24d16e646a051135e6511b57d24f1cad/671974bb/gK4GznCq8A-6Tuzy6V9gEqNbGI_9hf1TnlnHxClBPoeZX9dckD4CiCDt8CuDMgwLc-x7LHxuGRRPl3JeILGC5g%3D%3D?uid=0&filename=5.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/0ca39abc5d2427951643daf8bc668c56b75a1478d52d8adb5d8354176679f5c2/671974bb/eSHh7yFUJxRrOHB5V26xt_1n464vkxkNtGcmFZkYbHyL_E6Y6otFq2zNWEyl3NFLH5YXH1TvsXmimM1flpbqog%3D%3D?uid=0&filename=6.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/b287724ce74d63eaf27c14f8b069289a9a4cdf1df187fb4926b41669984ac100/671974bb/mTnGaaiBdMGmtEZK9sb1E1mXsz8qHih6dnOxKw239bcPgFommApoq-cm4Yl33vLC4U3mQCk6TrbxBPjM1VqMCA%3D%3D?uid=0&filename=7.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/a433fead6800511c4c0064b2ca71523687936a2f116bf68f7323b2d6bc430f3d/671974bb/HJhiofKGgyNuq5DIaOEPrVmXsz8qHih6dnOxKw239bdlI4FBMh8xqN5laSlSjYdFtmxppvbVTc24P3vBNC934A%3D%3D?uid=0&filename=8.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/5a287df639c0b8c2ada1d0363595a9d9da7c570bb2efca691b54040a95811656/671974bb/zl_9R0TE4oIXxjeHDbGXZ1mXsz8qHih6dnOxKw239bePICB4k1S2HSXI-uG4036KpvIEpJ8e7h95j6XqhkqmqQ%3D%3D?uid=0&filename=9.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/bf9d3fb506cfa089f88469f3e8386c482e7437d1ab1d9a1fa74054e0eefd6a4a/671974bb/BDCxFTBY55zKZIJUdHQSclmXsz8qHih6dnOxKw239bdyuNfjdkHeSSpFa78VZiSbvF86W6L8dBRwVQxMEczJSA%3D%3D?uid=0&filename=10.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/9bff04739f4b61fe8f28d5923e2c6f1db18ab176742635a82cf2a0167f9481ff/671974bb/AmVQbz4eTazflbdowTSqD512l4QMS7BPQ6hz4cIQpOxJxfR1PvtLFQuQdf63mLDJhrLyVXZX1fuF1nV7S3LoBQ%3D%3D?uid=0&filename=11.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/4a7604fb8a6789d5d4f545c9f649e5cfa29559e4ba55339de879177058cde68b/671974bb/QxOof5Nosg7_cSqopiWiO4LM347Dkn-3m2aPXQQ5YuLqGHvjOBJ1np489WAooekkJ8j_Cp1Th6cyPpY99vSjEQ%3D%3D?uid=0&filename=12.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
                "https://downloader.disk.yandex.ru/preview/4a3fa406d9703b7a62a7eddd815eaeb75cfd87b82d6241d893a9ea35659ae896/671974bb/DtT7FYxAKyggZ2_Z73RP5lmXsz8qHih6dnOxKw239beSaYqoSSJ-YvU3adCzk-p4OHe0heeeDVNIlJfHdquWnw%3D%3D?uid=0&filename=13.jpg&disposition=inline&hash=&limit=0&content_type=image%2Fjpeg&owner_uid=0&tknv=v2&size=1903x902",
        };
        String randomString = getRandomString(myStrings);
        return randomString;
    }

    public static String getRandomString(String[] strings) {
        Random random = new Random();
        int randomIndex = random.nextInt(strings.length);
        return strings[randomIndex];
    }

    private void sendImage(String chatId) throws TelegramApiException, InterruptedException {
        sleep(4000);
        InputFile photo = new InputFile(getUrl());
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(photo);
        execute(sendPhoto);
    }


}



