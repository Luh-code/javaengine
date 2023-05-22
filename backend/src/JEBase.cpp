#include "include/libtest/JEBase.h"
#include "include/libtest/lib.h"

JNIEXPORT void JNICALL Java_JEBase_doSomething
  (JNIEnv *, jobject)
{
  doSomething(5);
}
