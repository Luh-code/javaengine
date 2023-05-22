package ecs;

public class ECS {
  public static native int getMAX_ENTITIES();
  public static native int getMAX_COMPONENTS();



  static {
    System.loadLibrary("ECS");
  }
}
