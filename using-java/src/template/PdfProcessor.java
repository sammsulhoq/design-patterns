package template;

public class PdfProcessor extends DocumentProcessor{
    @Override
    protected void openFile(String path) {
        System.out.println("Opening PDF file: " + path);
    }

    @Override
    protected void extractData() {
        System.out.println("Parsing content from PDF pages...");
    }

    @Override
    protected void afterProcessing() {
        System.out.println("Closing PDF resources and cleaning up...");
    }
}
