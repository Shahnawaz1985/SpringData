package com.bac.data.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
/**
 * 
 * @author Qais
 *
 */
public class MySqlPropertyCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment env = context.getEnvironment();
		return env.containsProperty("mysql_jdbc.driverClassName");
	}

}
