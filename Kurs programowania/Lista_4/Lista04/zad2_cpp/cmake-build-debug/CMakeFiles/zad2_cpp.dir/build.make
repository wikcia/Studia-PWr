# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.21

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

# Disable VCS-based implicit rules.
% : %,v

# Disable VCS-based implicit rules.
% : RCS/%

# Disable VCS-based implicit rules.
% : RCS/%,v

# Disable VCS-based implicit rules.
% : SCCS/s.%

# Disable VCS-based implicit rules.
% : s.%

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = "/Users/wiktoriapazdzierniak/Library/Application Support/JetBrains/Toolbox/apps/CLion/ch-0/213.6777.58/CLion.app/Contents/bin/cmake/mac/bin/cmake"

# The command to remove a file.
RM = "/Users/wiktoriapazdzierniak/Library/Application Support/JetBrains/Toolbox/apps/CLion/ch-0/213.6777.58/CLion.app/Contents/bin/cmake/mac/bin/cmake" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/wiktoriapazdzierniak/Downloads/zad2_cpp

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/wiktoriapazdzierniak/Downloads/zad2_cpp/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/zad2_cpp.dir/depend.make
# Include any dependencies generated by the compiler for this target.
include CMakeFiles/zad2_cpp.dir/compiler_depend.make

# Include the progress variables for this target.
include CMakeFiles/zad2_cpp.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/zad2_cpp.dir/flags.make

CMakeFiles/zad2_cpp.dir/main.cpp.o: CMakeFiles/zad2_cpp.dir/flags.make
CMakeFiles/zad2_cpp.dir/main.cpp.o: ../main.cpp
CMakeFiles/zad2_cpp.dir/main.cpp.o: CMakeFiles/zad2_cpp.dir/compiler_depend.ts
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/wiktoriapazdzierniak/Downloads/zad2_cpp/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/zad2_cpp.dir/main.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -MD -MT CMakeFiles/zad2_cpp.dir/main.cpp.o -MF CMakeFiles/zad2_cpp.dir/main.cpp.o.d -o CMakeFiles/zad2_cpp.dir/main.cpp.o -c /Users/wiktoriapazdzierniak/Downloads/zad2_cpp/main.cpp

CMakeFiles/zad2_cpp.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/zad2_cpp.dir/main.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/wiktoriapazdzierniak/Downloads/zad2_cpp/main.cpp > CMakeFiles/zad2_cpp.dir/main.cpp.i

CMakeFiles/zad2_cpp.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/zad2_cpp.dir/main.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/wiktoriapazdzierniak/Downloads/zad2_cpp/main.cpp -o CMakeFiles/zad2_cpp.dir/main.cpp.s

# Object files for target zad2_cpp
zad2_cpp_OBJECTS = \
"CMakeFiles/zad2_cpp.dir/main.cpp.o"

# External object files for target zad2_cpp
zad2_cpp_EXTERNAL_OBJECTS =

zad2_cpp: CMakeFiles/zad2_cpp.dir/main.cpp.o
zad2_cpp: CMakeFiles/zad2_cpp.dir/build.make
zad2_cpp: CMakeFiles/zad2_cpp.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/wiktoriapazdzierniak/Downloads/zad2_cpp/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable zad2_cpp"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/zad2_cpp.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/zad2_cpp.dir/build: zad2_cpp
.PHONY : CMakeFiles/zad2_cpp.dir/build

CMakeFiles/zad2_cpp.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/zad2_cpp.dir/cmake_clean.cmake
.PHONY : CMakeFiles/zad2_cpp.dir/clean

CMakeFiles/zad2_cpp.dir/depend:
	cd /Users/wiktoriapazdzierniak/Downloads/zad2_cpp/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/wiktoriapazdzierniak/Downloads/zad2_cpp /Users/wiktoriapazdzierniak/Downloads/zad2_cpp /Users/wiktoriapazdzierniak/Downloads/zad2_cpp/cmake-build-debug /Users/wiktoriapazdzierniak/Downloads/zad2_cpp/cmake-build-debug /Users/wiktoriapazdzierniak/Downloads/zad2_cpp/cmake-build-debug/CMakeFiles/zad2_cpp.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/zad2_cpp.dir/depend

