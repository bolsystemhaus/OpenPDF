package com.lowagie.text.xml.xmp;

/**
 * An implementation of an XmpSchema.
 */
public class PdfUaSchema extends XmpSchema {

    public static final String DEFAULT_XPATH_ID = "pdfuaid";
    public static final String DEFAULT_XPATH_URI = "http://www.aiim.org/pdfua/ns/id/";
    public static final String PART = "pdfuaid:part";
    public static final String EXTENSION_SCHEMA =
            "<rdf:li>\n" +
            "<rdf:Description\n" +
            "  pdfaSchema:namespaceURI=\"http://www.aiim.org/pdfua/ns/id/\"\n" +
            "  pdfaSchema:prefix=\"pdfuaid\"\n" +
            "  pdfaSchema:schema=\"PDF/UA identification schema\">\n" +
            "  <pdfaSchema:property>\n" +
            "    <rdf:Seq>\n" +
            "      <rdf:li\n" +
            "        pdfaProperty:category=\"internal\"\n" +
            "        pdfaProperty:description=\"PDF/UA version identifier\"\n" +
            "        pdfaProperty:name=\"part\"\n" +
            "        pdfaProperty:valueType=\"Integer\"/>\n" +
            "      <rdf:li\n" +
            "        pdfaProperty:category=\"internal\"\n" +
            "        pdfaProperty:description=\"PDF/UA amendment identifier\"\n" +
            "        pdfaProperty:name=\"amd\"\n" +
            "        pdfaProperty:valueType=\"Text\"/>\n" +
            "      <rdf:li\n" +
            "        pdfaProperty:category=\"internal\"\n" +
            "        pdfaProperty:description=\"PDF/UA corrigenda identifier\"\n" +
            "        pdfaProperty:name=\"corr\"\n" +
            "        pdfaProperty:valueType=\"Text\"/>\n" +
            "    </rdf:Seq>\n" +
            "  </pdfaSchema:property>\n" +
            "</rdf:Description>\n" +
            "</rdf:li>";

    private static final long serialVersionUID = -4255090341787237499L;

    public PdfUaSchema() {
        super("xmlns:" + DEFAULT_XPATH_ID + "=\"" + DEFAULT_XPATH_URI + "\"");
        additionalXmlns = new String[]{
                "xmlns:pdfaExtension=\"http://www.aiim.org/pdfa/ns/extension/\"",
                "xmlns:pdfaSchema=\"http://www.aiim.org/pdfa/ns/schema#\"",
                "xmlns:pdfaProperty=\"http://www.aiim.org/pdfa/ns/property#\""};
        addPart("1");
    }

    public void addPart(String part) {
        setProperty(PART, part);
    }

    @Override
    public boolean hasExtensionSchema() {
        return true;
    }

    @Override
    public String getExtensionSchema() {
        return EXTENSION_SCHEMA;
    }
}