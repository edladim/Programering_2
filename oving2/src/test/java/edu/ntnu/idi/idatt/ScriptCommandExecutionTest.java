package src.test.java.edu.ntnu.idi.idatt;

import src.main.java.edu.ntnu.idi.idatt.Capitalize.CapitalizeTextCommand;
import src.main.java.edu.ntnu.idi.idatt.replace.ReplaceTextCommand;
import src.main.java.edu.ntnu.idi.idatt.wrap.WrapTextCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import src.main.java.edu.ntnu.idi.idatt.Script;
import src.main.java.edu.ntnu.idi.idatt.TextCommand;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Script Tests")
class ScriptTest {

  @Test
  @DisplayName("Should execute single command")
  void testSingleCommand() {
    List<TextCommand> commands = Arrays.asList(
        new ReplaceTextCommand("world", "universe")
    );
    Script script = new Script(commands);
    assertEquals("hello universe", script.execute("hello world"));
  }

  @Test
  @DisplayName("Should execute multiple commands in sequence")
  void testMultipleCommands() {
    List<TextCommand> commands = Arrays.asList(
        new ReplaceTextCommand("world", "universe"),
        new WrapTextCommand("<", ">")
    );
    Script script = new Script(commands);
    assertEquals("<hello universe>", script.execute("hello world"));
  }

  @Test
  @DisplayName("Should execute three commands in sequence")
  void testThreeCommands() {
    List<TextCommand> commands = Arrays.asList(
        new ReplaceTextCommand("world", "there"),
        new CapitalizeTextCommand(),
        new WrapTextCommand("[", "]")
    );
    Script script = new Script(commands);
    assertEquals("[Hello there]", script.execute("hello world"));
  }

  @Test
  @DisplayName("Should handle empty command list")
  void testEmptyCommandList() {
    List<TextCommand> commands = Collections.emptyList();
    Script script = new Script(commands);
    assertEquals("hello world", script.execute("hello world"));
  }

  @Test
  @DisplayName("Should execute commands in correct order")
  void testCommandOrder() {
    // Først wrap, så replace - ordre er viktig!
    List<TextCommand> commands = Arrays.asList(
        new WrapTextCommand("<", ">"),
        new ReplaceTextCommand("hello", "hi")
    );
    Script script = new Script(commands);
    assertEquals("<hi>", script.execute("hello"));
  }

  @Test
  @DisplayName("Should handle complex transformation chain")
  void testComplexChain() {
    List<TextCommand> commands = Arrays.asList(
        new ReplaceTextCommand("hello", "hi"),
        new ReplaceTextCommand("world", "there"),
        new CapitalizeTextCommand(),
        new WrapTextCommand("**", "**")
    );
    Script script = new Script(commands);
    assertEquals("**Hi there**", script.execute("hello world"));
  }

  // Feilhåndtering
  @Test
  @DisplayName("Should throw exception when commands list is null")
  void testNullCommandsList() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      new Script(null);
    });
    assertEquals("Text commands list cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception when text is null")
  void testNullText() {
    List<TextCommand> commands = Arrays.asList(new ReplaceTextCommand("a", "b"));
    Script script = new Script(commands);
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      script.execute(null);
    });
    assertEquals("Text cannot be null", exception.getMessage());
  }

  @Test
  @DisplayName("Should throw exception when command in list is null")
  void testNullCommandInList() {
    List<TextCommand> commands = Arrays.asList(
        new ReplaceTextCommand("a", "b"),
        null
    );
    Script script = new Script(commands);
    Exception exception = assertThrows(IllegalStateException.class, () -> {
      script.execute("test");
    });
    assertEquals("Command in list cannot be null", exception.getMessage());
  }
}
