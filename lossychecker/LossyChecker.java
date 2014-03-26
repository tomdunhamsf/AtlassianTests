package lossychecker;

import java.io.UnsupportedEncodingException;

public interface LossyChecker
{
    /**
     * Checks if the given encoding will result in a 'lossy' operation, i.e. if any characters in the given String are
     * not in the given encoding.
     *
     * @param s the String
     * @param encoding the encoding
     * @return true if the encoding will not result in a lossy operation, false if otherwise
     * @throws UnsupportedEncodingException if the given encoding is not supported
     */
    public boolean isLossy(String s, String encoding) throws UnsupportedEncodingException;
}
