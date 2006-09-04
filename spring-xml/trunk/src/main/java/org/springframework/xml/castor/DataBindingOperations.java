package org.springframework.xml.castor;

import java.io.IOException;
import java.io.Writer;

import org.xml.sax.InputSource;

public interface DataBindingOperations {

    /**
     * Marshalls the given object to its XML representation, and streams it to 
     * the Writer instance provided.
     * @param object The Object instance to be marshalled.
     * @param writer The Writer instance to capture the XML representation.
     * @throws MarshallingException If the marshalling fails
     * @throws IOException If there's a problem with accessing the writer instance.
     */
    void marshal(Object object, Writer writer) 
    throws MarshallingException, IOException, ValidationException;
    
    /**
     * Unmarshalls the given XML data into its object equivalent, taking the XML
     * data from the InputSource provided.
     * @param inputSource A SAX InputSource.
     * @param type The expected object type.
     * @return An object instance, as a resulf of the unmarshalling.
     * @throws MarshallingException If there's a problem with unmarshalling
     * @throws IOException If there's a problem with accessing the InputSource
     */
    Object unmarshal(InputSource inputSource, Class type)
    throws MarshallingException, IOException, ValidationException;
    
}