//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2014.09.03 à 03:11:33 PM IRDT 
//


package org.labcrypto.edusys.ws.gheyas.schemas;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GheyasGroups" type="{http://gheyas.ws.edusys.labcrypto.org/schemas}GheyasClassGroupType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gheyasGroups"
})
@XmlRootElement(name = "GetGroupsResponse")
public class GetGroupsResponse {

    @XmlElement(name = "GheyasGroups", required = true)
    protected List<GheyasClassGroupType> gheyasGroups;

    /**
     * Gets the value of the gheyasGroups property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gheyasGroups property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGheyasGroups().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GheyasClassGroupType }
     * 
     * 
     */
    public List<GheyasClassGroupType> getGheyasGroups() {
        if (gheyasGroups == null) {
            gheyasGroups = new ArrayList<GheyasClassGroupType>();
        }
        return this.gheyasGroups;
    }

}
