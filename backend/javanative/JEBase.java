class JEBase {
  private native void doSomething();

  /*public static void main(String[] args) {
    new JEBase().print();
  }*/

  static {
    System.loadLibrary("JEBase");
  }
}
