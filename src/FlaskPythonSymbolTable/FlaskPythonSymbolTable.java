package FlaskPythonSymbolTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class FlaskPythonSymbolTable {
  // المكدس يمثل النطاقات الحالية المفتوحة (Global -> Local)
  private Stack<Map<String, FlaskPythonSymbol>> scopes;

  // قائمة لحفظ كل الرموز التي تم تعريفها لطباعتها في النهاية
  private List<FlaskPythonSymbol> allSymbols;

  private int currentScopeLevel;

  public FlaskPythonSymbolTable() {
    scopes = new Stack<>();
    allSymbols = new ArrayList<>();
    currentScopeLevel = 0;

    // البدء بالنطاق العام (Global Scope)
    enterScope();
  }

  // 1. فتح نطاق جديد (عند دخول دالة)
  public void enterScope() {
    scopes.push(new HashMap<>());
    currentScopeLevel++;
  }

  // 2. إغلاق النطاق الحالي (عند نهاية الدالة)
  public void exitScope() {
    if (!scopes.isEmpty()) {
      scopes.pop();
      currentScopeLevel--;
    }
  }

  // 3. تعريف رمز جديد
  public void define(String name, String type) {
    Map<String, FlaskPythonSymbol> currentScope = scopes.peek();

    // إذا لم يكن موجوداً في النطاق الحالي، نضيفه
    if (!currentScope.containsKey(name)) {
      // التصحيح: مستوى النطاق يبدأ من 0 للـ Global
      // (بما أننا زدنا الـ level عند الإنشاء، النطاق العام سيكون 1، سنطرح 1 للتوضيح)
      FlaskPythonSymbol symbol = new FlaskPythonSymbol(name, type, currentScopeLevel - 1);
      currentScope.put(name, symbol);

      // نضيفه للقائمة التاريخية للطباعة
      allSymbols.add(symbol);
    }
  }

  // 4. البحث عن رمز (Look up)
  public FlaskPythonSymbol resolve(String name) {
    // نبحث من النطاق الحالي (الأعلى في المكدس) نزولاً للعام
    for (int i = scopes.size() - 1; i >= 0; i--) {
      if (scopes.get(i).containsKey(name)) {
        return scopes.get(i).get(name);
      }
    }
    return null;
  }

  // 5. طباعة الجدول كاملاً
  public void printTable() {
    System.out.println("\n=== Symbol Table ===");
    System.out.println("------------------------------------------------");
    System.out.printf("| %-15s | %-15s | %-5s |\n", "Name", "Type", "Scope");
    System.out.println("------------------------------------------------");
    for (FlaskPythonSymbol s : allSymbols) {
      System.out.println(s);
    }
    System.out.println("------------------------------------------------\n");
  }
}
