class JEBase {
  public static native int doSomething(int input);

  /*public static void main(String[] args) {
    new JEBase().print();
  }*/

  static {
    System.loadLibrary("JEBase");
  }
}
