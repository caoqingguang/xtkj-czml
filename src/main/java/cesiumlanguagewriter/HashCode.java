package cesiumlanguagewriter;


import agi.foundation.compatibility.*;

/**
 *  
 Helper class to combine hashcodes.
 

 */
@SuppressWarnings("unused")
public final class HashCode {
    private HashCode() {}

    /**
    *  
    Combine hashcodes into a single hashcode.
    
    
    

    * @param hashcodes The hashcodes to combine.
    * @return A single overall hashcode.
    */
    public static int combine(int... hashcodes) {
        int hash = 17;
        for (final int hashcode : hashcodes) {
            hash = hash * 31 + hashcode;
        }
        return hash;
    }
}