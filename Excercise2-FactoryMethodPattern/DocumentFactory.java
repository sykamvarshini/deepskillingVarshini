public abstract class DocumentFactory {

    public abstract Document createDocument();

    public void newDocument() {
        Document document = createDocument();
        document.open();
    }
}