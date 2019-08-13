package com.edison.restful.entity;

public enum ContentType {
  X_WWW_FORM_URLENCODED("x-www-form-urlencoded"),

  RAW("raw");

  private String alias;

  ContentType(String alias) {
    this.alias = alias;
  }

  public String getAlias() {
    return alias;
  }
}
