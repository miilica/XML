//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.10 at 12:08:36 PM CEST 
//


package com.example.xmlserviceoglas.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TVozilo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TVozilo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="markaAutomobilaId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="tipGorivaId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="tipMjenjacaId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="klasaAutomobilaId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="kilometraza" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="brSjedistaZaDjecu" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="imaAndroid" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="coliisionDamageWavier" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TVozilo", propOrder = {
    "id",
    "markaAutomobilaId",
    "tipGorivaId",
    "tipMjenjacaId",
    "klasaAutomobilaId",
    "userId",
    "kilometraza",
    "brSjedistaZaDjecu",
    "imaAndroid",
    "coliisionDamageWavier"
})
public class TVozilo {

    protected long id;
    protected long markaAutomobilaId;
    protected long tipGorivaId;
    protected long tipMjenjacaId;
    protected long klasaAutomobilaId;
    protected long userId;
    protected double kilometraza;
    protected int brSjedistaZaDjecu;
    protected boolean imaAndroid;
    protected boolean coliisionDamageWavier;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the markaAutomobilaId property.
     * 
     */
    public long getMarkaAutomobilaId() {
        return markaAutomobilaId;
    }

    /**
     * Sets the value of the markaAutomobilaId property.
     * 
     */
    public void setMarkaAutomobilaId(long value) {
        this.markaAutomobilaId = value;
    }

    /**
     * Gets the value of the tipGorivaId property.
     * 
     */
    public long getTipGorivaId() {
        return tipGorivaId;
    }

    /**
     * Sets the value of the tipGorivaId property.
     * 
     */
    public void setTipGorivaId(long value) {
        this.tipGorivaId = value;
    }

    /**
     * Gets the value of the tipMjenjacaId property.
     * 
     */
    public long getTipMjenjacaId() {
        return tipMjenjacaId;
    }

    /**
     * Sets the value of the tipMjenjacaId property.
     * 
     */
    public void setTipMjenjacaId(long value) {
        this.tipMjenjacaId = value;
    }

    /**
     * Gets the value of the klasaAutomobilaId property.
     * 
     */
    public long getKlasaAutomobilaId() {
        return klasaAutomobilaId;
    }

    /**
     * Sets the value of the klasaAutomobilaId property.
     * 
     */
    public void setKlasaAutomobilaId(long value) {
        this.klasaAutomobilaId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the kilometraza property.
     * 
     */
    public double getKilometraza() {
        return kilometraza;
    }

    /**
     * Sets the value of the kilometraza property.
     * 
     */
    public void setKilometraza(double value) {
        this.kilometraza = value;
    }

    /**
     * Gets the value of the brSjedistaZaDjecu property.
     * 
     */
    public int getBrSjedistaZaDjecu() {
        return brSjedistaZaDjecu;
    }

    /**
     * Sets the value of the brSjedistaZaDjecu property.
     * 
     */
    public void setBrSjedistaZaDjecu(int value) {
        this.brSjedistaZaDjecu = value;
    }

    /**
     * Gets the value of the imaAndroid property.
     * 
     */
    public boolean isImaAndroid() {
        return imaAndroid;
    }

    /**
     * Sets the value of the imaAndroid property.
     * 
     */
    public void setImaAndroid(boolean value) {
        this.imaAndroid = value;
    }

    /**
     * Gets the value of the coliisionDamageWavier property.
     * 
     */
    public boolean isColiisionDamageWavier() {
        return coliisionDamageWavier;
    }

    /**
     * Sets the value of the coliisionDamageWavier property.
     * 
     */
    public void setColiisionDamageWavier(boolean value) {
        this.coliisionDamageWavier = value;
    }

}
