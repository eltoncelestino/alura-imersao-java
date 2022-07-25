import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // String url = "https://alura-imdb-api.herokuapp.com/movies";
        // ContentExtractor extractor = new ContentExtractorIMDB();

        // String url = "https://api.nasa.gov/planetary/apod?api_key=6fBAwYg1D3ejMknqJvUha3KSGrYKMFIN0tHQhvoc&start_date=2022-06-12&end_date=2022-06-14";        
        // ContentExtractor extractor = new ContentExtractorNasa();

        String url = "http://localhost:8080/linguagens";
        ContentExtractor extractor = new ContentExtractorIMDB();
        
        var client = new ClientHttp();
        String json = client.fetchData(url); 

        List<Content> contents = extractor.extractContents(json);

        var generator = new StickerGenerator();

        for (int i = 0; i < 3; i++) {
            Content content = contents.get(i);

            InputStream inputStream = new URL(content.getUrlImage()).openStream();
            String fileName = "output/" + content.getTitle() + ".png";

            generator.create(inputStream, fileName);

            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}
