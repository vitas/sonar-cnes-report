package fr.cnes.sonar.report.input;

import fr.cnes.sonar.report.exceptions.MissingParameterException;
import fr.cnes.sonar.report.exceptions.UnknownParameterException;

import java.util.HashMap;

/**
 * Parameters of the command
 * @author lequal
 */
public class Params {
    /**
     * Map of all parameters
     */
    private HashMap<String,String> paramsMap;

    /**
     * Default constructor
     */
    public Params() {
        paramsMap = new HashMap<>();
    }

    /**
     * @param key Key of the parameter to check
     * @return true if a parameter exists
     */
    public boolean contains(String key) {
        return this.paramsMap.containsKey(key);
    }

    /**
     * @param key key of the parameter to find
     * @return The parameter value if it exists
     * @throws UnknownParameterException when a parameter does not exist
     */
    public String get(String key) throws UnknownParameterException {
        if(!contains(key)) {
            throw new UnknownParameterException(key);
        }
        return paramsMap.get(key);
    }

    /**
     * Add a parameter to the list
     * @param key the key of the parameter
     * @param value the value of the parameter
     */
    public void put(String key, String value) {
        this.paramsMap.put(key, value);
    }

    /**
     * Check if is itself correct
     * @return yes if the paramsMap are correct
     * @throws MissingParameterException when a parameter is not given
     */
    public boolean isReliable() throws MissingParameterException {
        // review all pairs
        for(HashMap.Entry<String, String> entry : paramsMap.entrySet()) {
            // get current key
            String key = entry.getKey();
            // get current value
            String value = entry.getValue();

            // check if one of them contains an empty string
            if("".equals(value)) {
                throw new MissingParameterException(key);
            }
        }
        // if all is ok always return true
        return true;
    }
}
