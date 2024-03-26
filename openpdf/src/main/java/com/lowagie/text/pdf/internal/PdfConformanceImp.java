package com.lowagie.text.pdf.internal;

import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.interfaces.*;

/**
 * New PDF Conformance implementation. Implements {@link com.lowagie.text.pdf.interfaces.PdfXConformance for backward compability}
 */
public class PdfConformanceImp implements PdfConformance{

    private final PdfXConformanceImp pdfXConformanceImp = new PdfXConformanceImp();

    // Not needed because the {@link pdfXConformanceImp} handles this, as to guarantee backward compatibility.
    // private PDFXConformance pdfXConformance;
    private PdfAConformance pdfAConformance = PdfAConformance.PDFANone;
    private PdfUaConformance pdfUaConformance = PdfUaConformance.PDFUANone;

    @Override
    public void setPdfConformance(PdfXConformance pdfxConformance) {
        // Use the old iText 2.1.7 implementation. Maps the enum to an integer.
        int oldPdfXConformance = pdfxConformance.ordinal();
        pdfXConformanceImp.setPDFXConformance(oldPdfXConformance);
    }

    @Override
    public PdfXConformance getPdfXConformance() {
        // Use the old iText 2.1.7 implementation. Maps the integer to an enum.
        int oldPdfXConformance = pdfXConformanceImp.pdfxConformance;
        return PdfXConformance.values()[oldPdfXConformance];
    }

    @Override
    public void setPdfConformance(PdfAConformance pdfAConformance) {
        this.pdfAConformance = pdfAConformance;
    }

    @Override
    public PdfAConformance getPdfAConformance() {
        return pdfAConformance;
    }

    @Override
    public void setPdfConformance(PdfUaConformance pdfUaConformance) {
        this.pdfUaConformance = pdfUaConformance;
    }

    @Override
    public PdfUaConformance getPdfUaConformance() {
        return pdfUaConformance;
    }
    
    public void completeInfoDictionary(PdfDictionary info) {
        pdfXConformanceImp.completeInfoDictionary(info);
    }
    
    public void completeExtraCatalog(PdfDictionary extraCatalog) {
        pdfXConformanceImp.completeExtraCatalog(extraCatalog);
    }
    
    /**
     * @see PdfXConformanceImp#checkPDFXConformance(PdfWriter, int, Object)
     */
    public static void checkPdfXConformance(PdfWriter writer, int key, Object obj1) {
        PdfXConformanceImp.checkPDFXConformance(writer, key, obj1);
    }
}
