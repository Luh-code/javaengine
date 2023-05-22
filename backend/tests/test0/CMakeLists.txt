cmake_minimum_required(VERSION 3.1)
include(CTest)

enable_testing()

file(GLOB testSrcFiles
  ./src/*.h
  ./src/**/*.h
  ./src/*.hpp
  ./src/**/*.hpp
  ./src/*.c
  ./src/**/*.c
  ./src/*.cpp
  ./src/**/*.cpp
)

add_executable(test0exec ${testSrcFiles})
target_include_directories(test0exec PUBLIC ${PROJECT_SOURCE_DIR}/src/include)
target_link_libraries(test0exec PUBLIC ${PROJECT_SOURCE_DIR}/bin/lib/libJEBase.so)
target_compile_options(test0exec PRIVATE -Wall)
add_test(test0exec ../bin/test0exec)
