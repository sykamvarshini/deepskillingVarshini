public class FactoryMethodTest {

    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.newDocument();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.newDocument();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.newDocument();
    }
}