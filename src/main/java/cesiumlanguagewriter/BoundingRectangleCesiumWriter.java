package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BoundingRectangle;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a {@code BoundingRectangle} to a {@link CesiumOutputStream}.  A {@code BoundingRectangle} is a bounding rectangle specified by a corner, width and height.
 

 */
@SuppressWarnings("unused")
public class BoundingRectangleCesiumWriter extends CesiumInterpolatablePropertyWriter<BoundingRectangleCesiumWriter> {
    /**
    *  
    The name of the {@code boundingRectangle} property.
    

    */
    public static final String BoundingRectanglePropertyName = "boundingRectangle";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    private Lazy<ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>> m_asBoundingRectangle;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    

    */
    public BoundingRectangleCesiumWriter(String propertyName) {
        super(propertyName);
        m_asBoundingRectangle = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(this, "createBoundingRectangleAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> invoke() {
                        return createBoundingRectangleAdaptor();
                    }
                }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor", new Class[] {}) {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createReferenceAdaptor();
            }
        }, false);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected BoundingRectangleCesiumWriter(BoundingRectangleCesiumWriter existingInstance) {
        super(existingInstance);
        m_asBoundingRectangle = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle>>(this, "createBoundingRectangleAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> invoke() {
                        return createBoundingRectangleAdaptor();
                    }
                }, false);
        m_asReference = new Lazy<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(new Func1<cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference>>(this,
                "createReferenceAdaptor", new Class[] {}) {
            public cesiumlanguagewriter.advanced.ICesiumValuePropertyWriter<Reference> invoke() {
                return createReferenceAdaptor();
            }
        }, false);
    }

    @Override
    public BoundingRectangleCesiumWriter clone() {
        return new BoundingRectangleCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code boundingRectangle}, which is the bounding rectangle specified as {@code [X, Y, Width, Height]}.
    
    

    * @param value The value.
    */
    public final void writeBoundingRectangle(BoundingRectangle value) {
        final String PropertyName = BoundingRectanglePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeBoundingRectangle(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code boundingRectangle}, which is the bounding rectangle specified as {@code [X, Y, Width, Height]}.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values) {
        writeBoundingRectangle(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code boundingRectangle}, which is the bounding rectangle specified as {@code [X, Y, Width, Height]}.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeBoundingRectangle(List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
        final String PropertyName = BoundingRectanglePropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeBoundingRectangle(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the bounding rectangle specified as a reference to another property.
    
    

    * @param value The reference.
    */
    public final void writeReference(Reference value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the bounding rectangle specified as a reference to another property.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeReference(String value) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), value);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the bounding rectangle specified as a reference to another property.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeReference(String identifier, String propertyName) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyName);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the bounding rectangle specified as a reference to another property.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeReference(String identifier, String[] propertyNames) {
        final String PropertyName = ReferencePropertyName;
        openIntervalIfNecessary();
        getOutput().writePropertyName(PropertyName);
        CesiumWritingHelper.writeReference(getOutput(), identifier, propertyNames);
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code BoundingRectangle} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> asBoundingRectangle() {
        return m_asBoundingRectangle.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<BoundingRectangle> createBoundingRectangleAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.BoundingRectangle>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.BoundingRectangle>() {
                    public void invoke(BoundingRectangleCesiumWriter me, BoundingRectangle value) {
                        me.writeBoundingRectangle(value);
                    }
                }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.BoundingRectangle>() {
                    public void invoke(BoundingRectangleCesiumWriter me, List<JulianDate> dates, List<BoundingRectangle> values, int startIndex, int length) {
                        me.writeBoundingRectangle(dates, values, startIndex, length);
                    }
                });
    }

    /**
    *  
    Returns a wrapper for this instance that implements {@link ICesiumValuePropertyWriter} to write a value in {@code Reference} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumValuePropertyWriter<Reference> asReference() {
        return m_asReference.getValue();
    }

    private final ICesiumValuePropertyWriter<Reference> createReferenceAdaptor() {
        return new CesiumWriterAdaptor<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.BoundingRectangleCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(BoundingRectangleCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}