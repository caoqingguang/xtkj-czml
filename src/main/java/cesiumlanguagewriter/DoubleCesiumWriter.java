package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.Reference;
import java.util.List;

/**
 *  
 Writes a {@code Double} to a {@link CesiumOutputStream}.  A {@code Double} is a floating-point number.
 

 */
@SuppressWarnings("unused")
public class DoubleCesiumWriter extends CesiumInterpolatablePropertyWriter<DoubleCesiumWriter> {
    /**
    *  
    The name of the {@code number} property.
    

    */
    public static final String NumberPropertyName = "number";
    /**
    *  
    The name of the {@code reference} property.
    

    */
    public static final String ReferencePropertyName = "reference";
    private Lazy<ICesiumInterpolatableValuePropertyWriter<Double>> m_asNumber;
    private Lazy<ICesiumValuePropertyWriter<Reference>> m_asReference;

    /**
    *  
    Initializes a new instance.
    

    */
    public DoubleCesiumWriter(String propertyName) {
        super(propertyName);
        m_asNumber = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(this, "createNumberAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double> invoke() {
                        return createNumberAdaptor();
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
    protected DoubleCesiumWriter(DoubleCesiumWriter existingInstance) {
        super(existingInstance);
        m_asNumber = new Lazy<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(
                new Func1<cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double>>(this, "createNumberAdaptor", new Class[] {}) {
                    public cesiumlanguagewriter.advanced.ICesiumInterpolatableValuePropertyWriter<Double> invoke() {
                        return createNumberAdaptor();
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
    public DoubleCesiumWriter clone() {
        return new DoubleCesiumWriter(this);
    }

    /**
    *  
    Writes the value expressed as a {@code number}, which is the number.
    
    

    * @param value The value.
    */
    public final void writeNumber(double value) {
        final String PropertyName = NumberPropertyName;
        if (getForceInterval()) {
            openIntervalIfNecessary();
        }
        if (getIsInterval()) {
            getOutput().writePropertyName(PropertyName);
        }
        getOutput().writeValue(value);
    }

    /**
    *  
    Writes the value expressed as a {@code number}, which is the number.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeNumber(List<JulianDate> dates, List<Double> values) {
        writeNumber(dates, values, 0, dates.size());
    }

    /**
    *  
    Writes the value expressed as a {@code number}, which is the number.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeNumber(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        final String PropertyName = NumberPropertyName;
        openIntervalIfNecessary();
        CesiumWritingHelper.writeDouble(getOutput(), PropertyName, dates, values, startIndex, length);
    }

    /**
    *  
    Writes the value expressed as a {@code reference}, which is the number specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the number specified as a reference to another property.
    
    

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
    Writes the value expressed as a {@code reference}, which is the number specified as a reference to another property.
    
    
    

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
    Writes the value expressed as a {@code reference}, which is the number specified as a reference to another property.
    
    
    

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
    Returns a wrapper for this instance that implements {@link ICesiumInterpolatableValuePropertyWriter} to write a value in {@code Number} format.  Because the returned instance is a wrapper for this instance, you may call {@link ICesiumElementWriter#close} on either this instance or the wrapper, but you must not call it on both.
    
    

    * @return The wrapper.
    */
    public final ICesiumInterpolatableValuePropertyWriter<Double> asNumber() {
        return m_asNumber.getValue();
    }

    private final ICesiumInterpolatableValuePropertyWriter<Double> createNumberAdaptor() {
        return new CesiumInterpolatableWriterAdaptor<cesiumlanguagewriter.DoubleCesiumWriter, Double>(this, new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DoubleCesiumWriter, Double>() {
            public void invoke(DoubleCesiumWriter me, Double value) {
                me.writeNumber(value);
            }
        }, new CesiumWriterAdaptorWriteSamplesCallback<cesiumlanguagewriter.DoubleCesiumWriter, Double>() {
            public void invoke(DoubleCesiumWriter me, List<JulianDate> dates, List<Double> values, int startIndex, int length) {
                me.writeNumber(dates, values, startIndex, length);
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
        return new CesiumWriterAdaptor<cesiumlanguagewriter.DoubleCesiumWriter, cesiumlanguagewriter.Reference>(this,
                new CesiumWriterAdaptorWriteCallback<cesiumlanguagewriter.DoubleCesiumWriter, cesiumlanguagewriter.Reference>() {
                    public void invoke(DoubleCesiumWriter me, Reference value) {
                        me.writeReference(value);
                    }
                });
    }
}