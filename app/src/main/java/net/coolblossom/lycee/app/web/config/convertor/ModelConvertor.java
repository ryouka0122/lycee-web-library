package net.coolblossom.lycee.app.web.config.convertor;

import java.util.Arrays;

import org.springframework.core.convert.converter.Converter;

import net.coolblossom.lycee.app.web.enums.ModelManager;

public class ModelConvertor implements Converter<String, ModelManager> {

	@Override
	public ModelManager convert(String source) {
		ModelManager manager = Arrays.stream(ModelManager.values())
				.filter(e -> e.match(source))
				.findFirst()
				.orElse(null);
		return manager;
	}

}
