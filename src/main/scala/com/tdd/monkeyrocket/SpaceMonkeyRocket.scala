package com.tdd.monkeyrocket

import com.tdd.monkeyrocket.Setup.{ControlPanelSetup, DefaultSetup, NoSetup}

object SpaceMonkeyRocket {
  def apply(setup: ControlPanelSetup, countDown: Seq[Int]): SpaceMonkeyRocket = setup match {
    case NoSetup => throw  new IllegalArgumentException("Not Setup")
    case null => new SpaceMonkeyRocket(DefaultSetup, countDown)
    case _ => new SpaceMonkeyRocket(setup, countDown)
  }
}

class SpaceMonkeyRocket(val setup: ControlPanelSetup, val countDown: Seq[Int] = 1 to 10) {

  import com.tdd.monkeyrocket.MonkeyTouchingLikeCrazy.monkeyTouching

  private def adjustSetupByMonkeyFault(countFailed: Boolean): Boolean =
    if (!countFailed) throw new MonkeyTouchingException else countFailed

  private def areMonkeysTouching: Int => Boolean = _ => {
    monkeyTouching match {
      case s: ControlPanelSetup if s == setup => true
      case _ => false
    }
  }

  private def checkSetup(setup: ControlPanelSetup): Boolean = setup match {
    case NoSetup => false
    case _ => true
  }

  private def checkIfHaveRulesOrAnarchy(monkeysRules: Option[Int => Boolean]): Int => Boolean = monkeysRules match {
    case Some(f) => f
    case None => areMonkeysTouching
  }

  def launcherRocket(monkeysRules: Option[Int => Boolean]): String = {
      if (countDown.reverse
        .map(checkIfHaveRulesOrAnarchy(monkeysRules))
        .map(adjustSetupByMonkeyFault)
        .forall(p => p))
        "COHETE LANZADO" else ""
  }


}
