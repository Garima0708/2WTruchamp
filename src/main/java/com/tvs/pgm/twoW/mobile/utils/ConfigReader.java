package com.tvs.pgm.twoW.mobile.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {

    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    private static final Properties properties = new Properties();
    private static final String DEFAULT_CONFIG_FILE = "configReader.properties";

    static {
        loadProperties(DEFAULT_CONFIG_FILE);
    }

    /**
     * Loads the properties from the given file in the classpath
     */
    private static void loadProperties(String fileName) {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new IOException("❌ Unable to find '" + fileName + "' in resources.");
            }
            properties.load(input);
            logger.info("✅ Loaded configuration from '{}'", fileName);
        } catch (IOException ex) {
            logger.error("❌ Failed to load properties file '{}'", fileName, ex);
        }
    }

    /**
     * Get a property value by key
     */
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.warn("⚠️ Property '{}' not found in config.", key);
        }
        return value;
    }

    /**
     * Get a property value with a fallback default
     */
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    /**
     * Optional: Reloads default config file
     */
    public static void reloadProperties() {
        properties.clear();
        loadProperties(DEFAULT_CONFIG_FILE);
        logger.info("🔁 Properties reloaded from '{}'", DEFAULT_CONFIG_FILE);
    }

    /**
     * Optional: Load a different config file, e.g., config-qa.properties
     */
    public static void loadCustomConfig(String customFileName) {
        properties.clear();
        loadProperties(customFileName);
    }

    /**
     * Utility: Get platform (android/ios)
     */
    public static String getPlatform() {
        return getProperty("platform", "android").toLowerCase();
    }

    /**
     * Utility: Is Android test
     */
    public static boolean isAndroid() {
        return Objects.equals(getPlatform(), "android");
    }

    /**
     * Utility: Is iOS test
     */
    public static boolean isIOS() {
        return Objects.equals(getPlatform(), "ios");
    }
}
