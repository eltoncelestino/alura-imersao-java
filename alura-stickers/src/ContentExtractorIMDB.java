import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentExtractorIMDB  implements ContentExtractor {
  public List<Content> extractContents(String json) {
    var parser = new JsonParser();
    List<Map<String, String>> attributeList = parser.parse(json);

    List<Content> contents = new ArrayList<>();

    for (Map<String, String> attributes: attributeList) {
      String title = attributes.get("title");
      String urlImage = attributes.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
      var content = new Content(title, urlImage);

      contents.add(content);
    }

    return contents;
  }
}
