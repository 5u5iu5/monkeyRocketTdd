package com.tdd.monkeyrocket

import com.tdd.monkeyrocket.Setup.{ControlPanelSetup, NoSetup}

case class SpaceMonkeyRocket(setup: ControlPanelSetup) {

  private val countDown: Seq[Int] = 1 to 10

  import com.tdd.monkeyrocket.MonkeyTouchingLikeCrazy.monkeyTouching

  private def adjustSetupByMonkeyFault(countFailed: Boolean): Boolean = if (!countFailed) true else countFailed

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

  def launcherRocket: Boolean = {
    if (checkSetup(setup)) {
      countDown.reverse
        .map(areMonkeysTouching)
        .map(adjustSetupByMonkeyFault)
        .forall(p => p)
    } else false
  }


}
