cmake_minimum_required(VERSION 3.1)
project(backend VERSION 1.0 LANGUAGES C CXX)
include(CTest)

# Ensures that we do an out of source build

MACRO(MACRO_ENSURE_OUT_OF_SOURCE_BUILD MSG)
     STRING(COMPARE EQUAL "${CMAKE_SOURCE_DIR}"
     "${CMAKE_BINARY_DIR}" insource)
     GET_FILENAME_COMPONENT(PARENTDIR ${CMAKE_SOURCE_DIR} PATH)
     STRING(COMPARE EQUAL "${CMAKE_SOURCE_DIR}"
     "${PARENTDIR}" insourcesubdir)
    IF(insource OR insourcesubdir)
        MESSAGE(FATAL_ERROR "${MSG}")
    ENDIF(insource OR insourcesubdir)
ENDMACRO(MACRO_ENSURE_OUT_OF_SOURCE_BUILD)

MACRO_ENSURE_OUT_OF_SOURCE_BUILD(
"${CMAKE_PROJECT_NAME} requires an out of source build.")

set(CMAKE_BUILD_TYPE Debug)

set(CMAKE_C_COMILER "clang")
set(CMAKE_CXX_COMILER "clang++")

set(CMAKE_C_STANDARD 17)
set(CMAKE_C_EXTENSIONS OFF)
set(CMAKE_C_STANDARD_REQUIRED ON)

set(CMAKE_CXX_STANDARD 23)
set(CMAKE_CXX_EXTENSIONS OFF)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

set(CMAKE_CURRENT_BINARY_DIR ../bin)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ../bin)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ../bin/lib)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ../bin/lib)

file(GLOB JEBaseSrcFiles
  ${PROJECT_SOURCE_DIR}/src/*.h
  ${PROJECT_SOURCE_DIR}/src/**/*.h
  ${PROJECT_SOURCE_DIR}/src/*.hpp
  ${PROJECT_SOURCE_DIR}/src/**/*.hpp
  ${PROJECT_SOURCE_DIR}/src/*.c
  ${PROJECT_SOURCE_DIR}/src/**/*.c
  ${PROJECT_SOURCE_DIR}/src/*.cpp
  ${PROJECT_SOURCE_DIR}/src/**/*.cpp
)

set (JAVA_HOME /usr/lib/jvm/java-20-openjdk)

add_library(JEBase SHARED ${JEBaseSrcFiles})
set_target_properties(JEBase PROPERTIES LINKER_LANGUAGE CXX)
target_include_directories(JEBase PUBLIC ${JAVA_HOME}/include ${JAVA_HOME}/include/linux)

enable_testing()
add_subdirectory(${PROJECT_SOURCE_DIR}/tests)
