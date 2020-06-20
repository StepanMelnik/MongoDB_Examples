package com.sme.mongodb.common;

/**
 * Provides common constants.
 */
public final class Constants
{
    private static final String INNER_VERSION = "0.0.0.Dev-SNAPSHOT";

    public static final long serialVersionUID = getSerialVersionUID(INNER_VERSION);

    /**
     * Get a serial version.
     * 
     * @return a valid serial version UID from given version.
     */
    static long getSerialVersionUID(String version)
    {
        if (version == null || version.isEmpty())
        {
            return 0;
        }
        else if ("0.0.0.Dev-SNAPSHOT".equals(version))
        {
            return 1;
        }
        else if ("0.0.0.Stable-SNAPSHOT".equals(version))
        {
            return 2;
        }
        else
        {
            return 0;
        }
    }

    // private
    private Constants()
    {
    }
}
