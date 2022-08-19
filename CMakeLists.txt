# minimum required CMAKE version
CMAKE_MINIMUM_REQUIRED(VERSION 3.7 FATAL_ERROR)
project(VInstrument)

list(APPEND CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/cmake)

# compiler must be 17
set(CMAKE_CXX_STANDARD 17)

# required if linking to static library
add_definitions(-DANTLR4CPP_STATIC)

# using /MD flag for antlr4_runtime (for Visual C++ compilers only)
set(ANTLR4_WITH_STATIC_CRT OFF)

# Specify the version of the antlr4 library needed for this project.
# By default the latest version of antlr4 will be used.  You can specify a
# specific, stable version by setting a repository tag value or a link
# to a zip file containing the libary source.
# set(ANTLR4_TAG 4.10.1)
# set(ANTLR4_ZIP_REPOSITORY https://github.com/antlr/antlr4/archive/refs/tags/4.10.1.zip)

# add external build for antlrcpp
include(ExternalAntlr4Cpp)
# add antrl4cpp artifacts to project environment
include_directories(${ANTLR4_INCLUDE_DIRS})

# set variable pointing to the antlr tool that supports C++
# this is not required if the jar file can be found under PATH environment
if(DEFINED ENV{ANTLR_EXECUTABLE})
    set(ANTLR_EXECUTABLE $ENV{ANTLR_EXECUTABLE})
else()
    set(ANTLR_EXECUTABLE /usr/local/lib/antlr-4.10.1-complete.jar)
endif()
# add macros to generate ANTLR Cpp code from grammar
find_package(ANTLR REQUIRED)

# Call macro to add lexer and grammar to your build dependencies.
antlr_target(VGrammarParser V.g4 VISITOR
             # DEPENDS_ANTLR VGrammarLexer
             OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/libs/)

include_directories(${PROJECT_SOURCE_DIR}/test/
                    ${PROJECT_SOURCE_DIR}/test/ParseTester/
                    ${PROJECT_SOURCE_DIR}/ast/
                    ${PROJECT_SOURCE_DIR}/visitor/
                    ${PROJECT_SOURCE_DIR}/libs/
   )

set(BOOST_ROOT ${BOOST_ROOT}) # either set it here or from the command line  
set(Boost_USE_STATIC_LIBS OFF) 
set(Boost_USE_MULTITHREADED ON)  
set(Boost_USE_STATIC_RUNTIME OFF) 
# find_package(Boost REQUIRED)
find_package(Boost REQUIRED COMPONENTS filesystem)

# include boost
include_directories(${BOOST_ROOT})

# add generated grammar to instrument binary target
add_executable(instrument main.cpp
               test/ParseTester/ParseTester.cpp
               ast/VAST.cpp
               visitor/VASTVisitor.cpp
               ${ANTLR_VGrammarParser_CXX_OUTPUTS})
target_link_libraries(instrument antlr4_static)
target_include_directories(instrument PUBLIC ${Boost_INCLUDE_DIRS}) 
target_link_libraries(instrument ${Boost_LIBRARIES})
target_link_libraries(instrument Boost::filesystem)
