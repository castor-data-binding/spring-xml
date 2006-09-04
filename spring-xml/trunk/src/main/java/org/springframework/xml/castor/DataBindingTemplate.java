package org.springframework.xml.castor;

import java.io.IOException;
import java.io.Writer;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.xml.sax.InputSource;

public class DataBindingTemplate implements DataBindingOperations {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    /**
     * @see org.springframework.xml.castor.DataBindingOperations#marshal(java.lang.Object, java.io.Writer)
     */
    public void marshal(Object object, Writer writer) 
        throws MarshallingException, IOException, ValidationException {
        marshaller.setWriter(writer);
        try {
            marshaller.marshal(object);
        } catch (MarshalException e) {
            throw new MarshallingException(e.getMessage(), e);
        } catch (org.exolab.castor.xml.ValidationException e) {
            throw new ValidationException(e.getMessage(), e);
        }
    }

    /**
     * @throws ValidationException 
     * @see org.springframework.xml.castor.DataBindingOperations#unmarshal(org.xml.sax.InputSource, java.lang.Class)
     */
    public Object unmarshal(InputSource inputSource, Class type) throws MarshallingException, IOException, ValidationException {
        Object object;
        try {
            object = unmarshaller.unmarshal(inputSource);
        } catch (MarshalException e) {
            throw new MarshallingException(e.getMessage(), e);
        } catch (org.exolab.castor.xml.ValidationException e) {
            throw new ValidationException(e.getMessage(), e);
        }
        return object;
    }

    /**
     * Sets the Marshaller instance to use for marshalling.
     * @param marshaller Castor XML Marshaller instance
     */
    public void setMarshaller(final Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    /**
     * Sets the Unmarshaller instance to use for unmarshalling.
     * @param unmarshaller Castor XML UNmarshaller instance
     */
    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
    
    

}