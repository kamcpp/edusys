//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.16 at 11:21:08 AM IRST 
//


package com.mftvanak.edusys.ws.authentication.schemas;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mftvanak.edusys.ws.authentication.schemas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mftvanak.edusys.ws.authentication.schemas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserExistsByUsernameRequest }
     * 
     */
    public UserExistsByUsernameRequest createUserExistsByUsernameRequest() {
        return new UserExistsByUsernameRequest();
    }

    /**
     * Create an instance of {@link DeactivateTokenResponse }
     * 
     */
    public DeactivateTokenResponse createDeactivateTokenResponse() {
        return new DeactivateTokenResponse();
    }

    /**
     * Create an instance of {@link DeactivateTokenRequest }
     * 
     */
    public DeactivateTokenRequest createDeactivateTokenRequest() {
        return new DeactivateTokenRequest();
    }

    /**
     * Create an instance of {@link UserExistsByEmailRequest }
     * 
     */
    public UserExistsByEmailRequest createUserExistsByEmailRequest() {
        return new UserExistsByEmailRequest();
    }

    /**
     * Create an instance of {@link UserExistsByUsernameResponse }
     * 
     */
    public UserExistsByUsernameResponse createUserExistsByUsernameResponse() {
        return new UserExistsByUsernameResponse();
    }

    /**
     * Create an instance of {@link ValidateTokenRequest }
     * 
     */
    public ValidateTokenRequest createValidateTokenRequest() {
        return new ValidateTokenRequest();
    }

    /**
     * Create an instance of {@link ValidateTokenResponse }
     * 
     */
    public ValidateTokenResponse createValidateTokenResponse() {
        return new ValidateTokenResponse();
    }

    /**
     * Create an instance of {@link RoleType }
     * 
     */
    public RoleType createRoleType() {
        return new RoleType();
    }

    /**
     * Create an instance of {@link UserExistsByEmailResponse }
     * 
     */
    public UserExistsByEmailResponse createUserExistsByEmailResponse() {
        return new UserExistsByEmailResponse();
    }

    /**
     * Create an instance of {@link AuthenticationRequest }
     * 
     */
    public AuthenticationRequest createAuthenticationRequest() {
        return new AuthenticationRequest();
    }

    /**
     * Create an instance of {@link ChangePasswordRequest }
     * 
     */
    public ChangePasswordRequest createChangePasswordRequest() {
        return new ChangePasswordRequest();
    }

    /**
     * Create an instance of {@link AuthenticationResponse }
     * 
     */
    public AuthenticationResponse createAuthenticationResponse() {
        return new AuthenticationResponse();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

}
