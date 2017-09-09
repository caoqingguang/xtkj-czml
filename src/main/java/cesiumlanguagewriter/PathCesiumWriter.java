package cesiumlanguagewriter;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.Func1;
import agi.foundation.compatibility.Lazy;
import cesiumlanguagewriter.advanced.*;
import cesiumlanguagewriter.BooleanCesiumWriter;
import cesiumlanguagewriter.DoubleCesiumWriter;
import cesiumlanguagewriter.PolylineMaterialCesiumWriter;
import java.util.List;

/**
 *  
 Writes a {@code Path} to a {@link CesiumOutputStream}.  A {@code Path} is a path, which is a polyline defined by the motion of an object over time.  The possible vertices of the path are specified by the {@code position} property.
 

 */
@SuppressWarnings("unused")
public class PathCesiumWriter extends CesiumPropertyWriter<PathCesiumWriter> {
    /**
    *  
    The name of the {@code show} property.
    

    */
    public static final String ShowPropertyName = "show";
    /**
    *  
    The name of the {@code width} property.
    

    */
    public static final String WidthPropertyName = "width";
    /**
    *  
    The name of the {@code resolution} property.
    

    */
    public static final String ResolutionPropertyName = "resolution";
    /**
    *  
    The name of the {@code leadTime} property.
    

    */
    public static final String LeadTimePropertyName = "leadTime";
    /**
    *  
    The name of the {@code trailTime} property.
    

    */
    public static final String TrailTimePropertyName = "trailTime";
    /**
    *  
    The name of the {@code material} property.
    

    */
    public static final String MaterialPropertyName = "material";
    private Lazy<BooleanCesiumWriter> m_show = new Lazy<cesiumlanguagewriter.BooleanCesiumWriter>(new Func1<cesiumlanguagewriter.BooleanCesiumWriter>() {
        public cesiumlanguagewriter.BooleanCesiumWriter invoke() {
            return new BooleanCesiumWriter(ShowPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_width = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(WidthPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_resolution = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(ResolutionPropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_leadTime = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(LeadTimePropertyName);
        }
    }, false);
    private Lazy<DoubleCesiumWriter> m_trailTime = new Lazy<cesiumlanguagewriter.DoubleCesiumWriter>(new Func1<cesiumlanguagewriter.DoubleCesiumWriter>() {
        public cesiumlanguagewriter.DoubleCesiumWriter invoke() {
            return new DoubleCesiumWriter(TrailTimePropertyName);
        }
    }, false);
    private Lazy<PolylineMaterialCesiumWriter> m_material = new Lazy<cesiumlanguagewriter.PolylineMaterialCesiumWriter>(new Func1<cesiumlanguagewriter.PolylineMaterialCesiumWriter>() {
        public cesiumlanguagewriter.PolylineMaterialCesiumWriter invoke() {
            return new PolylineMaterialCesiumWriter(MaterialPropertyName);
        }
    }, false);

    /**
    *  
    Initializes a new instance.
    

    */
    public PathCesiumWriter(String propertyName) {
        super(propertyName);
    }

    /**
    *  
    Initializes a new instance as a copy of an existing instance.
    
    

    * @param existingInstance The existing instance to copy.
    */
    protected PathCesiumWriter(PathCesiumWriter existingInstance) {
        super(existingInstance);
    }

    @Override
    public PathCesiumWriter clone() {
        return new PathCesiumWriter(this);
    }

    /**
    *  Gets the writer for the {@code show} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code show} property defines whether or not the path is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter getShowWriter() {
        return m_show.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code show} property.  The {@code show} property defines whether or not the path is shown.  If not specified, the default value is {@code true}.
    

    */
    public final BooleanCesiumWriter openShowProperty() {
        openIntervalIfNecessary();
        return this.<BooleanCesiumWriter> openAndReturn(getShowWriter());
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code boolean} value.  The {@code show} property specifies whether or not the path is shown.  If not specified, the default value is {@code true}.
    
    

    * @param value The value.
    */
    public final void writeShowProperty(boolean value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeBoolean(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the path is shown.  If not specified, the default value is {@code true}.
    
    

    * @param value The reference.
    */
    public final void writeShowPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the path is shown.  If not specified, the default value is {@code true}.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeShowPropertyReference(String value) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the path is shown.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code show} property as a {@code reference} value.  The {@code show} property specifies whether or not the path is shown.  If not specified, the default value is {@code true}.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeShowPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.BooleanCesiumWriter writer = openShowProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code width} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code width} property defines the width of the path line.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter getWidthWriter() {
        return m_width.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code width} property.  The {@code width} property defines the width of the path line.  If not specified, the default value is 1.0.
    

    */
    public final DoubleCesiumWriter openWidthProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getWidthWriter());
    }

    /**
    *  
    Writes a value for the {@code width} property as a {@code number} value.  The {@code width} property specifies the width of the path line.  If not specified, the default value is 1.0.
    
    

    * @param value The value.
    */
    public final void writeWidthProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code width} property as a {@code number} value.  The {@code width} property specifies the width of the path line.  If not specified, the default value is 1.0.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeWidthProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code width} property as a {@code number} value.  The {@code width} property specifies the width of the path line.  If not specified, the default value is 1.0.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeWidthProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code width} property as a {@code reference} value.  The {@code width} property specifies the width of the path line.  If not specified, the default value is 1.0.
    
    

    * @param value The reference.
    */
    public final void writeWidthPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code width} property as a {@code reference} value.  The {@code width} property specifies the width of the path line.  If not specified, the default value is 1.0.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeWidthPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code width} property as a {@code reference} value.  The {@code width} property specifies the width of the path line.  If not specified, the default value is 1.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeWidthPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code width} property as a {@code reference} value.  The {@code width} property specifies the width of the path line.  If not specified, the default value is 1.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeWidthPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openWidthProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code resolution} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code resolution} property defines the maximum step-size, in seconds, used to sample the path.  If the {@code position} property has data points farther apart than resolution specifies, additional steps will be taken, creating a smoother path.  If not specified, the default value is 60.0.
    

    */
    public final DoubleCesiumWriter getResolutionWriter() {
        return m_resolution.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code resolution} property.  The {@code resolution} property defines the maximum step-size, in seconds, used to sample the path.  If the {@code position} property has data points farther apart than resolution specifies, additional steps will be taken, creating a smoother path.  If not specified, the default value is 60.0.
    

    */
    public final DoubleCesiumWriter openResolutionProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getResolutionWriter());
    }

    /**
    *  
    Writes a value for the {@code resolution} property as a {@code number} value.  The {@code resolution} property specifies the maximum step-size, in seconds, used to sample the path.  If the {@code position} property has data points farther apart than resolution specifies, additional steps will be taken, creating a smoother path.  If not specified, the default value is 60.0.
    
    

    * @param value The value.
    */
    public final void writeResolutionProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code resolution} property as a {@code number} value.  The {@code resolution} property specifies the maximum step-size, in seconds, used to sample the path.  If the {@code position} property has data points farther apart than resolution specifies, additional steps will be taken, creating a smoother path.  If not specified, the default value is 60.0.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeResolutionProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code resolution} property as a {@code number} value.  The {@code resolution} property specifies the maximum step-size, in seconds, used to sample the path.  If the {@code position} property has data points farther apart than resolution specifies, additional steps will be taken, creating a smoother path.  If not specified, the default value is 60.0.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeResolutionProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code resolution} property as a {@code reference} value.  The {@code resolution} property specifies the maximum step-size, in seconds, used to sample the path.  If the {@code position} property has data points farther apart than resolution specifies, additional steps will be taken, creating a smoother path.  If not specified, the default value is 60.0.
    
    

    * @param value The reference.
    */
    public final void writeResolutionPropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code resolution} property as a {@code reference} value.  The {@code resolution} property specifies the maximum step-size, in seconds, used to sample the path.  If the {@code position} property has data points farther apart than resolution specifies, additional steps will be taken, creating a smoother path.  If not specified, the default value is 60.0.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeResolutionPropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code resolution} property as a {@code reference} value.  The {@code resolution} property specifies the maximum step-size, in seconds, used to sample the path.  If the {@code position} property has data points farther apart than resolution specifies, additional steps will be taken, creating a smoother path.  If not specified, the default value is 60.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeResolutionPropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code resolution} property as a {@code reference} value.  The {@code resolution} property specifies the maximum step-size, in seconds, used to sample the path.  If the {@code position} property has data points farther apart than resolution specifies, additional steps will be taken, creating a smoother path.  If not specified, the default value is 60.0.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeResolutionPropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openResolutionProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code leadTime} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code leadTime} property defines the time ahead of the animation time, in seconds, to show the path.
    

    */
    public final DoubleCesiumWriter getLeadTimeWriter() {
        return m_leadTime.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code leadTime} property.  The {@code leadTime} property defines the time ahead of the animation time, in seconds, to show the path.
    

    */
    public final DoubleCesiumWriter openLeadTimeProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getLeadTimeWriter());
    }

    /**
    *  
    Writes a value for the {@code leadTime} property as a {@code number} value.  The {@code leadTime} property specifies the time ahead of the animation time, in seconds, to show the path.
    
    

    * @param value The value.
    */
    public final void writeLeadTimeProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code leadTime} property as a {@code number} value.  The {@code leadTime} property specifies the time ahead of the animation time, in seconds, to show the path.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeLeadTimeProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code leadTime} property as a {@code number} value.  The {@code leadTime} property specifies the time ahead of the animation time, in seconds, to show the path.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeLeadTimeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code leadTime} property as a {@code reference} value.  The {@code leadTime} property specifies the time ahead of the animation time, in seconds, to show the path.
    
    

    * @param value The reference.
    */
    public final void writeLeadTimePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code leadTime} property as a {@code reference} value.  The {@code leadTime} property specifies the time ahead of the animation time, in seconds, to show the path.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeLeadTimePropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code leadTime} property as a {@code reference} value.  The {@code leadTime} property specifies the time ahead of the animation time, in seconds, to show the path.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeLeadTimePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code leadTime} property as a {@code reference} value.  The {@code leadTime} property specifies the time ahead of the animation time, in seconds, to show the path.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeLeadTimePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openLeadTimeProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code trailTime} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code trailTime} property defines the time behind the animation time, in seconds, to show the path.
    

    */
    public final DoubleCesiumWriter getTrailTimeWriter() {
        return m_trailTime.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code trailTime} property.  The {@code trailTime} property defines the time behind the animation time, in seconds, to show the path.
    

    */
    public final DoubleCesiumWriter openTrailTimeProperty() {
        openIntervalIfNecessary();
        return this.<DoubleCesiumWriter> openAndReturn(getTrailTimeWriter());
    }

    /**
    *  
    Writes a value for the {@code trailTime} property as a {@code number} value.  The {@code trailTime} property specifies the time behind the animation time, in seconds, to show the path.
    
    

    * @param value The value.
    */
    public final void writeTrailTimeProperty(double value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
            try {
                writer.writeNumber(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code trailTime} property as a {@code number} value.  The {@code trailTime} property specifies the time behind the animation time, in seconds, to show the path.
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The values corresponding to each date.
    */
    public final void writeTrailTimeProperty(List<JulianDate> dates, List<Double> values) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
            try {
                writer.writeNumber(dates, values);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code trailTime} property as a {@code number} value.  The {@code trailTime} property specifies the time behind the animation time, in seconds, to show the path.
    
    
    
    
    

    * @param dates The dates at which the value is specified.
    * @param values The value corresponding to each date.
    * @param startIndex The index of the first element to write.
    * @param length The number of elements to write.
    */
    public final void writeTrailTimeProperty(List<JulianDate> dates, List<Double> values, int startIndex, int length) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
            try {
                writer.writeNumber(dates, values, startIndex, length);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code trailTime} property as a {@code reference} value.  The {@code trailTime} property specifies the time behind the animation time, in seconds, to show the path.
    
    

    * @param value The reference.
    */
    public final void writeTrailTimePropertyReference(Reference value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code trailTime} property as a {@code reference} value.  The {@code trailTime} property specifies the time behind the animation time, in seconds, to show the path.
    
    

    * @param value The earliest date of the interval.
    */
    public final void writeTrailTimePropertyReference(String value) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
            try {
                writer.writeReference(value);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code trailTime} property as a {@code reference} value.  The {@code trailTime} property specifies the time behind the animation time, in seconds, to show the path.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyName The property on the referenced object.
    */
    public final void writeTrailTimePropertyReference(String identifier, String propertyName) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
            try {
                writer.writeReference(identifier, propertyName);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  
    Writes a value for the {@code trailTime} property as a {@code reference} value.  The {@code trailTime} property specifies the time behind the animation time, in seconds, to show the path.
    
    
    

    * @param identifier The identifier of the object which contains the referenced property.
    * @param propertyNames The hierarchy of properties to be indexed on the referenced object.
    */
    public final void writeTrailTimePropertyReference(String identifier, String[] propertyNames) {
        {
            cesiumlanguagewriter.DoubleCesiumWriter writer = openTrailTimeProperty();
            try {
                writer.writeReference(identifier, propertyNames);
            } finally {
                DisposeHelper.dispose(writer);
            }
        }
    }

    /**
    *  Gets the writer for the {@code material} property.  The returned instance must be opened by calling the {@link CesiumElementWriter#open} method before it can be used for writing.  The {@code material} property defines the material to use to draw the path.
    

    */
    public final PolylineMaterialCesiumWriter getMaterialWriter() {
        return m_material.getValue();
    }

    /**
    *  
    Opens and returns the writer for the {@code material} property.  The {@code material} property defines the material to use to draw the path.
    

    */
    public final PolylineMaterialCesiumWriter openMaterialProperty() {
        openIntervalIfNecessary();
        return this.<PolylineMaterialCesiumWriter> openAndReturn(getMaterialWriter());
    }
}