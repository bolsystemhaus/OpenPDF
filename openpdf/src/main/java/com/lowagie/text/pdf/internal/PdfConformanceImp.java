package com.lowagie.text.pdf.internal;

import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.interfaces.*;

/**
 * New PDF Conformance implementation. Implements {@link com.lowagie.text.pdf.interfaces.PdfXConformance for backward compability}
 */
public class PdfConformanceImp implements PdfConformance, PdfXConformance{

    private final PdfXConformanceImp pdfXConformanceImp = new PdfXConformanceImp();

    // Not needed because the {@link pdfXConformanceImp} handles this, as to guarantee backward compatibility.
    // private PDFXConformance pdfXConformance;
    private PdfAConformance pdfAConformance = PdfAConformance.PDFANone;
    private PdfUaConformance pdfUaConformance = PdfUaConformance.PDFUANone;

    @Override
    public void setPdfXConformance(PdfXConformance pdfxConformance) {
        // Use the old iText 2.1.7 implementation. Maps the enum to an integer.
        int oldPdfXConformance = 0;
        switch (pdfxConformance){
            case PDFXNone:
                oldPdfXConformance = 0;
                break;
            case PDFX1A2001:
                oldPdfXConformance = 1;
                break;
            case PDFX32002:
                oldPdfXConformance = 2;
                break;
        }

        setPDFXConformance(oldPdfXConformance);
    }

    @Override
    public PdfXConformance getPdfXConformance() {
        // Use the old iText 2.1.7 implementation. Maps the integer to an enum.
        int oldPdfXConformance = getPDFXConformance();
        switch (oldPdfXConformance){
            case 0:
            default:
                return PdfXConformance.PDFXNone;
            case 1:
                return PdfXConformance.PDFX1A2001;
            case 2:
                return PdfXConformance.PDFX32002;
        }
    }

    @Override
    public void setPdfAConformance(PdfAConformance pdfAConformance) {
        this.pdfAConformance = pdfAConformance;
    }

    @Override
    public PdfAConformance getPdfAConformance() {
        return pdfAConformance;
    }

    @Override
    public void setPdfUaConformance(PdfUaConformance pdfUaConformance) {
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
    public static void checkPDFXConformance(PdfWriter writer, int key, Object obj1) {
        PdfXConformanceImp.checkPDFXConformance(writer, key, obj1);
    }

//region Implementation of the deprecated {@link PdfXConformance} Interface.

    @Override
    @Deprecated
    public void setPDFXConformance(int pdfxConformance) {
        pdfXConformanceImp.setPDFXConformance(pdfxConformance);
    }

    @Override
    @Deprecated
    public int getPDFXConformance() {
        return pdfXConformanceImp.getPDFXConformance();
    }

    @Override
    @Deprecated
    public boolean isPdfX() {
        return pdfXConformanceImp.isPdfX();
    }

//endregion
}
