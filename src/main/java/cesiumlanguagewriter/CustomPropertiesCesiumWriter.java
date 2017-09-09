package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.CustomPropertyCesiumWriter;

/**
 *  
 Writes a {@code CustomProperties} to a {@link CesiumOutputStream}.  A {@code CustomProperties} is a set of custom properties.
 

 */
@SuppressWarnings("unused")
public class CustomPropertiesCesiumWriter extends CesiumPropertyWriter<CustomPropertiesCesiumWriter> {
    /**
    *  
    Initializes a new instance.
    

    */
    public CustomPropertiesCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected CustomPropertiesCesiumWriter(CustomPropertiesCesiumWriter existingInstance) {
        super(existingInstance);
    }

    @Override
    public CustomPropertiesCesiumWriter clone() {
        return new CustomPropertiesCesiumWriter(this);
    }

    /**
    *  
    Gets a new writer for a {@code CustomProperty} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  A {@code CustomProperty} property defines a custom property.
    

    */
    public final CustomPropertyCesiumWriter getCustomPropertyWriter(String name) {
        return new CustomPropertyCesiumWriter(name);
    }

    /**
    *  
    Opens and returns a new writer for a {@code CustomProperty} property.  A {@code CustomProperty} property defines a custom property.
    
    

    * @param name The name of the new property writer.
    */
    public final CustomPropertyCesiumWriter openCustomPropertyProperty(String name) {
        openIntervalIfNecessary();
        return this.<CustomPropertyCesiumWriter> openAndReturn(new CustomPropertyCesiumWriter(name));
    }
}