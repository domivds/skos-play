//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.21 at 06:37:12 PM CEST 
//


package fr.sparna.rdf.skos.printer.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for display complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="display">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.sparna.fr/thesaurus-display}header"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{http://www.sparna.fr/thesaurus-display}alphabetical"/>
 *           &lt;element ref="{http://www.sparna.fr/thesaurus-display}hierarchical"/>
 *           &lt;element ref="{http://www.sparna.fr/thesaurus-display}translationTable"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "display", propOrder = {
    "header",
    "alphabeticalOrHierarchicalOrTranslationTable"
})
@XmlRootElement
public class Display {

    @XmlElement(required = true)
    protected DisplayHeader header;
    @XmlElements({
        @XmlElement(name = "hierarchical", type = Hierarchical.class),
        @XmlElement(name = "translationTable", type = TranslationTable.class),
        @XmlElement(name = "alphabetical", type = Alphabetical.class)
    })
    protected List<Object> alphabeticalOrHierarchicalOrTranslationTable;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayHeader }
     *     
     */
    public DisplayHeader getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayHeader }
     *     
     */
    public void setHeader(DisplayHeader value) {
        this.header = value;
    }

    /**
     * Gets the value of the alphabeticalOrHierarchicalOrTranslationTable property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alphabeticalOrHierarchicalOrTranslationTable property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlphabeticalOrHierarchicalOrTranslationTable().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Hierarchical }
     * {@link TranslationTable }
     * {@link Alphabetical }
     * 
     * 
     */
    public List<Object> getAlphabeticalOrHierarchicalOrTranslationTable() {
        if (alphabeticalOrHierarchicalOrTranslationTable == null) {
            alphabeticalOrHierarchicalOrTranslationTable = new ArrayList<Object>();
        }
        return this.alphabeticalOrHierarchicalOrTranslationTable;
    }

}
