package cesiumlanguagewriter.advanced;


import agi.foundation.compatibility.*;
import agi.foundation.compatibility.ArgumentException;
import agi.foundation.compatibility.ArgumentNullException;
import agi.foundation.compatibility.ConvertHelper;
import agi.foundation.compatibility.DisposeHelper;
import agi.foundation.compatibility.HttpWebRequest;
import agi.foundation.compatibility.ImageFormat;
import agi.foundation.compatibility.ImageHelper;
import agi.foundation.compatibility.MemoryStream;
import agi.foundation.compatibility.StreamHelper;
import agi.foundation.compatibility.StringHelper;
import agi.foundation.compatibility.WebRequest;
import agi.foundation.compatibility.WebResponse;
import cesiumlanguagewriter.*;
import java.awt.image.RenderedImage;
import java.io.InputStream;
import javax.annotation.Nonnull;

/**
 *  
 Contains static methods for formatting data for writing to a CZML stream.
 

 */
@SuppressWarnings("unused")
public final class CesiumFormattingHelper {
    private CesiumFormattingHelper() {}

    private static JulianDate s_minimumDate = GregorianDate.MinValue.toJulianDate();
    private static JulianDate s_maximumDate = GregorianDate.MaxValue.toJulianDate();

    /**
    *  
    Converts a {@link TimeInterval} as an ISO8601 interval string.
    
    
    
    
    

    * @param start The start of the interval.
    * @param stop The end of the interval.
    * @param format The format to use.
    * @return The interval represented as an ISO8601 interval string.
    */
    @Nonnull
    public static String toIso8601Interval(JulianDate start, JulianDate stop, Iso8601Format format) {
        return toIso8601(start, format) + "/" + toIso8601(stop, format);
    }

    /**
    *  
    Converts a {@link TimeInterval} as an ISO8601 interval string.
    
    
    
    

    * @param interval The interval to convert.
    * @param format The format to use.
    * @return The interval represented as an ISO8601 interval string.
    */
    @Nonnull
    public static String toIso8601Interval(@Nonnull TimeInterval interval, Iso8601Format format) {
        if (interval == null) {
            throw new ArgumentNullException("interval");
        }
        return toIso8601Interval(interval.getStart(), interval.getStop(), format);
    }

    /**
    *  
    Converts a {@link JulianDate} to an ISO8601 date string.
    
    
    
    

    * @param date The date to convert.
    * @param format The format to use.
    * @return The date represented as an ISO8601 date string.
    */
    @Nonnull
    public static String toIso8601(JulianDate date, Iso8601Format format) {
        //If the JulianDate is outside the range of supported CZML values,
        //clamp it to the minimum/maximum CZML ISO8601 value.
        if (JulianDate.lessThanOrEqual(date, s_minimumDate)) {
            return GregorianDate.MinValue.toIso8601String(format);
        }
        if (JulianDate.greaterThanOrEqual(date, s_maximumDate)) {
            return GregorianDate.MaxValue.toIso8601String(format);
        }
        return date.toGregorianDate().toIso8601String(format);
    }

    /**
    *  
    Downloads and converts a remote resource URI into a data URI in the form
    {@code data:<MimeType>;base64,<ImageData>}, where
    {@code <MimeType>} is the MIME type of the specified resource, and
    {@code <ImageData>} is the data encoded as a Base 64 string.
    
    
    

    * @param uri The URI of the resource to convert.
    * @return A data URI containing the content of the resource.
    */
    @Nonnull
    public static String downloadUriIntoDataUri(@Nonnull String uri) {
        if (uri == null) {
            throw new ArgumentNullException("uri");
        }
        if (StringHelper.startsWith(uri, "data:")) {
            return uri;
        }
        WebRequest webRequest = WebRequest.create(uri);
        HttpWebRequest httpWebRequest = (webRequest instanceof HttpWebRequest) ? (HttpWebRequest) webRequest : null;
        if (httpWebRequest != null) {
            httpWebRequest.setUserAgent("CesiumWriter");
        }
        {
            WebResponse webResponse = webRequest.getResponse();
            try {
                {
                    InputStream stream = webResponse.getResponseStream();
                    try {
                        if (stream == null) {
                            throw new IllegalStateException(CesiumLocalization.getDataDownloadFailed());
                        }
                        String mimeType = webResponse.getContentType();
                        return streamToDataUri(stream, mimeType);
                    } finally {
                        DisposeHelper.dispose(stream);
                    }
                }
            } finally {
                DisposeHelper.dispose(webResponse);
            }
        }
    }

    /**
    *  
    Reads from a stream containing an image into a data URI in the form
    {@code data:<MimeType>;base64,<ImageData>}, where
    {@code <MimeType>} is the MIME type of the specified image format, and
    {@code <ImageData>} is the image data encoded as a Base 64 string.
    This method does not attempt to decode the image data, but simply writes it directly to the data URI.
    
    
    
    

    * @param stream The stream containing the image to encode into a data URI.
    * @param imageFormat The format of the image, which controls the mime type.
    * @return A data URI containing the content of the image.
    */
    @Nonnull
    public static String imageToDataUri(@Nonnull InputStream stream, CesiumImageFormat imageFormat) {
        String mimeType = getMimeTypeFromCesiumImageFormat(imageFormat);
        return streamToDataUri(stream, mimeType);
    }

    /**
    *  
    Converts an image to a data URI in the form
    {@code data:<MimeType>;base64,<ImageData>}, where
    {@code <MimeType>} is the MIME type of the specified {@code image}, and
    {@code <ImageData>} is the image data encoded as a Base 64 string.
    
    
    
    

    * @param image The image to convert.
    * @param imageFormat The format of the image, which controls the mime type.
    * @return A data URI containing the content of the image.
    */
    @Nonnull
    public static String imageToDataUri(@Nonnull RenderedImage image, CesiumImageFormat imageFormat) {
        String mimeType = getMimeTypeFromCesiumImageFormat(imageFormat);
        {
            MemoryStream stream = new MemoryStream();
            try {
                ImageHelper.save(image, stream, cesiumImageFormatToImageFormat(imageFormat));
                stream.setPosition(0L);
                return streamToDataUri(stream, mimeType);
            } finally {
                DisposeHelper.dispose(stream);
            }
        }
    }

    @Nonnull
    private static ImageFormat cesiumImageFormatToImageFormat(CesiumImageFormat imageFormat) {
        switch (imageFormat) {
        case JPEG: {
            return ImageFormat.getJpeg();
        }
        case PNG: {
            return ImageFormat.getPng();
        }
        case BMP: {
            return ImageFormat.getBmp();
        }
        case GIF: {
            return ImageFormat.getGif();
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getArgumentTypeInvalid(), "imageFormat");
        }
        }
    }

    /**
    *  
    Reads data from a stream into a data URI in the form
    {@code data:<MimeType>;base64,<ImageData>}, where
    {@code <MimeType>} is the given MIME type, and
    {@code <ImageData>} is the image data encoded as a Base 64 string.
    
    
    
    

    * @param stream The stream to read from.
    * @param mimeType The mime type of the data in the stream.
    * @return A data URI containing the contents of the stream.
    */
    @Nonnull
    public static String streamToDataUri(@Nonnull InputStream stream, @Nonnull String mimeType) {
        if (stream == null) {
            throw new ArgumentNullException("stream");
        }
        if (mimeType == null) {
            throw new ArgumentNullException("mimeType");
        }
        StringBuilder builder = new StringBuilder();
        builder.append("data:");
        builder.append(mimeType);
        builder.append(";base64,");
        {
            MemoryStream memoryStream = new MemoryStream();
            try {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = StreamHelper.read(stream, buffer, 0, buffer.length)) > 0)
                    memoryStream.write(buffer, 0, bytesRead);
                builder.append(ConvertHelper.toBase64String(memoryStream.getBuffer(), 0, (int) memoryStream.getLength()));
            } finally {
                DisposeHelper.dispose(memoryStream);
            }
        }
        return builder.toString();
    }

    @Nonnull
    private static String getMimeTypeFromCesiumImageFormat(CesiumImageFormat imageFormat) {
        switch (imageFormat) {
        case JPEG: {
            return "image/jpeg";
        }
        case PNG: {
            return "image/png";
        }
        case BMP: {
            return "image/bmp";
        }
        case GIF: {
            return "image/gif";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getArgumentTypeInvalid(), "imageFormat");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumStripeOrientation} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String stripeOrientationToString(CesiumStripeOrientation value) {
        switch (value) {
        case HORIZONTAL: {
            return "HORIZONTAL";
        }
        case VERTICAL: {
            return "VERTICAL";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumHorizontalOrigin} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String horizontalOriginToString(CesiumHorizontalOrigin value) {
        switch (value) {
        case LEFT: {
            return "LEFT";
        }
        case CENTER: {
            return "CENTER";
        }
        case RIGHT: {
            return "RIGHT";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumVerticalOrigin} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String verticalOriginToString(CesiumVerticalOrigin value) {
        switch (value) {
        case BOTTOM: {
            return "BOTTOM";
        }
        case CENTER: {
            return "CENTER";
        }
        case TOP: {
            return "TOP";
        }
        case BASELINE: {
            return "BASELINE";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumHeightReference} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String heightReferenceToString(CesiumHeightReference value) {
        switch (value) {
        case NONE: {
            return "NONE";
        }
        case CLAMP_TO_GROUND: {
            return "CLAMP_TO_GROUND";
        }
        case RELATIVE_TO_GROUND: {
            return "RELATIVE_TO_GROUND";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumShadowMode} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String shadowModeToString(CesiumShadowMode value) {
        switch (value) {
        case DISABLED: {
            return "DISABLED";
        }
        case ENABLED: {
            return "ENABLED";
        }
        case CAST_ONLY: {
            return "CAST_ONLY";
        }
        case RECEIVE_ONLY: {
            return "RECEIVE_ONLY";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumInterpolationAlgorithm} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String interpolationAlgorithmToString(CesiumInterpolationAlgorithm value) {
        switch (value) {
        case LINEAR: {
            return "LINEAR";
        }
        case LAGRANGE: {
            return "LAGRANGE";
        }
        case HERMITE: {
            return "HERMITE";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumExtrapolationType} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String extrapolationTypeToString(CesiumExtrapolationType value) {
        switch (value) {
        case NONE: {
            return "NONE";
        }
        case HOLD: {
            return "HOLD";
        }
        case EXTRAPOLATE: {
            return "EXTRAPOLATE";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link ClockRange} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String clockRangeToString(ClockRange value) {
        switch (value) {
        case CLAMPED: {
            return "CLAMPED";
        }
        case UNBOUNDED: {
            return "UNBOUNDED";
        }
        case LOOP_STOP: {
            return "LOOP_STOP";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link ClockStep} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String clockStepToString(ClockStep value) {
        switch (value) {
        case SYSTEM_CLOCK: {
            return "SYSTEM_CLOCK";
        }
        case SYSTEM_CLOCK_MULTIPLIER: {
            return "SYSTEM_CLOCK_MULTIPLIER";
        }
        case TICK_DEPENDENT: {
            return "TICK_DEPENDENT";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumLabelStyle} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String labelStyleToString(CesiumLabelStyle value) {
        switch (value) {
        case FILL: {
            return "FILL";
        }
        case OUTLINE: {
            return "OUTLINE";
        }
        case FILL_AND_OUTLINE: {
            return "FILL_AND_OUTLINE";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumCornerType} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String cornerTypeToString(CesiumCornerType value) {
        switch (value) {
        case ROUNDED: {
            return "ROUNDED";
        }
        case MITERED: {
            return "MITERED";
        }
        case BEVELED: {
            return "BEVELED";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumColorBlendMode} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String colorBlendModeToString(CesiumColorBlendMode value) {
        switch (value) {
        case HIGHLIGHT: {
            return "HIGHLIGHT";
        }
        case REPLACE: {
            return "REPLACE";
        }
        case MIX: {
            return "MIX";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Converts a {@link CesiumSensorVolumePortionToDisplay} to the corresponding string in a CZML stream.
    
    
    

    * @param value The value to convert.
    * @return The string representing the specified value.
    */
    @Nonnull
    public static String sensorVolumePortionToDisplayToString(CesiumSensorVolumePortionToDisplay value) {
        switch (value) {
        case COMPLETE: {
            return "COMPLETE";
        }
        case ABOVE_ELLIPSOID_HORIZON: {
            return "ABOVE_ELLIPSOID_HORIZON";
        }
        case BELOW_ELLIPSOID_HORIZON: {
            return "BELOW_ELLIPSOID_HORIZON";
        }
        default: {
            throw new ArgumentException(CesiumLocalization.getUnknownEnumerationValue(), "value");
        }
        }
    }

    /**
    *  
    Returns a resolved url, using the given {@link CesiumResourceBehavior}.
    
    
    
    

    * @param uri The url of the resource.
    * @param resourceBehavior A {@link CesiumResourceBehavior} specifying how include the resource into a CZML document.
    * @return The resolved url.
    */
    @Nonnull
    public static String getResourceUri(@Nonnull String uri, CesiumResourceBehavior resourceBehavior) {
        if (uri == null) {
            throw new ArgumentNullException("uri");
        }
        if (resourceBehavior == CesiumResourceBehavior.EMBED) {
            return CachingCesiumUriResolver.getThreadLocalInstance().resolveUri(uri);
        }
        return uri;
    }
}