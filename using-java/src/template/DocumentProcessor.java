package template;

public abstract class DocumentProcessor {
    public final void processDocument(String path) {
        beforeProcessing();
        openFile(path);
        extractData();
        analyzeData();
        composeReport();
        afterProcessing();
    }

    protected abstract void openFile(String path);
    protected abstract void extractData();
    protected void analyzeData() {
        System.out.println("Analyzing data...");
    }

    protected void composeReport() {
        System.out.println("Composing report based on analyzed data...");
    }

    protected void beforeProcessing() {}

    protected void afterProcessing() {}
}
