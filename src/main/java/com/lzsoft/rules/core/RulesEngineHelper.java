package com.lzsoft.rules.core;

import java.io.IOException;
import java.io.InputStream;
public class RulesEngineHelper {

	public static RulesEngine getRulesEngine(String path) throws IOException {

		InputStream is =RulesEngineHelper.class.getClassLoader().getResourceAsStream(path);
		return new RulesEngine(is);

	}

}
