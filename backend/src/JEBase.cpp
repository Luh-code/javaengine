#include "include/libtest/JEBase.h"
#include "include/libtest/lib.h"

JNIEXPORT jint JNICALL Java_JEBase_doSomething
  (JNIEnv *, jclass, jint value)
{
  return doSomething((uint32_t)value);
}
