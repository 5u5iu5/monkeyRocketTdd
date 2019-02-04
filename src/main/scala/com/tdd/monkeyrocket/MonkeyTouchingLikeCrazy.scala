package com.tdd.monkeyrocket

import com.tdd.monkeyrocket.Setup._

import scala.util.Random

object MonkeyTouchingLikeCrazy {
  def monkeyTouching: ControlPanelSetup = Random.nextInt(4) match {
    case 0 => DefaultSetup
    case 1 => MediumSetup
    case 2 => ComplexSetup
    case 3 => CrazySetup
    case _ => monkeyTouching
  }
}
