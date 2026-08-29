package CssSymbolTable;

import java.util.*;

public class CssSymbolTable {

  static final public CssSymbolTable instance = new CssSymbolTable();

  private CssSymbolTable() {}

  private Set<String> definedSelectors = new HashSet<>();
  private Set<String> definedClasses = new HashSet<>();
  private Set<String> definedIds = new HashSet<>();

  private Set<String> usedSelectors = new HashSet<>();
  private Set<String> usedClassesInHtml = new HashSet<>();
  private Set<String> usedIdsInHtml = new HashSet<>();

  // =========================
  // NORMALIZATION HELPERS
  // =========================

  private String normalizeClass(String value) {
    if (value == null) return "";

    value = value.replace("\"", "").trim();

    if (value.startsWith(".")) {
      value = value.substring(1);
    }

    return value;
  }

  private String normalizeId(String value) {
    if (value == null) return "";

    value = value.replace("\"", "").trim();

    if (value.startsWith("#")) {
      value = value.substring(1);
    }

    return value;
  }

  private String normalizeSelector(String value) {
    if (value == null) return "";

    value = value.replace("\"", "").trim();

    // element selectors like button, img stay as-is
    // but we still remove accidental spaces
    return value;
  }

  public void defineSelector(String selector) {
    definedSelectors.add(normalizeSelector(selector));
  }

  public void defineClass(String className) {
    definedClasses.add(normalizeClass(className));
  }

  public void defineId(String idName) {
    definedIds.add(normalizeId(idName));
  }


  public void setUsedHtmlSelectors(Set<String> classes,
      Set<String> ids,
      Set<String> selectors) {

    for (String c : classes) {
      usedClassesInHtml.add(normalizeClass(c));
    }

    for (String i : ids) {
      usedIdsInHtml.add(normalizeId(i));
    }

    for (String s : selectors) {
      usedSelectors.add(normalizeSelector(s));
    }
  }

  public void performCrossCheck() {

    System.out.println("=== CSS <-> HTML Cross-Reference Analysis ===");

    boolean issuesFound = false;

    for (String cssClass : definedClasses) {
      if (!usedClassesInHtml.contains(cssClass)) {
        System.out.println(
            "WARNING: CSS class '" + cssClass +
                "' is defined but NOT used in HTML (Dead Code).");
        issuesFound = true;
      }
    }

    for (String cssId : definedIds) {
      if (!usedIdsInHtml.contains(cssId)) {
        System.out.println(
            "WARNING: CSS id '" + cssId +
                "' is defined but NOT used in HTML (Dead Code).");
        issuesFound = true;
      }
    }

    if (!issuesFound) {
      System.out.println("SUCCESS: CSS and HTML are perfectly synced!");
    }
  }

  public void reset() {
    definedSelectors.clear();
    definedClasses.clear();
    definedIds.clear();

    usedSelectors.clear();
    usedClassesInHtml.clear();
    usedIdsInHtml.clear();
  }

  public void printTable() {

    System.out.println("\n================ CSS SYMBOL TABLE SNAPSHOT ================");

    for (String selector : definedSelectors) {
      System.out.println(selector + " | SELECTOR");
    }

    for (String cls : definedClasses) {
      System.out.println(cls + " | CLASS");
    }

    for (String id : definedIds) {
      System.out.println(id + " | ID");
    }

    System.out.println("\n================ ANALYSIS =================");

    System.out.println("Selectors: " + definedSelectors.size());
    System.out.println("Classes:   " + definedClasses.size());
    System.out.println("IDs:       " + definedIds.size());

    System.out.println("Used Classes: " + usedClassesInHtml.size());
    System.out.println("Used IDs:     " + usedIdsInHtml.size());
  }
}