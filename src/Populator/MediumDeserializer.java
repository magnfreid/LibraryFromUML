package Populator;

import com.google.gson.*;
import Medium.Creators.Author;
import Medium.Creators.Director;
import Medium.Creators.Publisher;
import Medium.Medium.Types.Book;
import Medium.Medium.Types.DVD;
import Medium.Medium.Types.Magazine;
import Medium.Medium.Medium;

import java.lang.reflect.Type;

public class MediumDeserializer implements JsonDeserializer<Medium> {

    @Override
    public Medium deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String title = jsonObject.get("title").getAsString();
        String mediumType = jsonObject.get("type").getAsString(); // Extracting the "type" field from JSON
        int year = jsonObject.get("year").getAsInt();

        // Check the "type" field to determine which subclass of Medium to create
        switch (mediumType) {
            case "book": {
                int pages = jsonObject.get("pages").getAsInt();
                String authorName = jsonObject.get("creator").getAsJsonObject().get("name").getAsString();
                return new Book(title, new Author(authorName), year, pages);
            }
            case "magazine": {
                int pages = jsonObject.get("pages").getAsInt();
                String publisherName = jsonObject.get("creator").getAsJsonObject().get("name").getAsString();
                return new Magazine(title, year, pages, new Publisher(publisherName));
            }
            case "dvd": {
                int lengthMinutes = jsonObject.get("lengthMinutes").getAsInt();
                String directorName = jsonObject.get("creator").getAsJsonObject().get("name").getAsString();
                return new DVD(title, year, lengthMinutes, new Director(directorName));
            }
            default:
                throw new JsonParseException("Unknown Medium type: " + mediumType);
        }
    }
}
