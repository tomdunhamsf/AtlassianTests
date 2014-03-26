package mapencoder;

import java.util.Map;

public interface MapEncoder
{
    /**
     * Decodes the given Map into a String. In the resulting String, keys and values are separated by "=", and pairs are
     * separated by "&", i.e. key=value&key=value&...
     * The order of the map entries in the String is not important. Empty keys and values are allowed.
     *
     * @param map   the Map to encode
     * @return      a String representing the given Map. If the given Map is empty, an empty String is returned. If the
     *              given Map is null, null is returned.
     * @throws IllegalArgumentException if a key or value will result in a malformed String, i.e. if it contains "=" or "&"
     */
    public String encode(Map<String, String> map);
}
