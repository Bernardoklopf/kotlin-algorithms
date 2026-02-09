# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Kotlin algorithm practice project using **IntelliJ IDEA's built-in compiler** (no Gradle or Maven). The project focuses on implementing and testing common algorithms and data structures.

## Build System

**Important**: This project does NOT use Gradle or Maven. It uses IntelliJ's native Kotlin compiler with library dependencies managed through IntelliJ's library system (`.idea/libraries/*.xml`).

### Kotlin Configuration
- **Kotlin Version**: 2.2.21
- **Language/API Version**: 2.2
- **JVM Target**: 1.8
- **Libraries**:
  - `KotlinJavaRuntime` - Standard library
  - `KotlinTestJUnit5` - Test framework (scope: TEST)

## Project Structure

```
src/           - Algorithm implementations (production code)
test/          - Test files using kotlin.test and JUnit 5
resources/     - Resource files (if needed)
testResources/ - Test resource files (if needed)
out/           - Compiled output (gitignored)
```

## Running Code

### Run Main Application
Use IntelliJ's run configuration or right-click `src/Main.kt` → Run. The Main.kt file contains example calls to demonstrate algorithm implementations.

### Run Tests
- **All tests**: Right-click `test/` directory → Run 'All Tests'
- **Single test class**: Right-click the test file → Run 'TestClassName'
- **Single test method**: Click the green arrow next to the `@Test` annotation

## Testing

Tests use `kotlin.test` with JUnit 5:
```kotlin
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class ExampleTest {
    @Test
    fun `descriptive test name`() {
        assertEquals(expected, actual)
    }
}
```

Test files mirror the structure of source files (e.g., `binarySearch.kt` → `BinarySearchTest.kt`).

## Adding New Algorithms

1. Create implementation file in `src/` (e.g., `src/newAlgorithm.kt`)
2. Implement the algorithm as a top-level function or class
3. Create corresponding test file in `test/` (e.g., `test/NewAlgorithmTest.kt`)
4. Add example usage to `Main.kt` if demonstrating the algorithm

## Adding Libraries

To add a new library dependency:

1. Create a new library XML file in `.idea/libraries/` (follow the pattern of existing files)
2. For Maven dependencies, use `type="repository"` with `maven-id` property
3. Add the library to `aw.iml` as an `<orderEntry>` with appropriate scope (`TEST` for test-only dependencies)
4. Reload the project in IntelliJ to download the JARs

Example library entry in `.idea/libraries/SomeLibrary.xml`:
```xml
<component name="libraryTable">
  <library name="SomeLibrary" type="repository">
    <properties maven-id="group:artifact:version" />
    <CLASSES>
      <root url="jar://$MAVEN_REPOSITORY$/path/to/jar!/" />
    </CLASSES>
  </library>
</component>
```

## Code Style

- Use descriptive function names that explain what the algorithm does
- Top-level functions are preferred for simple algorithms
- Use backtick test names for readability: `` `should return true for valid input` ``
- Keep algorithm implementations focused and single-purpose
