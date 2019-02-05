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

  private def adjustSetupByMonkeyFault(countFailed: Boolean): Boolean = if (!countFailed) true else countFailed

  private def areMonkeysTouching: Int => Boolean = _ => {
    monkeyTouching match {
      case s: ControlPanelSetup if s == setup => true
      case _ => throw new MonkeyTouchingException
    }
  }

  private def checkSetup(setup: ControlPanelSetup): Boolean = setup match {
    case NoSetup => false
    case _ => true
  }

  def launcherRocket: String = {
    if (checkSetup(setup)) {
      if (countDown.reverse
        .map(areMonkeysTouching)
        .map(adjustSetupByMonkeyFault)
        .forall(p => p))
        "COHETE LANZADO" else ""
    } else ""
  }


}
