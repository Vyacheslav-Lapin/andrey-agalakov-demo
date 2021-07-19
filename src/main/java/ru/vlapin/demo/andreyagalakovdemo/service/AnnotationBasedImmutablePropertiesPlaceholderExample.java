package ru.vlapin.demo.andreyagalakovdemo.service;

import javax.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * Limitations:
 * - no defaults (!!!)
 * - {@code @lombok.RequiredArgsConstructor} generate constructor AFTER spring-configuration-metadata.json,
 *   so, for correct auto-complete *.properties (and *.yaml) for this bean in IDEA, you have to Delombok
 *   {@code @RequiredArgsConstructor} before compile...
 */
@Getter
@ConstructorBinding
//@RequiredArgsConstructor
@ConfigurationProperties("mail.credentials")
public final class AnnotationBasedImmutablePropertiesPlaceholderExample {

  /**
   * Auth method
   */
  String authMethod;

  /**
   * login
   */
  String username;

  /**
   * pwd
   */
  String password;

  public AnnotationBasedImmutablePropertiesPlaceholderExample(String authMethod, String username, String password) {
    this.authMethod = authMethod;
    this.username = username;
    this.password = password;
  }

  @PostConstruct
  private void init() {

  }

  @EventListener
  public void afterContextInitialization(ContextRefreshedEvent __) {

  }

}
