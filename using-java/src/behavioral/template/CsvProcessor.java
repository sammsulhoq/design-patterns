package behavioral.template;

public class CsvProcessor extends DocumentProcessor{
    @Override
    protected void openFile(String path) {
        System.out.println("Opening CSV file: " + path);
    }

    @Override
    protected void extractData() {
        System.out.println("Reading rows and columns from CSV...");
    }
}
