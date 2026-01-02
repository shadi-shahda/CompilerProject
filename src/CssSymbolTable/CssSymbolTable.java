package CssSymbolTable;

import java.util.*;

public class CssSymbolTable {
  private Set<String> definedClasses = new HashSet<>();
  private Set<String> definedIds = new HashSet<>();

  private Set<String> usedClassesInHtml = new HashSet<>();
  private Set<String> usedIdsInHtml = new HashSet<>();

  public void defineClass(String className) {
    definedClasses.add(className);
  }

  public void defineId(String idName) {
    definedIds.add(idName);
  }

  public void setUsedHtmlSelectors(Set<String> classes, Set<String> ids) {
    this.usedClassesInHtml.addAll(classes);
    this.usedIdsInHtml.addAll(ids);
  }

  public void performCrossCheck() {
    System.out.println("=== CSS <-> HTML Cross-Reference Analysis ===");

    boolean issuesFound = false;

    for (String htmlClass : usedClassesInHtml) {
      if (!definedClasses.contains(htmlClass)) {
        System.out.println("WARNING: HTML uses class '" + htmlClass + "' but it is NOT defined in style.css");
        issuesFound = true;
      }
    }

    for (String cssClass : definedClasses) {
      if (!usedClassesInHtml.contains(cssClass)) {
        System.out.println("INFO: CSS class '" + cssClass + "' is defined but NOT used in any HTML file (Dead Code).");
        issuesFound = true;
      }
    }

    if (!issuesFound) {
      System.out.println("SUCCESS: CSS and HTML are perfectly synced!");
    }
  }

  public void printTable() {
    System.out.println("\n======================== CSS SYMBOL TABLE SNAPSHOT ========================");
    System.out.println(String.format("| %-30s | %-15s | %-15s |", "SELECTOR NAME", "TYPE", "SCOPE"));
    System.out.println("---------------------------------------------------------------------------");

    for (String className : definedClasses) {
      System.out.println(String.format("| %-30s | %-15s | %-15s |",
          className, "CSS CLASS", "Global"));
    }

    for (String idName : definedIds) {
      System.out.println(String.format("| %-30s | %-15s | %-15s |",
          idName, "CSS ID", "Global"));
    }

    System.out.println("---------------------------------------------------------------------------");

    System.out.println("[Analysis Summary]");
    System.out.println("Total Classes Defined: " + definedClasses.size());
    System.out.println("Total IDs Defined:     " + definedIds.size());
    System.out.println("Used in HTML:          " + (usedClassesInHtml.size() + usedIdsInHtml.size()) + " selectors");

    System.out.println("===========================================================================");
  }
}