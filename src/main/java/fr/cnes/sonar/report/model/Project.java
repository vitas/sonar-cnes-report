package fr.cnes.sonar.report.model;

import java.util.*;

/**
 * Represents a project
 * @author begarco
 */
public class Project {
    /**
     * Key used by sonarqube
     */
    private String key;
    /**
     * Name of the project
     */
    private String name;
    /**
     * Version of the project
     */
    private String version;
    /**
     * Description of the project
     */
    private String description;
    /**
     * Quality profiles linked to the project
     */
    private ProfileMetaData[] qualityProfiles;
    /**
     * Languages of the project
     */
    private Map<String, Language> languages;

    /**
     * Constructor to set basics
     * @param key SonarQube key
     * @param name Name of the project
     * @param version Version given by the user
     * @param description Project's description
     */
    public Project(String key, String name, String version, String description) {
        this.key = key;
        this.name = name;
        this.version = version;
        this.description = description;
        this.qualityProfiles = new ProfileMetaData[0];
        this.languages = new HashMap<>();
    }

    /**
     * Getter for key
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Setter for name
     * @param key name
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     * @param name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getVersion() {
        return version;
    }

    /**
     * Setter for version
     * @param version value
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     * @param description value
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get meta data about linked quality profiles
     * @return an array of quality profiles
     */
    public ProfileMetaData[] getQualityProfiles() {
        return qualityProfiles.clone();
    }

    /**
     * Set the value of quality profiles by making a copy
     * @param qualityProfiles value to set
     */
    public void setQualityProfiles(ProfileMetaData[] qualityProfiles) {
        this.qualityProfiles = qualityProfiles.clone();
    }

    /**
     * Find a Language by key
     * @param languageKey Key of the language to get
     * @return A Language object
     */
    public Language getLanguage(String languageKey) {
        return this.languages.get(languageKey);
    }

    /**
     * Return all languages as a list
     * @return list of languages
     */
    public List<Language> getLanguages() {
        return new ArrayList<>(languages.values());
    }

    /**
     * Set the languages' values
     * @param languages map to set
     */
    public void setLanguages(Map<String, Language> languages) {
        this.languages = new HashMap<>(languages);
    }
}
