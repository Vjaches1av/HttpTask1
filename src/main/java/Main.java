import animal.About;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.GETRequest;
import org.jetbrains.annotations.NotNull;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static @NotNull List<About> jsonParsing(String json) {
        List<About> list = new ArrayList<>();
        for (JsonElement i : JsonParser.parseString(json).getAsJsonArray()) {
            list.add(new GsonBuilder()
                    .serializeNulls()
                    .create()
                    .fromJson(i, About.class));
        }
        return list;
    }

    private static <T> void printList(@NotNull List<T> list) {
        for (T t : list) System.out.println(t);
    }

    public static void main(String[] args) {
        String url = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";
        try {
            GETRequest request = new GETRequest(url);
            if (request.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                List<About> list = jsonParsing(request.getRequest());
                List<About> filteredListByUpvote = list.stream()
                        .filter(about -> about.getUpvote() != null
                                && about.getUpvote() > 0)
                        .collect(Collectors.toList());
                printList(filteredListByUpvote);
            }
        } catch (IOException e) {
            System.err.println("Ошибка получения данных, попробуйте повторить запрос позже.");
        }
    }
}
