package com.lowagie.text.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.lowagie.text.Document;

public class PdfSmartCopyVsPdfCopyTest {

    private static final File ORIGINAL_FILE = new File("src/test/resources/pdfsmartcopy_bec.pdf");
    private static final File OUTPUT_FILE_COPY = new File("target/test-classes/pdfcopy.pdf");

    public PdfSmartCopyVsPdfCopyTest() {
        super();
    }

    /**
     * Copy sample pdf document using PdfCopy and assert than operation will complete within 5 seconds
     */
    @Test
    public void pdfCopyTest() {
        Assertions.assertTimeout(Duration.ofSeconds(5), () -> {
            OUTPUT_FILE_COPY.getParentFile().mkdirs();
            Document document = new Document();
            FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE_COPY);
            PdfCopy copy = new PdfCopy(document, outputStream);
            document.open();

            PdfReader reader = new PdfReader(ORIGINAL_FILE.getAbsolutePath());
            int n = reader.getNumberOfPages();
            for (int currentPage = 1; currentPage <= n; currentPage++) {
                PdfImportedPage page = copy.getImportedPage(reader, currentPage);
                copy.addPage(page);
            }
            copy.freeReader(reader);
            reader.close();
            document.close();
            copy.close();
        });
    }

}
