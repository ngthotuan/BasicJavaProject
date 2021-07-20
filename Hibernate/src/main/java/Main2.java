import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class Main2 {
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    private static final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");

    public static String toSlug(String input) {
        String nonwhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nonwhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        slug = EDGESDHASHES.matcher(slug).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
    public static void main(String[] args) {
        String s = "Xuân Tuấn óc chó  ?";
        System.out.println(toSlug(s.trim().replaceAll(" ", "  ")));
    }
}
