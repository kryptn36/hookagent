package facades;

import io.github.kryptn36.hookagent.annotations.ClassMixin;
import io.github.kryptn36.hookagent.annotations.MethodInjection;
import io.github.kryptn36.hookagent.annotations.MethodMixin;

@ClassMixin("de.kryptn36.example.Human")
public class HumanMixin {

  @MethodMixin
  public void talkFast() {

  }

  @MethodInjection
  public void talk() {

  }

}
