package behavioral.template;

public class DocProcessor extends DocumentProcessor{
    @Override
    protected void openFile(String path) {
        System.out.println("Opening DOC file: " + path);
    }

    @Override
    protected void extractData() {
        System.out.println("Extracting text and metadata from DOC file...");
    }
}
