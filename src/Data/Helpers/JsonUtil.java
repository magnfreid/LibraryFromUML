package Data.Helpers;

import Medium.Medium.Medium;
import Members.Member;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonUtil {

    private static final String JSON_FILE_PATH = "src/Data/library_data.json"; // Change this to your file path
    static Gson gson = new GsonBuilder().registerTypeAdapter(Medium.class, new MediumDeserializer()) // Register custom deserializer
            .setPrettyPrinting()
            .create();

    public static LibraryData readLibraryData() {
        LibraryData libraryData = null;
        try (BufferedReader br = new BufferedReader(new FileReader(JSON_FILE_PATH))) {
            libraryData = gson.fromJson(br, LibraryData.class);
            System.out.println("Library data read.");
        } catch (IOException e) {
            System.out.println("Database error.");
            e.printStackTrace();
            return  new LibraryData();
        }
        return libraryData;
    }

    public static void writeLibraryData(LibraryData libraryData) {
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)) {
            gson.toJson(libraryData, writer); // Serialize LibraryData to JSON
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveLibraryData(ArrayList<Medium> mediums, ArrayList<Member> members) {
        LibraryData libraryData = new LibraryData();
        libraryData.setMediums(mediums);
        libraryData.setMembers(members);
        JsonUtil.writeLibraryData(libraryData); // Write updated data back to JSON
    }
}
