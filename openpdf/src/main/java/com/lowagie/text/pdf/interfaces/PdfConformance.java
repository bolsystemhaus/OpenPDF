package com.lowagie.text.pdf.interfaces;


public interface PdfConformance {

    enum PdfXConformance {PDFXNone, PDFX1A2001, PDFX32002}
    enum PdfAConformance {PDFANone, PDFA1A, PDFA1B}
    enum PdfUaConformance {PDFUANone, PDFUA1}

    /**
     * Sets the PDF/X conformance level.
     * It must be called before opening the document.
     * @param pdfxConformance the conformance level
     */
    void setPdfConformance(PdfXConformance pdfxConformance);

    /**
     * Getter for the PDF/X Conformance value.
     * @return the PDF/X Conformance value.
     */
    PdfXConformance getPdfXConformance();

    /**
     * Sets the PDF/X conformance level.
     * It must be called before opening the document.
     * @param pdfAConformance the conformance level.
     */
    void setPdfConformance(PdfAConformance pdfAConformance);

    /**
     * Getter for the PDF/A Conformance value.
     * @return the PDF/A Conformance value.
     */
    PdfAConformance getPdfAConformance();

    /**
     * Sets the PDF/UA conformance level.
     * It must be called before opening the document.
     * @param pdfUaConformance the conformance level.
     */
    void setPdfConformance(PdfUaConformance pdfUaConformance);

    /**
     * Getter for the PDF/UA Conformance value.
     * @return the PDF/UA Conformance value.
     */
    PdfUaConformance getPdfUaConformance();
}
