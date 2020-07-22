package net.coolblossom.lycee.app.web.utils;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public final class SystemProperties {
	private static final String SYSTEM_PROPERTIES_FILEPATH = "resources/system.properties";

	private static Properties systemProperties = null;


	private static synchronized Properties _0load() throws IOException {
		if (systemProperties == null) {
			systemProperties = new Properties();
			try(Reader reader = Files.newBufferedReader(Paths.get(SYSTEM_PROPERTIES_FILEPATH), StandardCharsets.UTF_8)) {
				systemProperties.load(reader);
			}catch (IOException e) {

			}
		}
		return systemProperties;
	}


	public static String get(String key) throws IOException {
		return _0load().getProperty(key);
	}

	public static String getOrDefault(String key, String defaultValue) throws IOException {
		return (String) _0load().getOrDefault(key, defaultValue);
	}

}
